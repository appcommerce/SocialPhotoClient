package ru.appcommerce.photoviewer.model;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class ModelHandler {
    private static ModelHandler instance;
    private int itemPosition;
    private List<Data> list;

    private ModelHandler(){
        list = Arrays.asList(new Data(), new Data(), new Data(), new Data());
    }

    public static ModelHandler getInstance() {
        if(instance == null){
            instance = new ModelHandler();
        }
        return instance;
    }

    public List<Data> getData() {
        return list;
    }

    public void setData(int position){
        list.get(position).setCurrentPosition(position);
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public Single<Integer> getItemPosition() {
        return Single.create((SingleOnSubscribe<Integer>) emitter ->
                emitter.onSuccess(itemPosition))
                .subscribeOn(Schedulers.io());
    }
}
