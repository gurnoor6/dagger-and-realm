package com.example.dagger2application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    RealmService r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RealmComponent component = DaggerRealmComponent.create();
        r = component.provideRealmService();
        r.saveData();
        r.readData();
    }







}
