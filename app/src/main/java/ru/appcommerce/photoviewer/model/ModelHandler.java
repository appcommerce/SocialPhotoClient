package ru.appcommerce.photoviewer.model;

import java.util.Arrays;
import java.util.List;

public class ModelHandler {
    private static ModelHandler instance;
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
}
