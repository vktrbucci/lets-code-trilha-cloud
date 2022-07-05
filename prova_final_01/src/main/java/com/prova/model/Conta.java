package com.prova.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Conta {

    private String numero;
    private Cliente titular;
    private BigDecimal saldo = new BigDecimal("0.00");
    private TipoConta tipoConta;
    private static Integer quantidadeContas = 1;
    public static ArrayList<Conta> listagemContas = new ArrayList<Conta>();

    public Conta(Cliente titular, TipoConta tipoConta) {
        this.setTitular(titular);
        this.setTipoConta(tipoConta);
        this.setNumero();
        this.quantidadeContas++;
    }

    public void sacar(BigDecimal valor) {
        BigDecimal taxa = new BigDecimal(0.00);
        if (this.titular.getTipo() == TipoCliente.PESSOAJURIDICA) {
            taxa = valor.multiply(new BigDecimal("0.005"));
        }

        if (valor.doubleValue() + taxa.doubleValue() <= saldo.doubleValue()) {
            this.saldo = this.saldo.subtract(valor).subtract(taxa);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    };

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    };

    public void transferir(BigDecimal valor, Conta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    };

    public void investir(BigDecimal valor) {
        if (this.getSaldo().doubleValue() >= valor.doubleValue()) {
            Random gerador = new Random();
            Double bonusInvestimento = 0.0;
            if (this.tipoConta == TipoConta.CONTAINVESTIMENTO && this.titular.getTipo() == TipoCliente.PESSOAJURIDICA) {
                bonusInvestimento = 0.02;
            }
            Double aleatorio = (double) gerador.nextInt(100);
            Double taxaRendimento = (aleatorio / 100) - 0.05 + bonusInvestimento;
            BigDecimal valorRendimento = valor.multiply(new BigDecimal(taxaRendimento));
            this.saldo = this.saldo.add(valorRendimento);
            System.out.printf("Taxa de rendimento: %f\n", taxaRendimento);
            System.out.printf("Valor do rendimento: R$ %.2f.", valorRendimento);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    };

    public void consultarSaldo() {
        System.out.printf("Saldo: R$ %.2f\n", this.saldo.doubleValue());
    };

    public static void listarContas() {
        for (Conta conta : listagemContas) {
            System.out.printf("Número: %s\n", conta.getNumero());
            System.out.printf("Tirular: %s\n", conta.getTitular().getNome());
            System.out.println("--------");
        }
    }

    public Conta escolherConta(String numeroConta) {
        for (Conta conta : listagemContas) {
            if (conta.getNumero().contentEquals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getQuantidadeContas() {
        return quantidadeContas;
    }

    private String gerarNumero() {
        String numero = String.format("%06d", this.getQuantidadeContas());
        return numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero() {
        this.numero = gerarNumero();
    }

}
