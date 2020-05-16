package com.example.dagger2application;

import android.util.Log;

import com.example.dagger2application.model.Student;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmService {
    private final Realm mRealm;
    public RealmService(final Realm realm) {
        this.mRealm = realm;
    }

    public void saveData() {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Student s = bgRealm.createObject(Student.class);
                s.setName("yoyo");
                s.setAge("24");
                Student s1 = bgRealm.createObject(Student.class);
                s1.setName("yo");
                s1.setAge("22");
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.d("TAGGG", "Sucesssss");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.d("TAGGG", "Boooooooooo");
            }
        });
    }

    public void readData(){
        RealmResults<Student> students = mRealm.where(Student.class).findAll();
        String data=" ";
        Log.d("lengthhhhhh",Integer.toString(students.size()));
        for(Student student: students){
            try {
                data = data+ student.getName()+"   " + student.getAge()+'\n';
            }catch(NullPointerException e){
                e.printStackTrace();
            }

            Log.d("WoooooHooooo", "readData: Readed Dataaa Sucessfulyyyyyy");
        }


    }

}
