package com.xuecheng.content.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 15281
 * @date 2023-06-15 15:47:23
 * @description 修改课程模型对象
 */
@Data
public class EditCourseDto extends AddCourseDto{
    @ApiModelProperty(value = "课程id",required = true)
    private Long id;
}
