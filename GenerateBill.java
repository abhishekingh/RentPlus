package com.example.RentPlus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.yuvraj.R;

public class GenerateBill extends AppCompatActivity {
    Button button16;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_generate_bill);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button16=findViewById(R.id.button16);
        editText1=findViewById(R.id.editTextNumber3);
        editText2=findViewById(R.id.editTextNumber4);
        editText3=findViewById(R.id.editTextNumber5);
        editText=findViewById(R.id.editTextNumber6);
        Database_connection connection=new Database_connection(this);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String s1=editText.getText().toString();
                String s2=editText1.getText().toString();
                String s3=editText2.getText().toString();
                String s4=editText3.getText().toString();*/
                int x1=Integer.parseInt(editText.getText().toString());
                int x2=Integer.parseInt(editText1.getText().toString());
                int x3=Integer.parseInt(editText2.getText().toString());
                int x4=Integer.parseInt(editText3.getText().toString());
                connection.insert2(x1,x2,x3,x4);
                go_back();
            }
        });
    }
    public  void go_back(){
        Intent intent=new Intent(this, owner.class);
        startActivity(intent);
    }
}