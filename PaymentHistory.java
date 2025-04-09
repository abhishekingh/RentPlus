package com.example.RentPlus;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.yuvraj.R;

public class PaymentHistory extends AppCompatActivity {
    Button button17;
    EditText editText23;
    EditText editText;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button17=findViewById(R.id.button17);
        editText=findViewById(R.id.editTextTextPassword2);
        Database_connection connection=new Database_connection(this);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                int a=Integer.parseInt(s);
                Cursor cur=connection.select2(a);
                if(cur.getCount()==0){
                    Toast.makeText(PaymentHistory.this,"Record not founded",
                            Toast.LENGTH_SHORT).show();
                }
                StringBuffer stb=new StringBuffer();
                while (cur.moveToNext()){
                    stb.append("Monthly Room Rent: "+cur.getInt(1)+"\n");
                    stb.append("Electricity Bill: "+cur.getInt(2)+"\n");
                    stb.append("Other Charges: "+cur.getInt(3)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(PaymentHistory.this);
                builder.setCancelable(true);
                builder.setTitle("All history");
                builder.setMessage(stb.toString());
                builder.show();
            }
        });
    }
}