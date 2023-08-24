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
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class lease_details extends AppCompatActivity {
    FirebaseUser user;
    Button b41;

    FirebaseAuth auth = FirebaseAuth.getInstance();;
    private static final String TAG = "lease_details";

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details);
////        basicReadWrite();
//    }
    TextInputEditText editNeg,editPh_number,editArea,editWaterSource,editDistrict, editMandal,editVillage,editSurvey_no,editKhata_no;
    Button buttonAdd;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "HELLOOOOO", Toast.LENGTH_SHORT);
        setContentView(R.layout.activity_lease_details);
        user = auth.getCurrentUser();
        b41 = findViewById(R.id.b4);
//        editPlace = findViewById(R.id.place);
//        editYears = findViewById(R.id.years);
//        editCropRot = findViewById(R.id.rotations);
//        editNeg = findViewById(R.id.negotiation);
//        editInstall = findViewById(R.id.installments);
        editDistrict = findViewById(R.id.district1);
        editMandal = findViewById(R.id.mandal1);
        editVillage = findViewById(R.id.village1);
        editSurvey_no = findViewById(R.id.survey_no1);
        editKhata_no = findViewById(R.id.khata_no1);
        editNeg = findViewById(R.id.neg);
        editWaterSource = findViewById(R.id.watersource1);
        editArea = findViewById(R.id.area1);
        editPh_number = findViewById(R.id.ph_no1);
        buttonAdd = findViewById(R.id.btn_neg);
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        email = findViewById(R.id.user_details);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String district,mandal,village,survey_no,khata_no, neg,watersource,soiltype,installations;
                Number cost, ph_no, area, croprot, years;
//                place = String.valueOf(editPlace.getText());
//                negotiation = String.valueOf(editNeg.getText());
//                installations = String.valueOf(editInstall.getText());
//                croprot = Double.valueOf(editCropRot.getText().toString());
//                years = Double.valueOf(editYears.getText().toString());
                district = String.valueOf(editDistrict.getText());
                mandal = String.valueOf(editMandal.getText());
                village = String.valueOf(editVillage.getText());
                survey_no = String.valueOf(editSurvey_no.getText());
                khata_no = String.valueOf(editKhata_no.getText());
                watersource = String.valueOf(editWaterSource.getText());
//                email = String.valueOf(editEmail.getText());
                String email = user.getEmail().toString();
//                if(user.getEmail()!=null)
//                    email = user.getEmail().toString();
                neg = String.valueOf(editNeg.getText());
                area = Double.valueOf(editArea.getText().toString());
                ph_no = Double.valueOf(editPh_number.getText().toString());

                if (TextUtils.isEmpty(district)) {
                    Toast.makeText(lease_details.this, "Enter district", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(neg.toString())) {
                    Toast.makeText(lease_details.this, "Enter Negotiables", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ph_no.toString())) {
                    Toast.makeText(lease_details.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(area.toString())) {
                    Toast.makeText(lease_details.this, "Enter area", Toast.LENGTH_SHORT).show();
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
                DatabaseReference placesRef = FirebaseDatabase.getInstance("https://hackthon-1c9a5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("leases");

                // Create a new child node under 'places'
                DatabaseReference newPlaceRef = placesRef.push();

                // Set the values for the child node
                newPlaceRef.child("email").setValue(email);
                newPlaceRef.child("district").setValue(district);
                newPlaceRef.child("mandal").setValue(mandal);
                newPlaceRef.child("village").setValue(village);
                newPlaceRef.child("survey_no").setValue(survey_no);
                newPlaceRef.child("khata_no").setValue(khata_no);
                newPlaceRef.child("watersource").setValue(watersource);
                newPlaceRef.child("neg").setValue(neg);
                newPlaceRef.child("area").setValue(area);
                newPlaceRef.child("ph_no").setValue(ph_no);
            }
        });
    }

}