package ru.appcommerce.photoviewer.presenter;

import android.view.View;

import java.util.List;

import ru.appcommerce.photoviewer.model.Data;
import ru.appcommerce.photoviewer.model.ModelHandler;
import ru.appcommerce.photoviewer.view.IViewHolder;


public class MainPresenter {

    private RecyclerMainPresenter recyclerMainPresenter = new RecyclerMainPresenter();
    private View.OnClickListener listener;

    private class RecyclerMainPresenter implements IRecyclerMainPresenter {

        private ModelHandler dataHandler = ModelHandler.getInstance();
        private List<Data> list = dataHandler.getData();

        @Override
        public void bindView(final IViewHolder holder) {
            dataHandler.setData(holder.getPos()+1);
            holder.showMoreListener(listener);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public RecyclerMainPresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
