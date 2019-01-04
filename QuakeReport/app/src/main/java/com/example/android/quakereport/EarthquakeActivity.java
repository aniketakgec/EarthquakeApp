
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<EarthquakeData> earthquakedata = QueryUtils.extractEarthquakes();
        /*earthquakedata.add(new EarthquakeData(7.2, "San Fransisco", "Feb 2 ,2016"));
        earthquakedata.add(new EarthquakeData(6.1, "London", "July 2 ,2015"));
        earthquakedata.add(new EarthquakeData(5.2, "New Jersey", "Mar 22 ,2016"));
        earthquakedata.add(new EarthquakeData(6.4, "Detroit", "Jan 2 ,2013"));
        earthquakedata.add(new EarthquakeData(3.9, "Tokyo", "Nov 10 ,2014"));
        earthquakedata.add(new EarthquakeData(2.8, "Moscow", "Jan 31 ,2013"));
        earthquakedata.add(new EarthquakeData(4.9, "Rio de Jenario", "Aug 29 ,2012"));
*/
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakedata
        final EarthquakeAdapter  adapter = new EarthquakeAdapter(this, earthquakedata);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);


        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EarthquakeData earthquakeData=adapter.getItem(i);
                Uri earthquakeuri=Uri.parse(earthquakeData.getUrl());
                Intent websiteIntent=new Intent(Intent.ACTION_VIEW,earthquakeuri);
                startActivity(websiteIntent);
            }
        });



















    }
}
