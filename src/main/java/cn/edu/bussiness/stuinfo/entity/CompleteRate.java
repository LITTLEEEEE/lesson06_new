package cn.edu.bussiness.stuinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompleteRate {
    private int course_sum;
    private int unfinish;
}
