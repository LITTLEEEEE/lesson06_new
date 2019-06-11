package cn.edu.bussiness.stuinfo.data;

import cn.edu.bussiness.stuinfo.entity.StuInfo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MockStuInfo {

    static List<StuInfo> stu = new ArrayList<StuInfo>();

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse("2019-03-21 23:22:11");
        }catch (Exception e){

        }
        StuInfo stu1 = new StuInfo(1, date, "张三", "20100325", null, 1, 1);
        StuInfo stu2 = new StuInfo(1, date, "李四", "20100326", null, 1, 1);
        StuInfo stu3 = new StuInfo(1, date, "王五", "20100327", null, 1, 1);
        StuInfo stu4 = new StuInfo(1, date, "赵六", "20100328", null, 1, 1);
        stu.add(stu1);
        stu.add(stu2);
        stu.add(stu3);
        stu.add(stu4);
    }

    /**
     * day  name code    operate online
     * 2019-03-21 23:22:11  李四   20100823    2   1
     * 2019-03-21 23:22:11  李四   20100823    0   1
     * 2019-03-21 23:22:11  张三   20100833    0   1
     * @param args
     */
    public static void main(String[] args) {

        BufferedOutputStream inputStream = null;
        try {
            File file = new File("d:\\2019.LOG");
            if(!file.exists())
                file.createNewFile();
            inputStream = new BufferedOutputStream(new FileOutputStream(file));
            String line = "";
            Random ran = new Random();
            String dateStr = "2019-03-21 23:22:11";
            StuInfo s = null;
            while(true){
                int index = ran.nextInt(4);
                s = stu.get(index);
                line = dateStr + "\t" + s.getName() + "\t" + s.getCode() + "\t" + ran.nextInt(3) + "\t" + 1 + "\r\n";
                inputStream.write(line.getBytes());
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != inputStream) {
                try {
                    inputStream.flush();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }


}
