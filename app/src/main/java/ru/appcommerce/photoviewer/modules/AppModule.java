package ru.appcommerce.photoviewer.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.appcommerce.photoviewer.model.database.Database;
import ru.appcommerce.photoviewer.model.network.Network;

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Database provideDatabase(Context context){
        return Room.databaseBuilder(context,
                Database.class, "photo_database").build();
    }

    @Singleton
    @Provides
    Network provideNetwork(){
        return new Network();
    }
}
