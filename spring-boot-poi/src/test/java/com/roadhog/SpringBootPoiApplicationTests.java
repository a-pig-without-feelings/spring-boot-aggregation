package com.roadhog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

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


    public static String DelQuota(String str) {
        String result = str;
        String[] strQuota = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "`", ";", "'", ",", ".", "/", ":", "/,", "<", ">", "?"};
        for (int i = 0; i < strQuota.length; i++) {
            if (result.indexOf(strQuota[i]) > -1)
                result = result.replace(strQuota[i], "");
        }
        return result;
    }

}
