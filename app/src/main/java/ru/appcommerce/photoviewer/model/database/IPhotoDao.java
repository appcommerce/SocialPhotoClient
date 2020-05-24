package ru.appcommerce.photoviewer.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;
import ru.appcommerce.photoviewer.model.Hit;

@Dao
public interface IPhotoDao {
    @Insert
    Single<List<Long>> insertList(List<Hit> photos);

    @Query("SELECT * FROM table_photos")
    Single<List<Hit>> getAll();

    @Query("DELETE FROM table_photos")
    Single<Integer> deleteAll();
}
