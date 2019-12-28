package com.example.deexamenapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activities_Intents extends AppCompatActivity {

    private static final String LOG_TAG = "Activity 02.2";

    private EditText mMessageEditText;
    public static final String EXTRA_MESSAGE = "com.deexamenapp.activities_intents.extra.MESSAGE";


    //voor het terugkrijgen van data
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG,"OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities__intents);
        mMessageEditText = findViewById(R.id.editText_main);

        //voor het terugkrijgen van data
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    //Voor activity 02.2: Activity lifecycle and state
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, activities_intents_second.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        //voor implicid intents
        //startActivity(intent);

        //voor explicit intents
        startActivityForResult(intent,TEXT_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {

        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(activities_intents_second.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);


    }
}
