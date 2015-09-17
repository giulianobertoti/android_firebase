package com.example.giuliano.firebase;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Firebase.setAndroidContext(this);


        final TextView resultArea = (TextView) findViewById(R.id.result);

        Firebase base = new Firebase("https://rockchords.firebaseio.com/");

        base.child("band").addListenerForSingleValueEvent(new ValueEventListener() {
            StringBuilder finalResult = new StringBuilder();

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                finalResult.append(snapshot.getValue());
                resultArea.setText(finalResult);

            }
            @Override public void onCancelled(FirebaseError error) { }
        });

    }


}
