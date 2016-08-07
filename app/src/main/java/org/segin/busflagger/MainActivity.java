package org.segin.busflagger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initSpinners();
    }

    private void initSpinners() {
        Spinner spinner = (Spinner) findViewById(R.id.scheduleSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.line_types, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        updateRouteSpinner();
        makeSpinnerDoStuff();
    }

    private void makeSpinnerDoStuff() {
        Spinner spinner = (Spinner) findViewById(R.id.scheduleSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateRouteSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void updateRouteSpinner() {
        Spinner scheduleSpinner = (Spinner) findViewById(R.id.scheduleSpinner);
        Spinner routeSpinner = (Spinner) findViewById(R.id.routeSpinner);
        ArrayAdapter<CharSequence> adapter;
        Log.d("BusFlagger",scheduleSpinner.getSelectedItem().toString().substring(0, 2).toLowerCase());
        switch(scheduleSpinner.getSelectedItem().toString().substring(0, 3).toLowerCase()) {
            default:
            case "wee":
                 adapter = ArrayAdapter.createFromResource(this, R.array.day_lines, android.R.layout.simple_spinner_item);
                break;
            case "sat":
                adapter = ArrayAdapter.createFromResource(this, R.array.night_lines, android.R.layout.simple_spinner_item);
                break;
            case "sun":
                adapter = ArrayAdapter.createFromResource(this, R.array.sunday_lines, android.R.layout.simple_spinner_item);
                break;
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        routeSpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
