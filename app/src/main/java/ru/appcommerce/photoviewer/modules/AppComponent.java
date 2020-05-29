package ru.appcommerce.photoviewer.modules;

import javax.inject.Singleton;

import dagger.Component;
import ru.appcommerce.photoviewer.presenter.MainPresenter;
import ru.appcommerce.photoviewer.view.MainActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainPresenter presenter);
    void inject(MainActivity activity);
}
