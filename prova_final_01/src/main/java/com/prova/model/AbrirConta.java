package com.prova.model;

import java.util.Scanner;

public class AbrirConta {

    private static Conta conta;
    
    public static Conta abrirConta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do Cliente: ");
        String nome = scan.nextLine();
        System.out.println("Tipo de Cliente: 1 - Pessoa Física | 2 - Pessoa Jurídica");
        Integer codigoTipoCliente = scan.nextInt();
        TipoCliente tipo = null;
        if (codigoTipoCliente == 1 || codigoTipoCliente == 2) {
            tipo = converteCodigoParaTipoCliente(codigoTipoCliente);
        } else {
            System.out.println("Tipo de cliente inexistente.");
        }

        Cliente titular = new Cliente(nome, tipo);

        TipoConta tipoConta = null;

        if (tipo == TipoCliente.PESSOAJURIDICA) {
            System.out.println("Que conta deseja abrir? 1 - Conta Corrente | 2 - Conta Investimento");
            Integer codigoConta = scan.nextInt();
            if (codigoConta == 1 || codigoConta == 2) {
                tipoConta = converteCodigoParaTipoContaJuridica(codigoConta);
            } else {
                System.out.println("Tipo de conta inexistente.");
            }
        } else {
            System.out.println("Que conta deseja abrir? 1 - Conta Corrente | 2 - Conta Poupança | 3 - Conta Investimento");
            Integer codigoConta = scan.nextInt();
            if (codigoConta == 1 || codigoConta == 2 || codigoConta == 3) {
                tipoConta = converteCodigoParaTipoContaFisica(codigoConta);
            } else {
                System.out.println("Tipo de conta inexistente.");
            }
        }

        conta = new Conta(titular, tipoConta);

        System.out.println("Conta criada com sucesso!!");

        return conta;

    }

    public static TipoCliente converteCodigoParaTipoCliente(Integer codigo) {
        TipoCliente tipoCliente = null;
        switch (codigo) {
            case 1:
                tipoCliente = TipoCliente.PESSOAFISICA;
                break;
            case 2:
                tipoCliente = TipoCliente.PESSOAJURIDICA;
                break;
        }
        return tipoCliente;
    }

    public static TipoConta converteCodigoParaTipoContaFisica(Integer codigo) {
        TipoConta tipoConta = null;
        switch (codigo) {
            case 1:
                tipoConta = TipoConta.CONTACORRENTE;
                break;
            case 2:
                tipoConta = TipoConta.CONTAPOUPANCA;
                break;
            case 3:
                tipoConta = TipoConta.CONTAINVESTIMENTO;
                break;
        }
        return tipoConta;
    }

    public static TipoConta converteCodigoParaTipoContaJuridica(Integer codigo) {
        TipoConta tipoConta = null;
        switch (codigo) {
            case 1:
                tipoConta = TipoConta.CONTACORRENTE;
                break;
            case 2:
                tipoConta = TipoConta.CONTAINVESTIMENTO;
                break;
        }
        return tipoConta;
    }

}
