package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    ImageView iv = (ImageView)findViewById(R.id.ivDG);
    TextView tvWeek = (TextView)findViewById(R.id.tvWeek);
    RadioGroup rgGrade = (RadioGroup)findViewById(R.id.rgGrade);
    Button btnSubmit = (Button)findViewById(R.id.btnSubmit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        iv.setImageResource(R.drawable.dg);

        Intent i = getIntent();

        DailyCA dailyGrade = (DailyCA)

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
