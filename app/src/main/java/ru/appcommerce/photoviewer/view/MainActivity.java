package ru.appcommerce.photoviewer.view;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null){
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (savedInstanceState == null){
                if(activeNetwork != null){
                    boolean isLoadFromDB = activeNetwork.isConnectedOrConnecting();
                    if (!isLoadFromDB) {
                        presenter.fillPhotoList("marvel", "horizontal", null);
                    } else {
                        presenter.getPhotosFromDB();
                    }
                }
            }
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
    public void openPhoto(int position, String urlContent) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.POSITION, position);
        intent.putExtra(DetailActivity.URL_LARGE, urlContent);
        startActivity(intent);
    }
}
