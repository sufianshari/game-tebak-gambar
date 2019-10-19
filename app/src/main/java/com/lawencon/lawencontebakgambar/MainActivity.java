package com.lawencon.lawencontebakgambar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.lawencon.lawencontebakgambar.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button btnMulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViews();
        initViews();
        initListeners();
    }

    @Override
    public void findViews() {
        btnMulai = findViewById(R.id.btn_mulai);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListeners() {
        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mulai = new Intent(MainActivity.this, MulaiActivity.class);
                startActivity(mulai);
            }
        });
    }
}
