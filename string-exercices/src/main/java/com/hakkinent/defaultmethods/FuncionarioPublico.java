package com.hakkinent.defaultmethods;

public class FuncionarioPublico implements Funcionario{
    private double salary;

    public FuncionarioPublico() {
    }

    public FuncionarioPublico(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcDescontosPrevidencia() {
        return 100.0;
    }

    @Override
    public double calcDescontosPlanoSaude() {
        return 380.0;
    }

    @Override
    public double calcOutrosDescontos() {
        return 50.0;
    }

        

}
