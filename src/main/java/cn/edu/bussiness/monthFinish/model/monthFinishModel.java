package cn.edu.bussiness.monthFinish.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * {
 *   "code": 200,
 *   "data": {
 *     "chartData": {
 *       "columns": ["时间", "已完结", "预计完结"],
 *       "rows": [
 *         { "时间": "9月", "已完结": 0,"预计完结": 0},
 *         { "时间": "10月", "已完结": 2,"预计完结": 0},
 *         { "时间": "11月", "已完结": 3,"预计完结": 0},
 *         { "时间": "12月", "已完结": 8,"预计完结": 0},
 *         { "时间": "1月", "已完结": 2,"预计完结": 15}
 *       ]
 *     },
 *     "chartSettings": {
 *     }
 *   },
 *   "msg": "success"
 * }
 */
@Data
public class monthFinishModel {
    private chartData chartData;
    private String chartSetting;
    public void initColumn(List<monthFinishModel.row>rowList){
        List<String>cols = new ArrayList<>();
        cols.add("时间");
        cols.add("已完结");
        cols.add("预计完结");
        this.chartData = new chartData(cols,rowList);

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
        private String 时间;
        private int 已完结;
        private int 预计完结;

    }
}
