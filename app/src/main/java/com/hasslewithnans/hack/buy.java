

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

public class buy extends AppCompatActivity implements OnItemClickListener {

    Button buy;
    FirebaseAuth auth;
    FirebaseUser user;
    public List<data> placesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;

    @Override
    public void onItemClick(data place) {
        // Handle item click here
        Toast.makeText(getApplicationContext(),"HIIIII",Toast.LENGTH_LONG);
        // You can use the 'place' object to access the clicked data
    }




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        auth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//

// ...

// Assuming you have initialized Firebase Database reference
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("places");

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
                        String place = jsonObjectValue.getString("place");
                        String cost = jsonObjectValue.getString("cost");
                        String area = jsonObjectValue.getString("area");
                        String phone_number = jsonObjectValue.getString("ph_no");
                        placesList.add(new data("Place:" + place,"cost:" + cost,"area:" + area,"ph_no:" + phone_number));
//                        collapsingToolbar.setTitle(place);
//                        Toast.makeText(getApplicationContext(),place, Toast.LENGTH_LONG).show();
//                        Toast.makeText(getApplicationContext(), placesList.toString(), Toast.LENGTH_LONG).show();
//
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
////                    String imageUrl = placeSnapshot.child("imageUrl").getValue(String.class);
                    // Do something with the retrieved data for each place
                    // For example, you can create Place objects or update UI
                }
                PlaceAdapter placeAdapter = new PlaceAdapter(placesList, buy.this);
                recyclerView.setAdapter(placeAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });


    }
}