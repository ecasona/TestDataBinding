package com.ecasona.testdatabindingapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ecasona.entity.User;
import com.ecasona.testdatabindingapplication.databinding.ActivityMainBinding;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_USER = "USER";
    private static final String TAG = "MainActivity";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User();
        binding.setUser(user);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: btn click enter");
                initData();
            }
        });

    }

    private void initData() {
        user.setTitle("the first dataBinDing");
        user.setOriginal_title("寻选客");
        user.setYear(new Date().toString());
        Log.e(TAG, "initData: " + user.toString());
    }

}
