package com.myapplicationdev.android.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class infoPage extends AppCompatActivity {
    Button btnAdd, btnInfo, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnEmail = (Button) findViewById(R.id.buttonEmail);


    }
}
