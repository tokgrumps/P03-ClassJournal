package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int requestCodeForModuleCode = 1;
    ListView lvModule;
    ArrayList<Module> module;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView) this.findViewById(R.id.ListViewModule);

        module = new ArrayList<Module>();
        module.add(new Module("C347", "Android Programming II"));
        module.add(new Module("C302", "Web Services"));

        aa = new ModuleAdapter(this, R.layout.row_main, module);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = module.get(position);
                Intent intent = new Intent(MainActivity.this, infoPage.class);
                intent.putExtra("module", selectedModule);
                startActivityForResult(intent, requestCodeForModuleCode);
            }
        });


    }

}
