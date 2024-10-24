package com.hakkinent.defaultmethods;

public class Main {
    public static void main(String[] args) {
        Funcionario funPubl = new FuncionarioPublico(3500.0);
        System.out.println(funPubl.calcSalarioLiquido());
    }
}
