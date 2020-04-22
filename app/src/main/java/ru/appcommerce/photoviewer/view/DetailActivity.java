package ru.appcommerce.photoviewer.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.presenter.DetailPresenter;
import ru.appcommerce.photoviewer.presenter.IDetailPresenter;

public class DetailActivity extends MvpAppCompatActivity implements IDetailPresenter {
    private static final String TAG = "DetailPresenter";

    @InjectPresenter
    public DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        presenter.getModelId();
    }

    @Override
    public void showLog(int position) {
        Log.d(TAG, "Current position: " + position);
    }
}
