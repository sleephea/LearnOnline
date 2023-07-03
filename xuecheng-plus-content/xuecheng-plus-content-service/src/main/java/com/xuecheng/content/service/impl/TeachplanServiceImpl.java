package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.service.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 15281
 * @date 2023-06-16 11:12:01
 * @description
 */
@Slf4j
@Service
public class TeachplanServiceImpl implements TeachplanService {
    @Resource
    TeachplanMapper teachplanMapper;
    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos;
    }

    /**
     * 获取前端传过来的保存课程计划对象来得到章节数
     * @param saveTeachplanDto
     * @return
     */
    private int getTeachplanCount(SaveTeachplanDto saveTeachplanDto){
        Long parentId = saveTeachplanDto.getParentid();
        Long courseId = saveTeachplanDto.getCourseId();
        LambdaQueryWrapper<Teachplan> teachplanLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teachplanLambdaQueryWrapper = teachplanLambdaQueryWrapper.eq(Teachplan::getCourseId, courseId).eq(Teachplan::getParentid, parentId);
        Integer count = teachplanMapper.selectCount(teachplanLambdaQueryWrapper);
        return count;
    }

    @Override
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        //通过课程计划id来判断是新增还是修改
        Long id = saveTeachplanDto.getId();
        if(id == null){
            //新增
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto,teachplan);
            //确定排序字段,找到同级节点个数，排序字段就是个数+1
            //SELECT count(*) from teachplan where course_id = 117 and parentid = 0
            Integer count =getTeachplanCount(saveTeachplanDto);

            teachplan.setOrderby(count+1);

            teachplanMapper.insert(teachplan);
        }
        else{
            //修改
            Teachplan teachplan = teachplanMapper.selectById(id);
            BeanUtils.copyProperties(saveTeachplanDto,teachplan);
            teachplanMapper.updateById(teachplan);
        }
    }
}
