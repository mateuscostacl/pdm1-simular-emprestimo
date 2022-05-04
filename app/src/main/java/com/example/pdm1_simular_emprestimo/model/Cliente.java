package com.example.pdm1_simular_emprestimo.model;

import java.util.Objects;

public class Cliente {
    private String nome;
    private Double salario;
    private Double valorEmprestimo;
    private int parcelas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(salario, cliente.salario) && Objects.equals(valorEmprestimo, cliente.valorEmprestimo) && Objects.equals(parcelas, cliente.parcelas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, salario, valorEmprestimo, parcelas);
    }
}
