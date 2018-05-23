package com.example.han.chucknorris;

import java.util.Arrays;

/**
 * Created by per6 on 1/29/18.
 */

public class Joke {
    private String[] category;
    private String icon_url;
    private String id;
    private String url;
    private String value;

    public Joke()
    {
        this.category = new String[] {null};
        this.icon_url = null;
        this.id = null;
        this.url = null;
        this.value = null;
    }

    public Joke(String[] category, String icon_url, String id, String url, String value) {
        this.category = category;
        this.icon_url = icon_url;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "category=" + Arrays.toString(category) +
                ", icon_url='" + icon_url + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
