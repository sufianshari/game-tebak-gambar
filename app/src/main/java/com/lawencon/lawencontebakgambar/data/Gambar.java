package com.lawencon.lawencontebakgambar.data;

import com.lawencon.lawencontebakgambar.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gambar {

    public static List<Integer> list_soal=new ArrayList<Integer>();
    public static List<Integer> list_jawaban=new ArrayList<Integer>();
    public static List<Integer> list_jawaban_soal=new ArrayList<Integer>();

    public static int soal = 0;

    private int listSoal[] = {
            R.drawable.hp_asus,
            R.drawable.hp_huawei,
            R.drawable.hp_iphone,
            R.drawable.hp_samsung,
            R.drawable.hp_vivo,

    };

    private int listJawaban[] = {
            R.drawable.logo_asus,
            R.drawable.logo_huawei,
            R.drawable.logo_apple,
            R.drawable.logo_samsung,
            R.drawable.logo_vivo
    };

    public int getrandomGambar(){
        int rnd = new Random().nextInt(listSoal.length);
        return rnd;
    }

    public int getimagesoal(int i){
        return listSoal[i];
    }

    public int getimagejwbn(int i){
        return listJawaban[i];
    }

    public int getjumlahSoal(){
        return listSoal.length;
    }

}