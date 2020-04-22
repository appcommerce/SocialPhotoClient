package ru.appcommerce.photoviewer.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.presenter.DetailPresenter;
import ru.appcommerce.photoviewer.presenter.IDetailPresenter;

public class DetailActivity extends AppCompatActivity implements IDetailPresenter {
    private DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        presenter = new DetailPresenter(this);
        presenter.getModelId();
    }

    @Override
    public void showLog(int position) {
        //TODO: Пригодится дальше, наверное
    }
}
