package com.example.dagger2application;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface RealmComponent {
    RealmService provideRealmService();
    void inject(MainActivity mainActivity);
}
