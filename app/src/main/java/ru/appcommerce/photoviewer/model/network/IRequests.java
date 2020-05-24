package ru.appcommerce.photoviewer.model.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.appcommerce.photoviewer.model.PhotoArray;

public interface IRequests {
    @GET("api")
    Single<PhotoArray> loadPhoto(@Query("key") String key,
                                 @Query("q") String query,
                                 @Query("image_type") String imageType,
                                 @Query("orientation") String orientation,
                                 @Query("category") String category,
                                 @Query("per_page") String perPage);
}
