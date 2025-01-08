package com.a71b.uass1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class UpdateUserPass extends AppCompatActivity {

    private Button btnUpdate;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_pass);
        getSupportActionBar().hide();
        final EditText nama,username,password;
        nama = (EditText) findViewById(R.id.inputNama);
        username = (EditText) findViewById(R.id.inputUser);
        password = (EditText) findViewById(R.id.inputPass);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        SharedPreferences prefer = getSharedPreferences("MYDATA",MODE_PRIVATE);
        String oldNama = prefer.getString("nama",null);
        String oldUser = prefer.getString("user",null);
        String oldPass = prefer.getString("pass",null);

        nama.setText(oldNama);
        username.setText(oldUser);
        password.setText(oldPass);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newNama = nama.getText().toString();
                String newUser = username.getText().toString();
                String newPass = password.getText().toString();
                /*SharedPreferences.Editor edit = prefer.edit();
                edit.putString("nama",newNama);
                edit.putString("user",newUser);
                edit.putString("pass",newPass);
                edit.putString(newUser + newPass + "data", newUser + "\n" + newNama);
                edit.commit();*/
                Intent iLogin = new Intent(UpdateUserPass.this,
                        LoginActivity.class);
                startActivity(iLogin);}
        });

    }
}