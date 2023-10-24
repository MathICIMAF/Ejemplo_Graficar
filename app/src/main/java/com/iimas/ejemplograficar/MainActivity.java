package com.iimas.ejemplograficar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LineChart lineChart;
    int N = 256;
    int M = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChart = findViewById(R.id.lineChart);

        EditText nEdit = findViewById(R.id.nEdit);
        EditText mEdit = findViewById(R.id.mEdit);

        nEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    N = Integer.parseInt(charSequence.toString());
                    inicializarGrafica();
                    lineChart.invalidate();
                }
                catch (Exception e){}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    M = Integer.parseInt(charSequence.toString());
                    inicializarGrafica();
                    lineChart.invalidate();
                }
                catch (Exception e){}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inicializarGrafica();
    }

    private void inicializarGrafica() {

        lineChart.setBackgroundColor(Color.BLACK);

        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < N; i++){
            float y = (float) Math.sin(2*Math.PI*i*M/N);
            Entry entry = new Entry(i,y);
            entries.add(entry);
        }

        LineDataSet lineDataSet = new LineDataSet(entries,"");
        lineDataSet.setColor(Color.WHITE);
        lineDataSet.setLineWidth(2);
        lineDataSet.setDrawCircles(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

    }
}