package com.hakkinent.generics;

import java.util.List;

public class Calculator {
    public static <T extends Comparable<T>> T max(List<T> list){
        if(list.isEmpty()){
            throw new IllegalStateException("List não pode ser vazia");
        }
        
        T max = list.get(0);
        for(T item : list){
            if(item.compareTo(max) > 0){
                max = item;
            }
        }

        return max;
    }
}
