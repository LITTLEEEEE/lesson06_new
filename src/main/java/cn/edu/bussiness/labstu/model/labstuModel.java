package cn.edu.bussiness.labstu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *对应---------------------------json7
 * {
 *   "code": 200,
 *   "data": {
 *     "chartData": {
 *       "columns": ["日期", "分数", "人数"],
 *       "rows": {
 *         "JAVA": [
 *           { "日期": "1/1", "人数": 123,  "分数": 50 },
 *           { "日期": "1/2", "人数": 80, "分数": 60 },
 *         ],
 *         "大数据": [
 *  *           { "日期": "1/1", "人数": 84,  "分数": 55 },
 *  *         ]
 *       }
 *     },
 *     "chartSettings": {
 *       "dimension": "日期",
 *       "metrics": ["分数", "人数"]
 *     }
 *   },
 *   "msg": "success"
 * }
 */
@Data
public class labstuModel {
    private chartData chartData;
    private chartSettings chartSettings;

    public void init(Map<String,List<course>> rows){
        String dimension = "日期";
        List<String> metrics = new ArrayList<>();
        metrics.add("分数");
        metrics.add("人数");
        this.chartSettings = new chartSettings(dimension,metrics);
        //初始化chartData
        List<String> columns = new ArrayList<>();
        columns.add("日期");
        columns.add("分数");
        columns.add("人数");
        this.chartData = new chartData(columns,rows);
    }
    @Data
    @AllArgsConstructor
    class chartData{
        private List<String> columns;
        private Map<String,List<course>> rows;

    }

    @Data
    @AllArgsConstructor
    public class course {
        private String 日期;
        private float 分数;
        private int 人数;

    }
    @Data
    @AllArgsConstructor
    class chartSettings{
        private String dimension;
        private List<String> metrics;
    }
}
