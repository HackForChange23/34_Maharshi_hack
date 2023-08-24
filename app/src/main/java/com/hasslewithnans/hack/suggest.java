package com.hasslewithnans.hack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.Spinner;
import com.bumptech.glide.Glide;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class suggest extends AppCompatActivity {
    TextInputEditText editcrop, edityears, editCrop2, ecvalue;

    Button buttonSuggest;
    Button gomain;
    String s;
//    Spinner spinner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Present_Crop");
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Economic_value");
        editcrop = findViewById(R.id.crop_suggest);
        edityears = findViewById(R.id.year_suggest);
        buttonSuggest = findViewById(R.id.btn_suggest);
        editCrop2 = findViewById(R.id.crop_2);
        ecvalue = findViewById(R.id.eco_value);
        gomain=findViewById(R.id.go_main);


//        String last ;

        gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        buttonSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String crop;
//                String crop_2;
                Number years;
                crop = String.valueOf(editcrop.getText());
                years = Integer.valueOf(edityears.getText().toString());
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot placeSnapshot: snapshot.getChildren()){
                            String crop_name = placeSnapshot.getKey().toString();
                            String crop_2 = (String) placeSnapshot.getValue();
                            String string1 = crop + "_" + years.toString();
//                            Toast.makeText(getApplicationContext(), string1, Toast.LENGTH_LONG).show();
                            if(string1.compareTo(crop_name) == 0)
                            {
                                editCrop2.setText(crop_2);
                                Toast.makeText(getApplicationContext(), crop_2, Toast.LENGTH_LONG).show();
                                s=crop_2;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                databaseReference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot placeSnapshot: snapshot.getChildren()){
                            String key1 = placeSnapshot.getKey().toString();
                            String value = (String) placeSnapshot.getValue();
//                            String string1 = crop + "_" + years.toString();
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                            if(s.compareTo(key1) == 0)
                            {
                                ecvalue.setText(value);
                                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                DatabaseReference databaseReference2 = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Economic_value").child(crop_2);

    };

});
    }}
