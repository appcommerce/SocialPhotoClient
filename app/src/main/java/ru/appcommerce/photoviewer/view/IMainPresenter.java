package ru.appcommerce.photoviewer.view;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.appcommerce.photoviewer.model.Hit;

public interface IMainPresenter extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void loadRecycler(List<Hit> content);
}
