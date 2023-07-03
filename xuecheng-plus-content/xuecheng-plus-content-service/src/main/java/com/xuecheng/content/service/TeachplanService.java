package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;

import java.util.List;

/**
 * @author 15281
 * @date 2023-06-16 11:10:27
 * @description 课程计划管理相关接口
 */
public interface TeachplanService {
    /**
     * 根据课程Id查询课程计划
     * @param courseId
     * @return
     */
    public List<TeachplanDto> findTeachplanTree(Long courseId);

    /**
     * 新增/修改/保存
     * @param saveTeachplanDto
     */
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto);
}
