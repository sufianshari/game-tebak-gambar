package com.lawencon.lawencontebakgambar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lawencon.lawencontebakgambar.base.BaseActivity;
import com.lawencon.lawencontebakgambar.data.Gambar;

import java.security.PrivilegedAction;
import java.util.Random;

public class MulaiActivity extends BaseActivity {

    private ImageButton btnJawaban1, btnJawaban2, btnJawaban3;
    private ImageView imgSoal;
    private MediaPlayer suaraButton;
    private int soal,s1,jawaban1,jawaban2,jawaban3;
    private int skor = 0;
    private Gambar gambar = new Gambar();
    private int n = gambar.getjumlahSoal();
    private final static int REQUEST_CODE_1 = 1;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViews();
        initViews();
        initListeners();
    }

    @Override
    public void findViews() {
        imgSoal = findViewById(R.id.img_soal);
        btnJawaban1 =  findViewById(R.id.btn_jawaban1);
        btnJawaban2 =  findViewById(R.id.btn_jawaban2);
        btnJawaban3 =  findViewById(R.id.btn_jawaban3);
        suaraButton = MediaPlayer.create(this, R.raw.button);
    }

    @Override
    public void initViews() {
        gantiSoal();
    }

    @Override
    public void initListeners() {
        btnJawaban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect((jawaban1 == soal));
            }
        });
        btnJawaban2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCorrect((jawaban2 == soal));
            }
        });
        btnJawaban3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                isCorrect((jawaban3 == soal));
            }
        });
    }

    public void gantiSoal(){
        soal = gambar.getrandomGambar();
        int i = new Random().nextInt(3) + 1;
        if(i==1) {
            jawaban1 = soal;
        }
        else{
            jawaban1 = gambar.getrandomGambar();
        }
        if(i==2){
            jawaban2 = soal;
        }
        else{
            jawaban2 = gambar.getrandomGambar();
        }
        if(i==3){
            jawaban3 = soal;
        }
        else{
            jawaban3 = gambar.getrandomGambar();
        }

        imgSoal.setBackgroundResource(gambar.getimagesoal(soal));
        btnJawaban1.setBackgroundResource(gambar.getimagejwbn(jawaban1));
        btnJawaban2.setBackgroundResource(gambar.getimagejwbn(jawaban2));
        btnJawaban3.setBackgroundResource(gambar.getimagejwbn(jawaban3));
    }

    public void isCorrect(boolean input){
        TextView tampilskor = findViewById(R.id.tv_skor);
        final Animation jbenar = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation jsalah = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);

        if (input && i <= n) {
            MediaPlayer benar;
            benar = MediaPlayer.create(getBaseContext(), R.raw.benar);
            imgSoal.startAnimation(jbenar);
            skor+=10;
            //benar
            benar.start(); //Starts your sound
            gantiSoal();
            i++;
        } else {
            MediaPlayer salah;
            imgSoal.startAnimation(jsalah);
            skor-=5;
            salah = MediaPlayer.create(getBaseContext(), R.raw.salah);
            salah.start();
            //salah
        }
        tampilskor.setText("SKOR :" + skor);
        if(i==n){
            Intent intent = new Intent(MulaiActivity.this, HasilActivity.class);
            intent.putExtra("hasil", skor);
            startActivityForResult(intent, REQUEST_CODE_1);
        }
    }
}
