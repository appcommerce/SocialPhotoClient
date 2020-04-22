package ru.appcommerce.photoviewer.presenter;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.appcommerce.photoviewer.model.ModelHandler;

@InjectViewState
public class DetailPresenter extends MvpPresenter<IDetailPresenter> {
    private static final String TAG = "DetailPresenterError";
    private ModelHandler modelHandler = ModelHandler.getInstance();
    private Single<Integer> observable;

    public DetailPresenter(){
        observable = modelHandler.getItemPosition();
    }

    public void getModelId(){
        Disposable disposable = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(position -> getViewState().showLog(position),
                        throwable -> Log.d(TAG, "onError: " + throwable.getMessage()));
    }
}
