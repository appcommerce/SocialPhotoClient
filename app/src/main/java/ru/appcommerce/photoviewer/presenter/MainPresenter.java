package ru.appcommerce.photoviewer.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.List;

import ru.appcommerce.photoviewer.model.Data;
import ru.appcommerce.photoviewer.model.ModelHandler;
import ru.appcommerce.photoviewer.view.DetailActivity;
import ru.appcommerce.photoviewer.view.IViewHolder;


public class MainPresenter {

    private RecyclerMainPresenter recyclerMainPresenter = new RecyclerMainPresenter();
    private Context context;

    private class RecyclerMainPresenter implements IRecyclerMainPresenter {

        private ModelHandler dataHandler = ModelHandler.getInstance();
        private List<Data> list = dataHandler.getData();

        @Override
        public void bindView(final IViewHolder holder) {
            holder.showMoreListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataHandler.setItemPosition(holder.getPos());
                    dataHandler.setData(holder.getPos());
                    final Intent intent = new Intent(context, DetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RecyclerMainPresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
