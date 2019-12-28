package com.example.deexamenapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activities_Intents extends AppCompatActivity {

    private EditText mMessageEditText;
    public static final String EXTRA_MESSAGE = "com.deexamenapp.activities_intents.extra.MESSAGE";


    //voor het terugkrijgen van data
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities__intents);
        mMessageEditText = findViewById(R.id.editText_main);

        //voor het terugkrijgen van data
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
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
