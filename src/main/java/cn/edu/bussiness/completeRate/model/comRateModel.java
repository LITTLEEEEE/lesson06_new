package cn.edu.bussiness.completeRate.model;

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
 *       "columns": [ "课程", "百分比"],
 *       "rows": [
 *         { "课程": "Java", "百分比": 0.32 },
 *         { "课程": "Java", "百分比": 0.32 },
 *         { "课程": "Java", "百分比": 0.32 },
 *         { "课程": "Java", "百分比": 0.32 },
 *         { "课程": "Java", "百分比": 0.32 }
 *       ]
 *     },
 *     "chartSettings": {
 *       "xAxisType": ["percent"],
 *       "yAxisName": ["百分比"]
 *     }
 *   }
 * }
 */
@Data
public class comRateModel {
    private chartData chartData;
    private chartSettings chartSettings;

    public void init(List<row>rowList){
        List<String> cols = new ArrayList<>();
        cols.add("课程");
        cols.add("百分比");
        this.chartData=new chartData(cols,rowList);

        List<String> xat = new ArrayList<>();
        List<String> yan = new ArrayList<>();
        xat.add("percent");
        yan.add("百分比");
        this.chartSettings = new chartSettings(xat,yan);
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
        private String 课程;
        private float 百分比;
    }
    @Data
    @AllArgsConstructor
    class chartSettings{
        private List<String> xAxisType;
        private List<String> yAxisNme;
    }
}
