# dagger-and-realm

This Android Studio Project aims to use dependency injection , using Dagger 2, to create a Realm Service to access the database. 

We add data to the students Model using the `saveData()` function and then read the size of the database using `readData()` function present in the `RealmService` class. 

So the `ApplicationModule` class has two methods which are annotated by `@Provider`. The first method `providesRealm()` provides a `Realm` object which is given as an argument to the `provideRealmService()` (this process is done by dagger). The `provideRealmService()` associates the private variable `mRealm` in `RealmService` to our database. Eventually we do all manipulations in the database using that `mRealm` variable only. 

Now in `MainActivity.java`, we create an instance of `RealmComponent` using the `Dagger` generated `DaggerRealmComponent` class or function (whatever it is). Then we associate a `RealmService` variable `r` with the `mRealm` in `RealmService` essentially (not exactly. its more like a handle to that). Finally, we call the `saveData()` and `readData()` functions on `r` to make changes in our database. 
