package com.hakkinent.generics;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Covariancia");    
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);

        List<? extends Number> list = intList;
        Number x = list.get(0);
        System.out.println(x);
        //! list.add(20) - erro de compilação;

        System.out.println();
        System.out.println("Contravariancia");
        List<Object> objList = new ArrayList<>();
        objList.add("Maria");
        objList.add("João");

        List<? super Number> list2 = objList;
        //! Number x2 = list2.get(0) - erro de compilação;
        list2.add(20);
    }

    
}
