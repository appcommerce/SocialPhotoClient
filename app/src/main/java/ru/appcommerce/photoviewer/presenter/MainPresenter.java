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
import ru.appcommerce.photoviewer.model.network.Network;
import ru.appcommerce.photoviewer.view.IMainPresenter;


@InjectViewState
public class MainPresenter extends MvpPresenter<IMainPresenter> {
    private static final String TAG = "MainPresenter";
    @Inject
    Network network;

    private CompositeDisposable subscriptions;

    public MainPresenter() {
        App.getComponent().inject(this);
        this.subscriptions = new CompositeDisposable();
    }

    public void fillPhotoList(String query, String orientation, String category){
        Single<PhotoArray> single = network.getFromServer(prepareQuery(query), orientation, category);
        subscriptions.add(single.doOnSuccess(photoArray -> Log.d(TAG, "Success"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        photoArray -> {
                            getViewState().loadRecycler(photoArray.getHits());
                        },
                        throwable -> Log.e(TAG, "onError", throwable)));
    }

    //TODO: В следующим коммитом добавлю поддержку добавления картинок в БД, оттуда буду загружать только когда нет интернета

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
