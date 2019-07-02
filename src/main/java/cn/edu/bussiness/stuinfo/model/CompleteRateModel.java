package cn.edu.bussiness.stuinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *         "code": 200,
 *         "data": {
 *         "chartData": {
 *         "columns": ["type","value"],
 *         "rows": [
 *         {"type": "总体教学进度", "value": 0.57}
 *         ]
 *         },
 *         "chartData1": {
 *         "columns": ["类别","数量"],
 *         "rows": [
 *         {"类别": "未完结","数量": 50},
 *         {"类别": "已完结","数量": 10}
 *         ]
 *         },
 *         "unfinished": 50,
 *         "finish": 10,
 *         "chartSettings": {
 *         }
 *         },
 *         "msg": "success"
 */

@Data
public class CompleteRateModel {
    private int unfinished;
    private int finish;
    private chartData chartData;
    private chartData1 chartData1;
    private String chartSettings;

    public void initchartData(double value,int unfinished,int finish){
        List<String> cols = new ArrayList<String>();
        cols.add("type");
        cols.add("value");
        List<row> row = new ArrayList<>();
        row.add(new row("总体教学进度",value));
        this.chartData=new chartData(cols,row);

        List<String> cols1 = new ArrayList<String>();
        cols1.add("类别");
        cols1.add("数量");
        List<row1> row1 = new ArrayList<>();
        row1.add(new row1("未完结",unfinished));
        row1.add(new row1("已完结",finish));
        this.chartData1=new chartData1(cols1,row1);
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
    @NoArgsConstructor
    class chartData1{
        private List<String> columns;
        private List<row1> rows;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class row1{
        private String 类别;
        private double 数量;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class row{
        private String type;
        private double value;
    }
}
