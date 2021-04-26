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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button actionButton = findViewById(R.id.mainActionButton);
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
                    intent.putExtra("message", messageEditText.getText().toString());
                    // startActivity(intent);
                    startActivityForResult(intent, 0);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("MyDebug: MainActivity Start");
        System.out.println("data = " + data);
        if (data != null && data.hasExtra("feedback")) {
            System.out.println("data.hasExtra(\"feedback\") = " + data.hasExtra("feedback"));
            Toast.makeText(
                    MainActivity.this,
                    data.getStringExtra("feedback"),
                    Toast.LENGTH_LONG
            ).show();
        }
        System.out.println("MyDebug: MainActivity End");
    }
}