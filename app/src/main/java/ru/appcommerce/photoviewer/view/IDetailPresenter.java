package ru.appcommerce.photoviewer.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IDetailPresenter extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void showLog(int position);
    void showPhoto(String urlContent);
}
