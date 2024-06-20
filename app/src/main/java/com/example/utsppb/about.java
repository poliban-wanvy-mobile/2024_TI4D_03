package com.example.utsppb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class about extends AppCompatActivity {
    Button bt_logout, bt_back;
    ImageView iv_naufal, iv_sambas, iv_mico, iv_apri, iv_nuril;
    TextView tv_naufal, tv_sambas, tv_mico, tv_apri, tv_nuril;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bt_logout = findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(view -> login());
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(view -> utama());

        iv_naufal = findViewById(R.id.iv_naufal);
        tv_naufal = findViewById(R.id.tv_naufal);
        iv_naufal.setOnClickListener(view -> profile("M. Naufal Dzil Ikram", "C030322119", "TI-4D", "Bermain Basket"));
        tv_naufal.setOnClickListener(view -> profile("M. Naufal Dzil Ikram", "C030322119", "TI-4D", "Bermain Basket"));

        iv_sambas = findViewById(R.id.iv_sambas);
        tv_sambas = findViewById(R.id.tv_sambas);
        iv_sambas.setOnClickListener(view -> profile("Muhammad Yusup Haekal Sambas", "C030322127", "TI-4D", "Menonton Film"));
        tv_sambas.setOnClickListener(view -> profile("Muhammad Yusup Haekal Sambas", "C030322127", "TI-4D", "Menonton Film"));

        iv_mico = findViewById(R.id.iv_mico);
        iv_mico.setOnClickListener(view -> profile("Mico Gosyin", "C030322121", "TI-4D", "Bermain Futsal"));
        tv_mico = findViewById(R.id.tv_mico);
        tv_mico.setOnClickListener(view -> profile("Mico Gosyin", "C030322121", "TI-4D", "Bermain Futsal"));

        iv_apri = findViewById(R.id.iv_apri);
        tv_apri = findViewById(R.id.tv_apri);
        iv_apri.setOnClickListener(view -> profile("Muhammad Apriansyah", "C030322124", "TI-4D", "Mendengar Musik"));
        tv_apri.setOnClickListener(view -> profile("Muhammad Apriansyah", "C030322124", "TI-4D", "Mendengar Musik"));

        iv_nuril = findViewById(R.id.iv_nuril);
        tv_nuril = findViewById(R.id.tv_nuril);
        iv_nuril.setOnClickListener(view -> profile("Nuriliani", "C030322129", "TI-4D", "Menyanyi"));
        tv_nuril.setOnClickListener(view -> profile("Nuriliani", "C030322129", "TI-4D", "Menyanyi"));
    }
    private void login() {
        startActivity(new Intent(this, login.class));
    }
    private void utama() {
        startActivity(new Intent(this, main.class));
    }
    private void profile(String nama, String nim, String kelas, String hobi) {
        Intent intent = new Intent(about.this, profile.class);
        intent.putExtra("nama", nama);
        intent.putExtra("nim", nim);
        intent.putExtra("kelas", kelas);
        intent.putExtra("hobi", hobi);
        startActivity(intent);
    }
}