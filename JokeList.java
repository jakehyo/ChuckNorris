package com.example.han.chucknorris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by per6 on 1/29/18.
 */

public class JokeList {
    private int total;
    private List<Joke> result;
    private Joke joke = new Joke();

    public JokeList()
    {
        this.total = 0;
        this.result= new ArrayList<Joke>(){};
    }

    public JokeList(int total, List<Joke> result) {
        this.total = total;
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Joke> getResult() {
        return result;
    }

    public void setResult(List<Joke> result) {
        this.result = result;
    }

    public void listClear(){
        result.clear();
    }
    public void  totalClear(){
        total = 0;
    }
}
