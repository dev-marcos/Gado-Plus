package br.edu.farol.gadoplus.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import br.edu.farol.gadoplus.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private PieChart mPieChart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mPieChart = root.findViewById(R.id.chartGastos);

        PieData mPieData = getPieData(5,100);
        showChart(mPieChart, mPieData);


        return root;
    }

    private void showChart (PieChart pieChart,PieData pieData){

        pieChart.setHoleRadius(60f);
        pieChart.setTransparentCircleRadius(64f);


        Description description = new Description();
        description.setText("Descricao");
        description.setTextSize(18f);
        pieChart.setDescription(description);

        pieChart.setExtraOffsets(5, 10, 5, 5);


        pieChart.setDrawCenterText(true);
        pieChart.setDrawHoleEnabled(true);

        pieChart.setRotationAngle(90);
        pieChart.setRotationEnabled(true);

        pieChart.setUsePercentValues(true);
        pieChart.setCenterText("Conteudo Centro");


        pieChart.setData(pieData);
        Legend mLegend = pieChart.getLegend();
        //mLegend.setPosition(LegendPosition.RIGHT_OF_CHART);

        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);
        pieChart.animateXY(1500, 1500);
    }

    private PieData getPieData (int count,float range){
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("a");
        xVals.add("b");
        xVals.add("c");
        xVals.add("d");
        xVals.add("e");

        ArrayList<PieEntry> yVals = new ArrayList<PieEntry>();
        float data1 = 14;
        float data2 = 25;
        float data3 = 19;
        float data4 = 38;
        float data5 = 4;
        yVals.add(new PieEntry(data1, 0));
        yVals.add(new PieEntry(data2, 1));
        yVals.add(new PieEntry(data3, 2));
        yVals.add(new PieEntry(data4, 3));
        yVals.add(new PieEntry(data5, 4));

        PieDataSet mPieDataSet = new PieDataSet(yVals, "aaaa");
        mPieDataSet.setSliceSpace(2f);

        ArrayList<Integer>  colors =  new ArrayList<Integer>();

        colors.add(Color.rgb(255, 73, 75));
        colors.add(Color.rgb(79, 145, 255));
        colors.add(Color.rgb(255, 152, 152));
        colors.add(Color.rgb(252, 184, 64));
        colors.add(Color.rgb(140, 201, 158));
        mPieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5*(metrics.densityDpi/160f);
        mPieDataSet.setSelectionShift(px);

        PieData pieData = new PieData(mPieDataSet);
        //xVals
        pieData.setValueFormatter(new PercentFormatter());
        return pieData;
    }

}