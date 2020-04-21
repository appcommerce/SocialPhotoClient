package ru.appcommerce.photoviewer.presenter;

import ru.appcommerce.photoviewer.view.IViewHolder;

public interface IRecyclerMainPresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
}
