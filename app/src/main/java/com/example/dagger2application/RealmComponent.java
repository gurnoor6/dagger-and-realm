package com.example.dagger2application;

import dagger.Component;
import io.realm.Realm;

@Component(modules = ApplicationModule.class)
public interface RealmComponent {
    Realm providesRealm();
}
