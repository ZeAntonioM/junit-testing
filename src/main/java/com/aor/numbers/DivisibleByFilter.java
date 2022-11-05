package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{

    private int n;

    public DivisibleByFilter(int n_) {n=n_;}
    @Override
    public boolean accept(Integer number)
    {
        if (number%n == 0) return true;
        return false;
    }



}
