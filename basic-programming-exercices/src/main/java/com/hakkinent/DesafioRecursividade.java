package com.hakkinent;

import java.util.*;

public class DesafioRecursividade {
    public static void main(String[] args) {
        String[] arr = new String[]{
            "8349,14/09/2024,899.9,ESPORTE", 
            "4837,17/09/2024,530.0,VESTUARIO", 
            "15281,21/09/2024,1253.99,ESPORTE", 
            "15344,27/09/2024,1000.9,VESTUARIO", 
            "18317,04/10/2024,250.4,VESTUARIO", 
            "18972,11/10/2024,385.5,JARDINAGEM" 
        };

        List<String> sales = Arrays.asList(arr);

        DesafioRecursividade desafio = new DesafioRecursividade();
        double[] result = desafio.totalSales(sales, "VESTUARIO");
        System.out.println(desafio.print(result));
        
    }

    public double[] totalSales(List<String> sales, String department) {
        return totalSalesTail(sales, department, new double[]{0.0, 0.0});
    }


    private double[] totalSalesTail(List<String> sales, String department, double[] result) {
        if(sales.isEmpty()){
            
            return result;
        }

        String head = sales.get(0);
        List<String> tail = sales.subList(1, sales.size());

        String[] data = head.split(",");

        
        if(data[3].equals(department)){
            result[0]++;
            result[1] += Double.parseDouble(data[2]);
        }

        return totalSalesTail(tail, department, result);
    }

    public String print(double[] arr){
        Locale.setDefault(new Locale("en", "US"));

        String count = String.format("%.0f", arr[0]);
        String total = String.format("%.2f", arr[1]);
        
        StringBuilder sb = new StringBuilder();

        String textSale = arr[0] > 1 ? " VENDAS" : " VENDA";

        sb.append(count).append(textSale).append("\n");
        sb.append("TOTAL = $ ").append(total);

        
        return sb.toString();
    }
}
