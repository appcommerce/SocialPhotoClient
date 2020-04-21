package ru.appcommerce.photoviewer.view;

import android.view.View;

public interface IViewHolder {
    void setPhoto(int id);
    int getPos();
    void showMoreListener(View.OnClickListener listener);
}
