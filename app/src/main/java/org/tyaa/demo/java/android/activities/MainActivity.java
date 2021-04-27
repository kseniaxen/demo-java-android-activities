package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_EXTRA = "message";
    public static final int FORM_ACTIVITY_REQUEST_CODE = 0;
    public static final int FORM_ACTIVITY_2_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button actionButton = findViewById(R.id.mainActionButton);
        Button action2Button = findViewById(R.id.mainAction2Button);
        /* actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Hello Java Android Toast!",
                        Toast.LENGTH_LONG
                ).show();
            }
        }); */
        /* actionButton.setOnClickListener(
                v -> Toast.makeText(
                    MainActivity.this,
                    "Hello Java Android Toast!",
                    Toast.LENGTH_LONG
                ).show()
        ); */
        actionButton.setOnClickListener(
                v -> {
                    Intent intent = new Intent(MainActivity.this, FormActivity.class);
                    EditText messageEditText = findViewById(R.id.mainMessageEditText);
                    intent.putExtra(MESSAGE_EXTRA, messageEditText.getText().toString());
                    // startActivity(intent);
                    startActivityForResult(intent, FORM_ACTIVITY_REQUEST_CODE);
                }
        );
        action2Button.setOnClickListener(
                v -> {
                    Intent intent = new Intent(MainActivity.this, Form2Activity.class);
                    EditText messageEditText = findViewById(R.id.mainMessageEditText);
                    intent.putExtra(MESSAGE_EXTRA, messageEditText.getText().toString());
                    startActivityForResult(intent, FORM_ACTIVITY_2_REQUEST_CODE);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("MyDebug: MainActivity Start");
        System.out.println("data = " + data);
        if (resultCode == RESULT_OK && data != null && data.hasExtra(FormActivity.FEEDBACK_EXTRA)) {
            System.out.println("data.hasExtra(\"feedback\") = " + data.hasExtra(FormActivity.FEEDBACK_EXTRA));
            String result = "";
            if (requestCode == FORM_ACTIVITY_REQUEST_CODE) {
                result = "Feedback text: " +
                        data.getStringExtra(FormActivity.FEEDBACK_EXTRA);
            } else if (requestCode == FORM_ACTIVITY_2_REQUEST_CODE) {
                result = "Feedback text length: " +
                        data.getIntExtra(FormActivity.FEEDBACK_EXTRA, 0);
            }
            Toast.makeText(
                    MainActivity.this,
                    result,
                    Toast.LENGTH_LONG
            ).show();
        }
        System.out.println("MyDebug: MainActivity End");
    }
}