package ru.appcommerce.photoviewer.model.database;

import androidx.room.RoomDatabase;

import ru.appcommerce.photoviewer.model.Hit;

@androidx.room.Database(entities = {Hit.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract IPhotoDao getDao();
}
