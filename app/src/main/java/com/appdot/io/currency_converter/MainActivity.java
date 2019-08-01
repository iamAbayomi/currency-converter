package com.appdot.io.currency_converter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        //Initializing variable mChart
        lineChart =  findViewById(R.id.chart1);

        List<Entry> sinEntries = new ArrayList<>(); // List to data-points of sine curve
        List <Entry> cosEntries = new ArrayList<>();  // List to store data-points of cosine curve

        // Obtaining data points by using Math.sin and Math.cos functions
        for( float i = 0; i <1f; i += 0.02f ){
            sinEntries.add(new Entry(i,(float)Math.sin(i)));
            cosEntries.add(new Entry(i,(float)Math.cos(i)));
        }

        List<ILineDataSet> dataSets = new ArrayList<>(); // for adding multiple plots

        LineDataSet sinSet = new LineDataSet(sinEntries,"sin curve");
        LineDataSet cosSet = new LineDataSet(cosEntries,"cos curve");

        // Adding colors to different plots
        cosSet.setColor(Color.GREEN);
        cosSet.setCircleColor(Color.GREEN);
        sinSet.setColor(Color.BLUE);
        sinSet.setCircleColor(Color.BLUE);
        sinSet.setDrawFilled(true);


        // Adding each plot data to a List
        dataSets.add(sinSet);
        //dataSets.add(cosSet);
        // Setting datapoints and invalidating chart to update with data points
        lineChart.setData(new LineData(dataSets));

        // lineChart.getXAxis().setEnabled(false);
        lineChart.getXAxis().setDrawGridLines(false);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);

        lineChart.getAxisRight().setEnabled(false);

        //Setting scale in chart
        lineChart.setScaleEnabled(true);

        lineChart.invalidate();

    }



}
