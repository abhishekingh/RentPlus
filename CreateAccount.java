package com.example.RentPlus;

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

public class CreateAccount extends AppCompatActivity {
    Button button14;
    EditText name;
    EditText password;
    EditText phone;
    EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Database_connection connection=new Database_connection(this);
        name=findViewById(R.id.editTextText3);
        password=findViewById(R.id.editTextTextPassword);
        phone=findViewById(R.id.editTextPhone);
        address=findViewById(R.id.editTextText4);
        button14=findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=name.getText().toString();
                String s2=password.getText().toString();
                String s3=phone.getText().toString();
                String s4=address.getText().toString();
                connection.insert(s1,s2,s3,s4);
                go_back();
            }
        });

    }
    public void go_back(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}