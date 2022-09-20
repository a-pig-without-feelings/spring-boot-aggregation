package com.roadhog;

import com.csvreader.CsvWriter;
import com.roadhog.domin.User;
import com.roadhog.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

@SpringBootTest
class SpringBootPoiApplicationTests {

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
    void cvsTest(){
        try {
            String csvFilePath = "D:\\java265\\test.csv";
            CsvWriter writer =new CsvWriter(csvFilePath,',', Charset.forName("utf-8"));
            String[] contents = {"maomao","java265","最爱java"};
            writer.writeRecord(contents,true);//写一行，3列  ,true表示写完换行
            writer.writeRecord(contents,false);//再写一行，3列  ,false写完不换行，只要不close就能一直写。
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void listTest(){
        List<User> userList = new ArrayList<User>();
        User user01 = new User("xiabin", 12);
        User user02 = new User("xiahuo", 13);
        User user03 = new User("xiashui", 14);
        userList.add(user01);
        userList.add(user02);
        userList.add(user03);
        System.out.println(userList);
        for (User user : userList) {
            System.out.println(user);
            Field[] fields = user.getClass().getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
                System.out.println("----------");
            }
        }


    }

}
