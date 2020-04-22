package ru.appcommerce.photoviewer.presenter;

import android.util.Log;

import ru.appcommerce.photoviewer.model.ModelHandler;

public class DetailPresenter {
    private ModelHandler modelHandler = ModelHandler.getInstance();
    private IDetailPresenter iDetailPresenter;

    public DetailPresenter(IDetailPresenter iDetailPresenter){
        this.iDetailPresenter = iDetailPresenter;
    }

    public void getModelId(){
        int position = modelHandler.getItemPosition();
        Log.d("DetailPresenter", "Current position: "+position);
    }
}
