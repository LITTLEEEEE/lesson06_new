package cn.edu.bussiness.Experimental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * {
 *   "code": 200,
 *   "data":{
 *     "chartData": {
 *       "columns": [ "日期","智评评测", "手动打分","批阅实验总数"],
 *       "rows": [
 *         { "日期": "1/1","智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         {"日期": "2/1", "智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         { "日期": "3/1","智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         { "日期": "4/1","智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         { "日期": "5/1","智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         { "日期": "6/1","智评评测": 80, "手动打分": 20,"批阅实验总数": 39 },
 *         {"日期": "7/1", "智评评测": 80, "手动打分": 20,"批阅实验总数": 39 }
 *       ]
 *     },
 *     "chartSettings": {
 *       "showLine": ["批阅实验总数"],
 *       "stack": { "评分": ["智评评测", "手动打分"] }
 *     }
 *   }
 * }
 */
@Data
public class experimentModel {
    private chartData chartData;
    private chartSettings chartSettings;

    public void init(List<row>rowList){
        List<String> cols = new ArrayList<>();
        cols.add("日期");
        cols.add("智能测评");
        cols.add("手动打分");
        cols.add("批阅实验总数");
        this.chartData=new chartData(cols,rowList);

        List<String> showline = new ArrayList<>();
        showline.add("批阅实验总数");
        List<String> list = new ArrayList<>();
        list.add("智能测评");
        list.add("人工打分");
        stack stack = new stack(list);
        this.chartSettings = new chartSettings(showline,stack);
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class chartData{
        private List<String> columns;
        private List<row> rows;
    }
    @Data
    @AllArgsConstructor
    public class row{
        private String 日期;
        private float 智能测评;
        private float 手动打分;
        private int 批阅实验总数;
    }
    @Data
    @AllArgsConstructor
    class chartSettings{
        private List<String> showLine;
        private stack stack;
    }
    @Data
    @AllArgsConstructor
    class stack{
        private List<String> 评分;
    }
}
