package com.hakkinent.defaultmethods;

public interface Funcionario {
    double getSalary();

    double calcDescontosPrevidencia();
    double calcDescontosPlanoSaude();
    double calcOutrosDescontos();

    default double calcSalarioLiquido(){
        double prev = calcDescontosPrevidencia();
        double saude = calcDescontosPlanoSaude();
        double outros = calcOutrosDescontos();

        return getSalary() - prev - saude - outros;
    }
}
