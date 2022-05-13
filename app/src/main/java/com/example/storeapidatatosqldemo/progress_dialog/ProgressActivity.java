package com.example.storeapidatatosqldemo.progress_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.storeapidatatosqldemo.R;
import com.example.storeapidatatosqldemo.classes.LoadingDialog;
import com.example.storeapidatatosqldemo.classes.ProgressBar;

public class ProgressActivity extends AppCompatActivity {

    Button btnStartProgress, btn, btn2;
    ProgressBar progressBar;
    LoadingDialog loadingDialogBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        btnStartProgress = findViewById(R.id.button);
        btn = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        progressBar = new ProgressBar(this);

        loadingDialogBar = new LoadingDialog(this);

        btnStartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.showDialog();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loadingDialogBar.showLoadingDialog("Please Wait...");
            }
        });
    }


}
