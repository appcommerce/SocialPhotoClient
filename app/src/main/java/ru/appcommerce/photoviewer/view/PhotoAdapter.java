package ru.appcommerce.photoviewer.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.appcommerce.photoviewer.R;
import ru.appcommerce.photoviewer.model.Hit;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {
    private List<Hit> content;
    private IPhotoClickListener photoClickListener;

    public PhotoAdapter(List<Hit> content) {
        this.content = content;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(holder.photoView != null){
            Picasso.get().load(content.get(position).getWebFormatUrl()).into(holder.photoView);
            holder.photoView.setOnClickListener(v -> photoClickListener.openPhoto(position, content.get(position).getLargeImageUrl()));
        }
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public void setPhotoClickListener(IPhotoClickListener listener){
        this.photoClickListener = listener;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.myphoto)
        ImageView photoView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
