package com.myapplicationdev.android.p03_classjournal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 15017573 on 5/5/2017...kjhgf
 */

public class Module implements Serializable{
    private String code;
    private String module;


    public String getCode() {
        return code;
    }

    public String getModule() {
        return module;
    }

    public Module(String code, String module) {
        this.code = code;
        this.module = module;
    }
}
