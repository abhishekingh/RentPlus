package com.example.RentPlus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.yuvraj.R;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private EditText editText3;
    private EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Database_connection connection=new Database_connection(this);
        editText3=findViewById(R.id.editTextText2);
        editText4=findViewById(R.id.editTextNumber2);
        button=findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0;
                String s=editText3.getText().toString();
                String s2=editText4.getText().toString();
                Cursor cur=connection.select();
                if(cur.getCount()==0){
                    Toast.makeText(MainActivity3.this,"Entry not found",
                            Toast.LENGTH_SHORT).show();
                }
                ArrayList al=new ArrayList();
                while(cur.moveToNext()){
                    al.add(cur.getString(0));
                    al.add(cur.getString(1));
                }
                for(int j=0;j<al.size();j++){
                    if(s.equals(al.get(j).toString()) && s2.equals(al.get(j+1).toString())){
                        i++;
                    }
                }
                if(i>0){
                    owner(i);
                }else{
                    owner(i);
                }
            }
        });
    }
    public void owner(int z){
        if(z==0){
            Toast.makeText(MainActivity3.this,"Enter correct Name and Id",
                    Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Intent i=new Intent(this, owner.class);
            startActivity(i);
        }
    }
}