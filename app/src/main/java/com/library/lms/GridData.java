package com.library.lms;

import android.graphics.drawable.Drawable;

public class GridData {
    public int img;
    public String text;

    public GridData(int img, String text) {
        this.img = img;
        this.text = text;
    }

    public int getImg() { return img; }
    public String getText() { return text; }
}
