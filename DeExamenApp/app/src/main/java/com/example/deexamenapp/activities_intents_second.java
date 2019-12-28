package com.example.deexamenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activities_intents_second extends AppCompatActivity {

    private EditText mReply;
    public static final String EXTRA_REPLY = "com.deexamenapp.activities_intents_second.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_intents_second);

        //Get reply from EditText
        mReply = findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Activities_Intents.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);

        //Set the result to RESULT_OK to indicate that the response was successful.
        setResult(RESULT_OK, replyIntent);
        finish(); //Call finish() to close the Activity and return to MainActivity.
    }
}
