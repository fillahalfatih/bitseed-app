package com.example.bitseed;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {
    private EditText emailEditText, statusEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        emailEditText = findViewById(R.id.email);
        statusEditText = findViewById(R.id.status);
        saveButton = findViewById(R.id.buttonSave);

        // Retrieve values from Profile activity
        String email = getIntent().getStringExtra("email");
        String status = getIntent().getStringExtra("status");

        // Set values to EditText widgets
        emailEditText.setText(email);
        statusEditText.setText(status);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get updated values from EditText widgets
                String updatedEmail = emailEditText.getText().toString();
                String updatedStatus = statusEditText.getText().toString();

                // Create an Intent to send back the updated values
                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedEmail", updatedEmail);
                resultIntent.putExtra("updatedStatus", updatedStatus);

                // Set the result for the calling activity
                setResult(Activity.RESULT_OK, resultIntent);

                // Finish the current activity
                finish();
            }
        });
    }
}
