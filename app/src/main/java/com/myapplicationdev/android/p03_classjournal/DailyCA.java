package com.myapplicationdev.android.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15017573 on 5/5/2017.
 */

public class DailyCA implements Serializable{
    private String dgGrade;
    private String moduleCode;
    private int week;

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }
}
