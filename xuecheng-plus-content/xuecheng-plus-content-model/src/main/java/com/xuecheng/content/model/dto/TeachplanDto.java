package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 15281
 * @date 2023-06-15 20:25:54
 * @description 课程计划信息模型类
 */
@Data
@ToString
public class TeachplanDto extends Teachplan {
    //与媒资关联的信息
    private TeachplanMedia teachplanMedia;

    //小章节List
    private List<TeachplanDto> teachPlanTreeNodes;
}
