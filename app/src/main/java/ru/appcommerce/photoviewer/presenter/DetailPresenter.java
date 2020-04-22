package ru.appcommerce.photoviewer.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.appcommerce.photoviewer.model.ModelHandler;

public class DetailPresenter {
    private static final String TAG = "DetailPresenter";
    private ModelHandler modelHandler = ModelHandler.getInstance();
    private IDetailPresenter iDetailPresenter;
    private Single<Integer> observable;

    public DetailPresenter(IDetailPresenter iDetailPresenter){
        this.iDetailPresenter = iDetailPresenter;
        observable = modelHandler.getItemPosition();
    }

    public void getModelId(){
        Disposable disposable = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(position -> Log.d(TAG, "Current position: " + position),
                        throwable -> Log.d(TAG, "onError: " + throwable.getMessage()));
    }
}
