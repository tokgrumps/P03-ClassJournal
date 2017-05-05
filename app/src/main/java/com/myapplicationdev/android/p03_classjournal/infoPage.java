package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class infoPage extends AppCompatActivity {
    Button btnAdd, btnInfo, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Weeks> week;

    int requestCodeForGrade = 1;

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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(infoPage.this,
                        AddDataActivity.class);
                int newWeekNumber = lv.getAdapter().getCount() + 1;
                // Put hero object in intent
                i.putExtra("week", newWeekNumber);

                startActivityForResult(i, requestCodeForGrade);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("error: ", "ddddddd");
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {

            }
            if (requestCode == 1){
                Intent i = getIntent();
                String grade = i.getStringExtra("grade");
                int newWeekNumber = lv.getAdapter().getCount() + 1;
                week.add(new Weeks("Week " + newWeekNumber, grade));

                Log.d("error: ", week.size() + "");
                aa.notifyDataSetChanged();
            }
        }
    }
}
