package com.example.dagger2application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.dagger2application.model.Student;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Inject Realm r;
    TextView display;
    String data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        RealmComponent component = DaggerRealmComponent.create();
        r = component.providesRealm();
        r.beginTransaction();
        Student s = r.createObject(Student.class);
        s.setAge("36");
        s.setName("ABCD");
        r.commitTransaction();
        RealmResults<Student> results = r.where(Student.class).findAll();
        for(Student stud:results){
            data = data +stud.getName()+"  " +stud.getAge()+'\n';
        }
        display.setText(data);
        Log.d("TASSSSKKKKK DONNNNEEE", "onCreate: Done");
    }







}
