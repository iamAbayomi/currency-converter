package com.appdot.io.currency_converter;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;
    ArrayList<ItemData> list;
    Spinner secondSpinner;
    Spinner firstSpinner;
    SpinnerAdapter firstAdapter;
    SpinnerAdapter secondAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        //Initializing variable mChart
        lineChart =  findViewById(R.id.chart1);
        list = new ArrayList<>();
        secondSpinner = findViewById(R.id.secondSpinner);
        firstSpinner = findViewById(R.id.firstSpinner);
        addSpinner();
        linearChart();
    }

    public void linearChart(){
        List<Entry> sinEntries = new ArrayList<>(); // List to data-points of sine curve
        List <Entry> cosEntries = new ArrayList<>();  // List to store data-points of cosine curve

        // Obtaining data points by using Math.sin and Math.cos functions
        for( float i = 0; i <7f; i += 0.02f ){
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
        sinSet.setDrawCircles(false);
        sinSet.setDrawValues(false);

        sinSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);


        // Adding each plot data to a List
        dataSets.add(sinSet);
        //dataSets.add(cosSet);
        // Setting datapoints and invalidating chart to update with data points
        lineChart.setData(new LineData(dataSets));

        //lineChart.getXAxis().setEnabled(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setDrawAxisLine(true);
        lineChart.getXAxis().setDrawLabels(true);
        //lineChart.getXAxis().setla
        lineChart.getXAxis().setAxisMinimum(0.0f);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setDrawLabels(false);
        lineChart.getAxisLeft().setAxisMinimum(0.0f);

        lineChart.getData().setHighlightEnabled(false);


        //Setting scale in chart
        lineChart.setScaleEnabled(true);

        lineChart.invalidate();

    }

    public void addSpinner(){

        ArrayList<ItemData> firstList =new ArrayList<>();
        ArrayList<ItemData> secondList = new ArrayList<>();

        firstList.add(new ItemData("EUR", R.drawable.ic_european_union));
        firstList.add( new ItemData("USD",R.drawable.ic_united_states_of_america));
        firstList.add(new ItemData("AUD", R.drawable.ic_australia));
        firstList.add(new ItemData("CAD",R.drawable.ic_canada));
        firstList.add(new ItemData("PLN",R.drawable.ic_republic_of_poland));
        firstList.add(new ItemData("MXN", R.drawable.ic_mexico));




        firstAdapter = new SpinnerAdapter(this, R.layout.spinner_layout,R.id.txtCurrency,firstList);
        firstSpinner.setAdapter(firstAdapter);

        secondList.add(new ItemData("PLN",R.drawable.ic_republic_of_poland));
        secondList.add( new ItemData("USD",R.drawable.ic_united_states_of_america));
        secondList.add(new ItemData("AUD", R.drawable.ic_australia));
        secondList.add(new ItemData("CAD",R.drawable.ic_canada));
        secondList.add(new ItemData("MXN", R.drawable.ic_mexico));





        secondAdapter = new SpinnerAdapter(this, R.layout.spinner_layout,R.id.txtCurrency, secondList);
        secondSpinner.setAdapter(secondAdapter);


    }

}
