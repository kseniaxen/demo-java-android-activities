package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class FormActivity extends AppCompatActivity {

    public static final String FEEDBACK_EXTRA = "feedback";
    public static final String MESSAGE_EXTRA = "message";
    public static final int DETAILS_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Button detailsActionButton = findViewById(R.id.detailsActionButton);
        if (getIntent().hasExtra(MainActivity.MESSAGE_EXTRA)) {
            Toast.makeText(
                    FormActivity.this,
                    getIntent().getStringExtra(MainActivity.MESSAGE_EXTRA),
                    Toast.LENGTH_LONG
            ).show();
        }
        ((EditText)findViewById(R.id.formMessageEditText)).setOnKeyListener((v, keyCode, event) -> {
            Intent intent = new Intent();
            intent.putExtra(FEEDBACK_EXTRA, ((EditText)findViewById(R.id.formMessageEditText)).getText().toString());
            setResult(RESULT_OK, intent);
            return false;
        });
        detailsActionButton.setOnClickListener(
                v -> {
                    Intent intent = new Intent(FormActivity.this, DetailsActivity.class);
                    EditText messageEditText = findViewById(R.id.formMessageEditText);
                    intent.putExtra(MESSAGE_EXTRA, messageEditText.getText().toString());
                    // startActivity(intent);
                    startActivityForResult(intent, DETAILS_ACTIVITY_REQUEST_CODE);
                }
        );
    }

    /* @Override
    protected void onDestroy() {
        System.out.println("MyDebug: FormActivity onDestroy Start");
        System.out.println(((EditText)findViewById(R.id.formMessageEditText)).getText());
        System.out.println("MyDebug: FormActivity onDestroy Finish");
        super.onDestroy();
    } */
}