package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (getIntent().hasExtra(FormActivity.MESSAGE_EXTRA)) {
            ((TextView)findViewById(R.id.detailsTextView)).setText(getIntent().getStringExtra(FormActivity.MESSAGE_EXTRA));
        }
    }
}
