package ru.appcommerce.photoviewer.presenter;

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
        List<Data> list = modelHandler.getData();
        int position = list.get(0).getCurrentPosition();
        iDetailPresenter.showLog(position);
    }
}
