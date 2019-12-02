package br.edu.farol.gadoplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.preference.PreferenceManager;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.ui.animais.AnimaisAddEditActivity;
import br.edu.farol.gadoplus.ui.lotes.LotesAddEditActivity;
import br.edu.farol.gadoplus.ui.pesagem.PesagemAddEditActivity;
import br.edu.farol.gadoplus.ui.propriedades.PropriedadesAddEditActivity;
import br.edu.farol.gadoplus.ui.propriedades.PropriedadesFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private SharedPreferences settings;
    public static final String APP_PREFERENCES="gado_plus_settings";

    private PieChart pieChart;
    private PieData pieData;
    private PieDataSet pieDataSet;
    private ArrayList pieEntries;
    private ArrayList PieEntryLabels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


       /* FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            onAddNewPropriedade();
           // onAddNewLote();
           // onAddNewPesagem();

            ///    startActivity(new Intent(MainActivity.this, AnimaisAddEditActivity.class));

            }
        });
*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_animais, R.id.nav_lotes,
                R.id.nav_pesagem, R.id.nav_gastos, R.id.nav_propriedades)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    private void getEntries() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, 0));
        pieEntries.add(new PieEntry(4f, 1));
        pieEntries.add(new PieEntry(6f, 2));
        pieEntries.add(new PieEntry(8f, 3));
        pieEntries.add(new PieEntry(7f, 4));
        pieEntries.add(new PieEntry(3f, 5));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void onAddNewPropriedade() {
        startActivity(new Intent(this, PropriedadesAddEditActivity.class));
    }

    private void onAddNewLote() {
        startActivity(new Intent(this, LotesAddEditActivity.class));
    }

    private void onAddNewPesagem() {
        startActivity(new Intent(this, PropriedadesAddEditActivity.class));
    }


}
