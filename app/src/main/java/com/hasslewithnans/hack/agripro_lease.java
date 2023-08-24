

package com.hasslewithnans.hack;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.bumptech.glide.Glide;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class agripro_lease extends AppCompatActivity {

    Button buy,g31;
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;
    public List<agripro_data> LeasesList = new ArrayList<>();
    private RecyclerView recyclerViewb;

//    @Override
//    public void onItemClick(Lease_data place) {
//        // Handle item click here
//        Toast.makeText(getApplicationContext(),"HIIIII",Toast.LENGTH_LONG);
//        // You can use the 'place' object to access the clicked Lease_data
//    }





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agripro_lease);
        auth = FirebaseAuth.getInstance();
        recyclerViewb = findViewById(R.id.recyclerViewb);
        recyclerViewb.setHasFixedSize(false);
        recyclerViewb.setLayoutManager(new LinearLayoutManager((this)));
        g31=findViewById(R.id.g3b);
        g31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//

// ...

// Assuming you have initialized Firebase Lease_database reference
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("prods");

// Add a ValueEventListener to fetch all children of the "places" node
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Iterate through all children
                for (DataSnapshot placeSnapshot : dataSnapshot.getChildren()) {
//                    CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.card);
                    String placeId = placeSnapshot.getKey();
                    DataSnapshot jsonObjectSnapshot = placeSnapshot.child(placeId);
                    JSONObject jsonObjectValue = new JSONObject((Map) placeSnapshot.getValue());
                    try {
                        String q = jsonObjectValue.getString("quantity");
                        String n = jsonObjectValue.getString("name of item");
                        String br = jsonObjectValue.getString("buyorrent");
                        String d = jsonObjectValue.getString("description");
                        String c = jsonObjectValue.getString("cost");
                        String p = jsonObjectValue.getString("phone number");
                        LeasesList.add(new agripro_data("Name:" + n,"ph_num:" + p,"buy/rent:" + br,"descriptiom:" + d, "quantity:" + q, "Cost:"+ c));
//
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
////                    String imageUrl = placeSnapshot.child("imageUrl").getValue(String.class);
                    // Do something with the retrieved Lease_data for each place
                    // For example, you can create Place objects or update UI
                }
                AgriProLeaseAdapter leaseAdapter = new AgriProLeaseAdapter(LeasesList);
                recyclerViewb.setAdapter(leaseAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });


    }
}