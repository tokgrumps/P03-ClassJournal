package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        ImageView iv = (ImageView)findViewById(R.id.ivDG);
        TextView tvWeek = (TextView)findViewById(R.id.tvWeek);
        final RadioGroup rgGrade = (RadioGroup)findViewById(R.id.rgGrade);
        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);

        iv.setImageResource(R.drawable.dg);


        Intent i = getIntent();
        tvWeek.setText("Week " + i.getIntExtra("week", 0));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rgSel = rgGrade.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(rgSel);
                String rbSel = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade", rbSel);

                setResult(RESULT_OK, i);
                finish();

            }
        });



    }
}
