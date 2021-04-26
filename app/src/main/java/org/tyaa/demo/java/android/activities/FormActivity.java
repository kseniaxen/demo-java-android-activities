package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getIntent().hasExtra("message")) {
            Toast.makeText(
                    FormActivity.this,
                    getIntent().getStringExtra("message"),
                    Toast.LENGTH_LONG
            ).show();
        }
        ((EditText)findViewById(R.id.formMessageEditText)).setOnKeyListener((v, keyCode, event) -> {
            Intent intent = new Intent();
            intent.putExtra("feedback", ((EditText)findViewById(R.id.formMessageEditText)).getText().toString());
            setResult(RESULT_OK, intent);
            return false;
        });
    }

    /* @Override
    protected void onDestroy() {
        System.out.println("MyDebug: FormActivity onDestroy Start");
        System.out.println(((EditText)findViewById(R.id.formMessageEditText)).getText());
        System.out.println("MyDebug: FormActivity onDestroy Finish");
        super.onDestroy();
    } */
}