

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

public class lease extends AppCompatActivity {

    Button buy,g31;
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;
    public List<Lease_data> LeasesList = new ArrayList<>();
    private RecyclerView recyclerView1;

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
        setContentView(R.layout.activity_lease);
        auth = FirebaseAuth.getInstance();
        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(false);
        recyclerView1.setLayoutManager(new LinearLayoutManager((this)));
        g31=findViewById(R.id.g3);
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
        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("leases");

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
                        String district = jsonObjectValue.getString("district");
                        String mandal = jsonObjectValue.getString("mandal");
                        String village = jsonObjectValue.getString("village");
                        String survey_no = jsonObjectValue.getString("survey_no");
                        String khata_no = jsonObjectValue.getString("khata_no");
                        String neg = jsonObjectValue.getString("neg");
                        String area = jsonObjectValue.getString("area");
                        String phone_number = jsonObjectValue.getString("ph_no");
//                        String negotiation = jsonObjectValue.getString("negotiation");
//                        String installations = jsonObjectValue.getString("installations");
                        String watersource = jsonObjectValue.getString("watersource");
//                        String years = jsonObjectValue.getString("years");
//                        String croprot = jsonObjectValue.getString("rotations");
                        LeasesList.add(new Lease_data("District:" + district,"Mandal:" + mandal,"village:" + village,"survey_no:" + survey_no, "khata_no:" + khata_no, "Negotiables:"+ neg, "area:"+area,"Phone number:" + phone_number, "watersource:"+watersource ));
//                        collapsingToolbar.setTitle(place);
//                        Toast.makeText(getApplicationContext(),place, Toast.LENGTH_LONG).show();
//                        Toast.makeText(getApplicationContext(), placesList.toString(), Toast.LENGTH_LONG).show();
//
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
////                    String imageUrl = placeSnapshot.child("imageUrl").getValue(String.class);
                    // Do something with the retrieved Lease_data for each place
                    // For example, you can create Place objects or update UI
                }
                LeaseAdapter leaseAdapter = new LeaseAdapter(LeasesList);
                recyclerView1.setAdapter(leaseAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });


    }
}