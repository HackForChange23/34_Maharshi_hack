package com.hasslewithnans.hack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button lease;
    Button button;
    Button details;
    Button buy, agripro, agriprolease;
    Button suggest;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView textView;
    Button add_lease;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        details = findViewById(R.id.details);
        add_lease = findViewById(R.id.add_lease);
        suggest = findViewById(R.id.suggest);
        lease = findViewById(R.id.lease);
        buy = findViewById(R.id.buy);
        agripro = findViewById(R.id.agripro);
        agriprolease = findViewById(R.id.agriprolease);
        textView =findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if(user == null) {
            Intent intent = new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();

        }
        else {
            textView.setText(user.getEmail());
        }
        agripro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),agripro_details.class);
                startActivity(intent);
                finish();

            }
        });
        agriprolease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),agripro_lease.class);
                startActivity(intent);
                finish();

            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),buy.class);
                startActivity(intent);
                finish();

            }
        });
        add_lease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),lease_details.class);
                startActivity(intent);
                finish();

            }
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),details.class);
                startActivity(intent);
                finish();

            }
        });
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),suggest.class);
                startActivity(intent);
                finish();

            }
        });
        lease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),lease.class);
                startActivity(intent);
                finish();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();

            }
        });

    }
}