package com.lawencon.lawencontebakgambar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.lawencon.lawencontebakgambar.base.BaseActivity;

public class HasilActivity extends BaseActivity {

    private TextView tvHasil;
    private Bundle inBundle;
    private String hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViews();
        initViews();
        initListeners();
    }

    @Override
    public void findViews() {
        tvHasil = findViewById(R.id.tv_skor_akhir);
    }

    @Override
    public void initViews() {
        inBundle = getIntent().getExtras();
        hasil = inBundle.get("hasil").toString();
        tvHasil.setText(hasil);
    }

    @Override
    public void initListeners() {

    }
}
