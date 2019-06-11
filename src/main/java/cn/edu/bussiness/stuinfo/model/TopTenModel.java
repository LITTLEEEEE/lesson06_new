package cn.edu.bussiness.stuinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 "teacher":[{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"}],
 "teacherColumns":[
 {
 "title": "编号",
 "key": "idNum"
 },
 {
 "title": "姓名",
 "key": "name"
 },
 {
 "title": "活跃值",
 "key": "activeValue"
 },
 {
 "title": "在线时长",
 "key": "onlineTime"
 }
 ],
 "student":[{"idNum":"121313","name":"李四","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"},{"idNum":"121313","name":"张三","onlineTime":"12","activeValue":"12"}],
 "studentColumns":[
 {
 "title": "学号",
 "key": "idNum"
 },
 {
 "title": "姓名",
 "key": "name"
 },
 {
 "title": "活跃值",
 "key": "activeValue"
 },
 {
 "title": "在线时长",
 "key": "onlineTime"
 }
 ]
 *
 */
@Data
public class TopTenModel {
    /*column*/
    private List<Column> teacherColumns;
    private List<Column> studentColumns;

    /*data*/
    private List<Info> teacher;
    private List<Info> student;

    /*初始化列*/
    public void initColumn(){
        List<Column> cols = new ArrayList<Column>();
        cols.add(new Column("学号", "idNum"));
        cols.add(new Column("姓名", "name"));
        cols.add(new Column("活跃值", "activeValue"));
        cols.add(new Column("在线时长", "onlineTime"));
        this.studentColumns = cols;
        this.teacherColumns = cols;
    }

    /*{
        "title": "在线时长", "key": "onlineTime"
    } */

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Column{
        private String title, key;
    }


    /*
    {"idNum":"121313","name":"李四","onlineTime":"12","activeValue":"12"}
    * */
    @Data
    public class Info{
        private String idNum,name,onlineTime,activeValue;

        public void setData(String idNum,String name,String onlineTime,String activeValue){
            this.idNum = idNum;
            this.name = name;
            this.onlineTime = onlineTime;
            this.setActiveValue(activeValue);

        }
    }
}



