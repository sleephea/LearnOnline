package com.xuecheng.content;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 15281
 * @date 2023-06-15 21:22:54
 * @description
 */
@SpringBootTest
public class TestplanMapperTests {

    @Resource
    TeachplanMapper teachplanMapper;

    @Test
    public void testCourseCategortMapper(){
        List<TeachplanDto> courseCategoryTreeDtos = teachplanMapper.selectTreeNodes(117L);
        System.out.println(courseCategoryTreeDtos);
    }

}
