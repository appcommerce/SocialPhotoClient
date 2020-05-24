package ru.appcommerce.photoviewer.model.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.appcommerce.photoviewer.model.PhotoArray;

public class Network {
    private final String baseUrl = "https://pixabay.com";
    private final String apiKey = "16680724-45987ccdcaf55fe1e511303b2";
    private final String imageType = "photo";
    private final String perPage = "50";
    private IRequests requests;

    public Network(){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        requests = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(IRequests.class);
    }

    public Single<PhotoArray> getFromServer(String query, String orientation, String category) {
        return requests.loadPhoto(apiKey, query, imageType, orientation, category, perPage).subscribeOn(Schedulers.io());
    }
}
