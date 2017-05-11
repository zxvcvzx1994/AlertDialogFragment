package com.example.kh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        if(view.getId()==R.id.btn){
            Fragment_AlertDialog dialog  = new Fragment_AlertDialog();
            dialog.show(getFragmentManager(), "dialog");
        }
    }
}
