package com.xuecheng.media;

import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author 15281
 * @date 2023-06-17 19:11:30
 * @description 测试minio
 */
public class MinioTest {

    static MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://192.168.1.116:9000")
                    .credentials("minio_root", "minio_123456")
                    .build();


    //上传文件
    @Test
    public void upload() {
        try {
            UploadObjectArgs testbucket = UploadObjectArgs.builder()
                    .bucket("mediafiles")
                    .object("002/test001.mp4")//添加子目录
                    .filename("D://OJ//demo08.java")
//
                    .build();
            minioClient.uploadObject(testbucket);
            System.out.println("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
    }


}
