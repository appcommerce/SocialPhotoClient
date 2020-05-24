package ru.appcommerce.photoviewer.view;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.appcommerce.photoviewer.App;
import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.model.Hit;
import ru.appcommerce.photoviewer.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements IMainPresenter, IPhotoClickListener{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null){
            presenter.fillPhotoList("marvel", "horizontal", null);
        }
    }

    @Override
    public void loadRecycler(List<Hit> content) {
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        PhotoAdapter photoAdapter = new PhotoAdapter(content);
        photoAdapter.setPhotoClickListener(this);
        recyclerView.setAdapter(photoAdapter);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void openPhoto() {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);
    }
}
