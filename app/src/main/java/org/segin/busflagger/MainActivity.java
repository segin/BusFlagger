package org.segin.busflagger;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;

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
        makeButtonDoStuff();
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

    private void makeButtonDoStuff() {
            Button flagBtn = (Button) findViewById(R.id.flagBtn);
            flagBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ShowRoute.class);
                    Spinner routeSpinner = (Spinner) findViewById(R.id.routeSpinner);
                    String route = routeSpinner.getSelectedItem().toString();
                    intent.putExtra("Route", route);
                    startActivity(intent);
                }
            });
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
