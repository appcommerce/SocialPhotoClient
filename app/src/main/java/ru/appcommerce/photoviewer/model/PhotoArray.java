package ru.appcommerce.photoviewer.model;


import com.google.gson.annotations.Expose;

import java.util.List;

public class PhotoArray {
    @Expose
    private List<Hit> hits;
    @Expose
    private Long total;
    @Expose
    private Long totalHits;

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }
}
