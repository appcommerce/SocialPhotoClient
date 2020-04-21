package ru.appcommerce.photoviewer.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.presenter.IRecyclerMainPresenter;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

    private IRecyclerMainPresenter iRecyclerMainPresenter;


    public PhotoAdapter(IRecyclerMainPresenter iRecyclerMainPresenter) {
        this.iRecyclerMainPresenter = iRecyclerMainPresenter;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.position = position;
        iRecyclerMainPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return iRecyclerMainPresenter.getItemCount();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        @BindView(R.id.myphoto)
        ImageView photoView;
        private int position = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setPhoto(int drawable) {
            photoView.setImageResource(drawable);
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public void showMoreListener(View.OnClickListener listener) {
            photoView.setOnClickListener(listener);
        }
    }
}
