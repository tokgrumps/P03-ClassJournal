package com.myapplicationdev.android.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class infoPage extends AppCompatActivity {
    Button btnAdd, btnInfo, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Weeks> week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        lv = (ListView) this.findViewById(R.id.lvWeeks);

        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnEmail = (Button) findViewById(R.id.buttonEmail);

        week = new ArrayList<Weeks>();
        week.add(new Weeks("Week 1", "B"));

        aa = new WeekAdapter(this, R.layout.row_info_page, week);
        lv.setAdapter(aa);

    }
}
