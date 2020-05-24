package ru.appcommerce.photoviewer.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.presenter.DetailPresenter;

public class DetailActivity extends MvpAppCompatActivity implements IDetailPresenter {
    private static final String TAG = "DetailPresenter";

    @InjectPresenter
    public DetailPresenter presenter;

    @BindView(R.id.toolbar_details)
    Toolbar toolbar;
    @BindView(R.id.fullscren_photo)
    ImageView fullscreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        initAppBar();
    }

    private void initAppBar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    public void showLog(int position) {
        Log.d(TAG, "Current position: " + position);
    }

    @Override
    public void showPhoto(String urlContent) {
        Picasso.get().load(urlContent).into(fullscreen);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
