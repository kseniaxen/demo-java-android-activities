package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class Form2Activity extends AppCompatActivity {

    public static final String FEEDBACK_EXTRA = "feedback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getIntent().hasExtra(MainActivity.MESSAGE_EXTRA)) {
            Toast.makeText(
                    Form2Activity.this,
                    getIntent().getStringExtra(MainActivity.MESSAGE_EXTRA),
                    Toast.LENGTH_LONG
            ).show();
        }
        ((EditText)findViewById(R.id.formMessageEditText)).setOnKeyListener((v, keyCode, event) -> {
            Intent intent = new Intent();
            intent.putExtra(FEEDBACK_EXTRA, ((EditText)findViewById(R.id.formMessageEditText)).getText().toString().length());
            setResult(RESULT_OK, intent);
            return false;
        });
    }
}