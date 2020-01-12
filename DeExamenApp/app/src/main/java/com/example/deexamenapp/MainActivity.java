package com.example.deexamenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    public static final int BOOL_REQUEST = 1;
    public int i = 0;
    public TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.count);
    }


    public void showToast(View view) {
        Toast t = Toast.makeText(this, "Hallo Wereld", Toast.LENGTH_SHORT);
        t.show();
    }

    public void countUp(View view) {
        if (showCount != null) {
            i++;
            showCount.setText(Integer.toString(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_PartB:
                launchPartB();
                break;

            case R.id.activities_intents:
                launchActivitiesIntents();
                break;


            case R.id.implicit_intents:
                launchImplicitIntents();
                break;

            case R.id.RecyclerView:
                launchRecyclerview();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchRecyclerview() {
        Intent intent = new Intent(this, RecyclerView.class);
        startActivityForResult(intent, BOOL_REQUEST);
    }

    private void launchImplicitIntents() {
        Intent intent = new Intent(this, Implicit_Intents.class);
        startActivityForResult(intent, BOOL_REQUEST);
    }

    private void launchActivitiesIntents() {
        Intent intent = new Intent(this, Activities_Intents.class);
        startActivityForResult(intent, BOOL_REQUEST);
    }


    private void launchPartB() {
        Intent intent = new Intent(this, ScrollingView.class);
        startActivityForResult(intent, BOOL_REQUEST);
    }


}
