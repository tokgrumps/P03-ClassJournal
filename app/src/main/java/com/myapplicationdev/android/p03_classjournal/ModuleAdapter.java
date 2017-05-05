package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017573 on 5/5/2017.
 */

public class ModuleAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvCode;
    private TextView tvModule;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        module = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row_main
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row_main.xmln.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row_main, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.textViewCode);
        // Get the ImageView object
        tvModule = (TextView) rowView.findViewById(R.id.textViewModule);


        // The parameter "position" is the index of the
        //  row_main ListView is requesting.
        //  We get back the food at the same index.
        Module currentModule = module.get(position);
        // Set the TextView to show the food

        tvCode.setText(currentModule.getModule());
        tvModule.setText(currentModule.getCode());
        // Set the image to star or nostar accordingly
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
