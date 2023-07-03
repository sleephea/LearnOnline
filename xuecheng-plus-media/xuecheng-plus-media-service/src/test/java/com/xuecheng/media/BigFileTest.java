package com.xuecheng.media;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 * @author 15281
 * @date 2023-07-02 20:43:52
 * @description 大文件分块断点续传上传方法
 */
public class BigFileTest {

    // 分块测试
    @Test
    public void testChunk() throws IOException {
        // 源文件
        File sourceFile = new File("D:\\java学习\\1528143818-Java\\Java 进度考试.docx");
        // 分块文件存储路径
        String  chunkFilePath = "D:\\java学习\\chunk";
        // 分块文件大小
        int chunkSize = 1024 * 1024 * 1;
        // 分块文件数目
        int chunkNum = (int)Math.ceil(sourceFile.length() * 1.0 / chunkSize);
        // 使用流从源文件读数据，向分块文件中写数据
        RandomAccessFile ref_r = new RandomAccessFile(sourceFile, "r");
        // 缓存区
        byte[] bytes = new byte[1024];
        for(int i = 0; i < chunkNum; i++){
            File chunkFile = new File(chunkFilePath + i);
            // 分块文件写入流
            RandomAccessFile ref_rw = new RandomAccessFile(chunkFile, "rw");
            int len = -1;
            while((len = ref_r.read(bytes)) != -1){
                ref_rw.write(bytes, 0 ,len);
                if(chunkFile.length() >= chunkSize){
                    break;
                }
            }

        }

    }

    // 将分块合并
    @Test
    public void testMerge() throws FileNotFoundException {
        // 块文件目录
        File chunkFolder = new File("D:\\java学习\\chunk");
        // 源文件
        File sourceFile = new File("D:\\java学习\\1528143818-Java\\Java 进度考试.docx");
        // 合并后的文件
        File mergeFile = new File("D:\\java学习\\1528143818-Java\\Java 进度考试_2.docx");

        // 取出所有的分块文件
        File[] files = chunkFolder.listFiles();

        // 将数组转成list
        List<File> filesList = Arrays.asList(files);

        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });
        //缓存区
        byte[] bytes = new byte[1024];
        // 遍历分块文件， 向合并的文件写
        for(File file : filesList){
            // 读分块的流
            RandomAccessFile raf_r = new RandomAccessFile(file, "r");
            int len = -1;
            while((len = raf_r.read(bytes)) != -1 ){

            }

        }
    }
}
