package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
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

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                String message = "Hi faci,\n \nI am...\nPlease see my remarks so far, thank you\n\n";
                for(int i = 0; i < week.size(); i++){
                    message += week.get(i).getWeek() + ": DG: " + week.get(i).getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT,message);

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                String grade = data.getStringExtra("grade");
//                Log.d("error", grade);
                    int newWeekNumber = lv.getAdapter().getCount() + 1;
                    week.add(new Weeks("Week " + newWeekNumber, grade));

                    aa.notifyDataSetChanged();


            }
        }
    }
}
