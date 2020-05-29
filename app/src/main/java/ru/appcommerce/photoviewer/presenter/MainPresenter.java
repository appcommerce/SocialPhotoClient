package ru.appcommerce.photoviewer.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.appcommerce.photoviewer.App;
import ru.appcommerce.photoviewer.model.PhotoArray;
import ru.appcommerce.photoviewer.model.database.Database;
import ru.appcommerce.photoviewer.model.database.IPhotoDao;
import ru.appcommerce.photoviewer.model.network.Network;
import ru.appcommerce.photoviewer.view.IMainPresenter;


@InjectViewState
public class MainPresenter extends MvpPresenter<IMainPresenter> {
    private static final String TAG = "MainPresenter";
    @Inject
    Network network;
    @Inject
    Database database;

    private IPhotoDao iPhotoDao;
    private CompositeDisposable subscriptions;

    public MainPresenter() {
        App.getComponent().inject(this);
        iPhotoDao = database.getDao();
        this.subscriptions = new CompositeDisposable();
    }

    public void fillPhotoList(String query, String orientation, String category){
        Single<PhotoArray> single = network.getFromServer(prepareQuery(query), orientation, category);
        subscriptions.add(single.doOnSuccess(photoArray -> clearDBTable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        photoArray -> {
                            getViewState().loadRecycler(photoArray.getHits());
                            putPhotosToDB(photoArray);
                        },
                        throwable -> Log.e(TAG, "onError", throwable)));
    }

    public void getPhotosFromDB() {
        subscriptions.add(iPhotoDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        photos -> getViewState().loadRecycler(photos),
                        throwable -> Log.e(TAG, "onError", throwable)));
    }

    private void putPhotosToDB(PhotoArray photoArray) {
        subscriptions.add(iPhotoDao.insertList(photoArray.getHits()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        longs -> Log.d(TAG, "Return id: "+longs),
                        throwable -> Log.e(TAG, "onError", throwable)));
    }

    private void clearDBTable() {
        subscriptions.add(iPhotoDao.deleteAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        longs -> Log.e(TAG, "onSuccess, table cleared"),
                        throwable -> Log.e(TAG, "onError", throwable)));
    }

    private String prepareQuery(String query) {
        return query.replace(" ", "+");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!subscriptions.isDisposed()) {
            subscriptions.dispose();
        }
    }
}
