package ru.appcommerce.photoviewer;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import ru.appcommerce.photoviewer.modules.AppComponent;
import ru.appcommerce.photoviewer.modules.AppModule;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        component = generateAppComponent();

    }

    public static AppComponent getComponent() {
        return component;
    }

    public AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
