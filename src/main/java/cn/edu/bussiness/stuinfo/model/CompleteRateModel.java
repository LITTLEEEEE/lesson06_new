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
    private String chartSettings;

    public void initchartData(double value){
        List<String> cols = new ArrayList<String>();
        cols.add("type");
        cols.add("value");
        List<row> row = new ArrayList<>();
        row.add(new row("总体教学进度",value));
        this.chartData=new chartData(cols,row);
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
    class row{
        private String type;
        private double value;
    }
}
