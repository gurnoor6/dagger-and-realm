package com.example.dagger2application;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {

    @Provides
    Realm providesRealm(){
        return Realm.getDefaultInstance();
    }
}
