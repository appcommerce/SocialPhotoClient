package ru.appcommerce.photoviewer.modules;

import javax.inject.Singleton;

import dagger.Component;
import ru.appcommerce.photoviewer.presenter.MainPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainPresenter presenter);
}
