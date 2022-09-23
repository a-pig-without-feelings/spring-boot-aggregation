package com.roadhog;

import com.roadhog.domin.StudentForTest;
import com.roadhog.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;


import java.io.*;
import java.util.*;

@SpringBootTest
class SpringBootPoiApplicationTests {
    @Autowired
    ExcelUtils excelUtils;

    @Test
    void uuidTest() {
        Random r = new Random();
        char[] tmp = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int pos = r.nextInt(tmp.length);
            char c = tmp[pos];
            sb.append(c);
        }
        System.out.println(sb);
    }


    @Test
    void excelTest() {
        StudentForTest s = new StudentForTest();
        s.setAge(21);
        s.setEmail("11");
        s.setName("yaochongwei");
        s.setPhone("15700001111");
        s.setSex("1");

        StudentForTest s1 = new StudentForTest();
        s1.setAge(22);
        s1.setEmail("11");
        s1.setName("yaochongwei");
        s1.setPhone("15799992222");
        s1.setSex("0");

        StudentForTest s3 = new StudentForTest();
        s3.setAge(323);
        s3.setEmail("11");
        s3.setName("yafochongjwei");
        s3.setPhone("15792222");
        s3.setSex("99");

        List<StudentForTest> l = new ArrayList<StudentForTest>();
        l.add(s);
        l.add(s1);
        l.add(s3);
        System.out.println(l.size());


        ArrayList<Map<String, Object>> objects = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("age", l.get(i).getAge());
            objectObjectHashMap.put("email", l.get(i).getEmail());
            objectObjectHashMap.put("name", l.get(i).getName());
            objectObjectHashMap.put("phone", l.get(i).getPhone());
            objectObjectHashMap.put("sex", l.get(i).getSex());
            objects.add(objectObjectHashMap);
        }

        ExcelUtils.getInstance().createExcel(objects, "data001", "shuju");
    }

    @Test
    void multipartFileTest() {
        StudentForTest s = new StudentForTest();
        s.setAge(21);
        s.setEmail("11");
        s.setName("yaochongwei");
        s.setPhone("15700001111");
        s.setSex("1");

        StudentForTest s1 = new StudentForTest();
        s1.setAge(22);
        s1.setEmail("11");
        s1.setName("yaochongwei");
        s1.setPhone("15799992222");
        s1.setSex("0");

        StudentForTest s3 = new StudentForTest();
        s3.setAge(323);
        s3.setEmail("11");
        s3.setName("yafochongjwei");
        s3.setPhone("15792222");
        s3.setSex("99");

        List<StudentForTest> l = new ArrayList<StudentForTest>();
        l.add(s);
        l.add(s1);
        l.add(s3);
        ArrayList<Map<String, Object>> objects = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("age", l.get(i).getAge());
            objectObjectHashMap.put("email", l.get(i).getEmail());
            objectObjectHashMap.put("name", l.get(i).getName());
            objectObjectHashMap.put("phone", l.get(i).getPhone());
            objectObjectHashMap.put("sex", l.get(i).getSex());
            objects.add(objectObjectHashMap);
        }
        excelUtils.createExcel(objects, "data001", "shuju");

    }


    /**
     * @param path
     * @return org.springframework.web.multipart.MultipartFile
     * @description: 根据文件路径，获取MultipartFile对象
     * @author: nisan
     * @date: 2022/1/18 13:08
     */
    public static MultipartFile createMfileByPath(String path) {
        MultipartFile mFile = null;
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);

            String fileName = file.getName();
            fileName = fileName.substring((fileName.lastIndexOf("/") + 1));
            mFile = new MockMultipartFile(fileName, fileName, "APPLICATION_OCTET_STREAM", fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mFile;


    }


}
