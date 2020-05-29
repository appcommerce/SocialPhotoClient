package ru.appcommerce.photoviewer.presenter;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.appcommerce.photoviewer.view.IDetailPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<IDetailPresenter> {
    private int position;
    private String largeUrl;

    public void getDetailContent(){
        getViewState().showLog(position);
        getViewState().showPhoto(largeUrl);
    }

    public void setDetailContent(int position, String url){
        this.position = position;
        this.largeUrl = url;
    }
}
