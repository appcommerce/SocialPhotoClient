package ru.appcommerce.photoviewer.presenter;

import android.util.Log;

import java.util.List;

import ru.appcommerce.photoviewer.model.Data;
import ru.appcommerce.photoviewer.model.ModelHandler;

public class DetailPresenter {
    private ModelHandler modelHandler = ModelHandler.getInstance();
    private IDetailPresenter iDetailPresenter;

    public DetailPresenter(IDetailPresenter iDetailPresenter){
        this.iDetailPresenter = iDetailPresenter;
    }

    public void getModelId(){
        int position = modelHandler.getItemPosition();
        Log.d("", "Current position: "+position);
        //iDetailPresenter.showLog(position);
    }
}
