package com.hasslewithnans.hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class agripro_details extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth auth = FirebaseAuth.getInstance();;
    Button buttonAdd;
    Button g_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agripro_details);
        Toast.makeText(getApplicationContext(),"HII", Toast.LENGTH_SHORT).show();
        TextInputEditText editCost,editPh_no,editDescription,editBr,editQ,editName;
        user = auth.getCurrentUser();
        editPh_no = findViewById(R.id.phone_numberr);
        editCost = findViewById(R.id.costb);
        editQ = findViewById(R.id.quantity);
        editDescription = findViewById(R.id.descriptionb);
        editBr = findViewById(R.id.buyorrent);
        editName = findViewById(R.id.name_of_item);
        buttonAdd = findViewById(R.id.btn_negb);
        g_back = findViewById(R.id.b4b);
        g_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Toast.makeText(getApplicationContext(),"HII", Toast.LENGTH_SHORT).show();
//        email = findViewById(R.id.user_details);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d, p, n, br, q, c;
                d = String.valueOf(editDescription.getText());
                p = String.valueOf(editPh_no.getText());
                q = String.valueOf(editQ.getText());
                n = String.valueOf(editName.getText());
                br = String.valueOf(editBr.getText());
                c = String.valueOf(editCost.getText());
                String email = user.getEmail().toString();

                Toast.makeText(getApplicationContext(),"HII", Toast.LENGTH_SHORT).show();
                DatabaseReference placesRef = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("prods");

                // Create a new child node under 'places'
                DatabaseReference newPlaceRef = placesRef.push();

                // Set the values for the child node
                newPlaceRef.child("email").setValue(email);
                newPlaceRef.child("description").setValue(d);
                newPlaceRef.child("quantity").setValue(q);
                newPlaceRef.child("buyorrent").setValue(br);
                newPlaceRef.child("cost").setValue(c);
                newPlaceRef.child("name of item").setValue(n);
                newPlaceRef.child("phone number").setValue(p);
            }
        });
    }
}