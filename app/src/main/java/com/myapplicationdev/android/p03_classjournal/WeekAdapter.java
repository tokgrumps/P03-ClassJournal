package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeekAdapter extends ArrayAdapter<Weeks> {
    private ArrayList<Weeks> week;
    private Context context;
    private TextView tvSubject, tvGrade;

    public WeekAdapter(Context context, int resource, ArrayList<Weeks> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        week = objects;
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
        tvSubject = (TextView) rowView.findViewById(R.id.tvSubject);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);


        // The parameter "position" is the index of the
        //  row_main ListView is requesting.
        //  We get back the food at the same index.
        Weeks currentWeek = week.get(position);
        // Set the TextView to show the food

        tvGrade.setText(currentWeek.getName());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}

