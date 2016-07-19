package com.ecasona.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ecasona.testdatabindingapplication.BR;

/**
 * Created by Administrator on 2016/7/19.
 */

public class User extends BaseObservable {

    private String id;
    private String title;
    private String original_title;
    private String year;


    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return original_title + "\n" + year;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
        notifyPropertyChanged(BR.description);
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.description);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", original_title='" + original_title + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

}
