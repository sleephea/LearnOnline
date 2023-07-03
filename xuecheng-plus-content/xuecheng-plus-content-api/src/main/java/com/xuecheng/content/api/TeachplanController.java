package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.service.TeachplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 15281
 * @date 2023-06-15 20:29:42
 * @description 课程计划管理相关的接口（控制器）
 */
@Api(value = "课程计划管理相关的接口", tags = "课程计划管理相关的接口")
@RestController
public class TeachplanController {
    //查询数据接口

    @Resource
    TeachplanService teachplanService;

    /**
     * 查询课程计划数形结构
     * @param courseId
     * @return
     */
    @ApiOperation("查询课程计划数形结构")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId){
        List<TeachplanDto> teachplanTree = teachplanService.findTeachplanTree(courseId);

        return teachplanTree;
    }

    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void saveTeachplan(@RequestBody SaveTeachplanDto saveTeachplanDto){
        teachplanService.saveTeachplan(saveTeachplanDto);
    }
}
