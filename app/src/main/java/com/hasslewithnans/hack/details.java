/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hasslewithnans.hack;

import android.annotation.SuppressLint;
import android.content.Intent;
import java.util.Map;
import java.util.HashMap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class details extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth auth = FirebaseAuth.getInstance();;
    private static final String TAG = "details";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details);
////        basicReadWrite();
//    }
    TextInputEditText editPlace,editCost,editPh_number,editArea,editNeg,editInstall,editWaterSource,editCropRot,editSoilType,editYears;
    Button buttonAdd;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        user = auth.getCurrentUser();
        editPlace = findViewById(R.id.place);
        editCost = findViewById(R.id.cost);
        editYears = findViewById(R.id.years);
        editCropRot = findViewById(R.id.rotations);
        editNeg = findViewById(R.id.negotiation);
        editInstall = findViewById(R.id.installments);
        editWaterSource = findViewById(R.id.watersource);
        editSoilType = findViewById(R.id.soiltype);
        editArea = findViewById(R.id.area);
        editPh_number = findViewById(R.id.ph_no);
        buttonAdd = findViewById(R.id.btn_add);
//        email = findViewById(R.id.user_details);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String place, negotiation,watersource,soiltype,installations;
                Number cost, ph_no, area, croprot, years;
                place = String.valueOf(editPlace.getText());
                negotiation = String.valueOf(editNeg.getText());
                installations = String.valueOf(editInstall.getText());
                soiltype = String.valueOf(editSoilType.getText());
                watersource = String.valueOf(editWaterSource.getText());
//                email = String.valueOf(editEmail.getText());
                String email = user.getEmail().toString();
//                if(user.getEmail()!=null)
//                    email = user.getEmail().toString();
                cost = Double.valueOf(editCost.getText().toString());
                croprot = Double.valueOf(editCropRot.getText().toString());
                years = Double.valueOf(editYears.getText().toString());
                area = Double.valueOf(editArea.getText().toString());
                ph_no = Double.valueOf(editPh_number.getText().toString());

                if (TextUtils.isEmpty(place)) {
                    Toast.makeText(details.this, "Enter place", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cost.toString())) {
                    Toast.makeText(details.this, "Enter cost", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ph_no.toString())) {
                    Toast.makeText(details.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(area.toString())) {
                    Toast.makeText(details.this, "Enter area", Toast.LENGTH_SHORT).show();
                    return;
                }
//                FirebaseDatabase database = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/");
//                DatabaseReference myRef = database.getReference("For Sale");
//                Map<String, Object> data = new HashMap<>();
////                data.put("email", email);
//                data.put("place", place);
//                data.put("cost", cost);
//                data.put("area", area);
//                data.put("phone_number", ph_no);
//                myRef.setValue(data);
                DatabaseReference placesRef = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("places");

                // Create a new child node under 'places'
                DatabaseReference newPlaceRef = placesRef.push();

                // Set the values for the child node
                newPlaceRef.child("email").setValue(email);
                newPlaceRef.child("place").setValue(place);
                newPlaceRef.child("negotiation").setValue(negotiation);
                newPlaceRef.child("installations").setValue(installations);
                newPlaceRef.child("soiltype").setValue(soiltype);
                newPlaceRef.child("watersource").setValue(watersource);
                newPlaceRef.child("rotations").setValue(croprot);
                newPlaceRef.child("years").setValue(years);
                newPlaceRef.child("cost").setValue(cost);
                newPlaceRef.child("area").setValue(area);
                newPlaceRef.child("ph_no").setValue(ph_no);
            }
        });
    }

}