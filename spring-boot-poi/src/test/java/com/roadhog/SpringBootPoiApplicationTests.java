package com.roadhog;

import com.roadhog.domin.StudentForTest;
import com.roadhog.utils.CsvUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    void csvTest() {
        StudentForTest s = new StudentForTest();
        s.setAge(21);
        s.setEmail("11");
        s.setName("yaochongwei");
        s.setPhone("157");
        s.setSex("1");

        StudentForTest s1 = new StudentForTest();
        s1.setAge(22);
        s1.setEmail("11");
        s1.setName("yaochongwei");
        s1.setPhone("157");
        s1.setSex("0");
        List<StudentForTest> l = new ArrayList<StudentForTest>();
        l.add(s);
        l.add(s1);
        String csvFilePath = "E://yaochongwei.csv";
        String[] csvHeaders = {"年龄", "邮件", "姓名", "手机", "性别"};
        CsvUtils.writeCSV(l, csvFilePath, csvHeaders);
    }

    //导出到csv文件
    public static void Array2CSV(ArrayList<ArrayList<String>> data, String path) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            for (int i = 0; i < data.size(); i++) {
                ArrayList<String> onerow = data.get(i);
                for (int j = 0; j < onerow.size(); j++) {
                    out.write(DelQuota(onerow.get(j)));
                    out.write(",");
                }
                out.newLine();
            }
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    @Test
    void main() {
            StudentForTest s=new StudentForTest();
            s.setAge(21);
            s.setEmail("11");
            s.setName("yaochongwei");
            s.setPhone("157");
            s.setSex("1");

            StudentForTest s1=new StudentForTest();
            s1.setAge(22);
            s1.setEmail("11");
            s1.setName("yaochongwei");
            s1.setPhone("157");
            s1.setSex("0");

            List<StudentForTest> l=new ArrayList<StudentForTest>();
            l.add(s);
            l.add(s1);

            /*以上为测试用Arraylist数据*/

            String csvFilePath = "D://yaochongwei.csv";

            String[] csvHeaders = { "年龄", "邮件", "姓名","手机","性别" };

            CsvUtils.writeCSV(l,csvFilePath,csvHeaders);
    }
}
