package com.example.RentPlus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.yuvraj.R;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button13=findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page2();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page3();
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_account();
            }
        });
    }
    public void page2(){
        Intent i=new Intent(this, MainActivity2.class);
        startActivity(i);
    }
    public void page3(){
        Intent i=new Intent(this, MainActivity3.class);
        startActivity(i);
    }
    public void create_account(){
        Intent intent=new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}