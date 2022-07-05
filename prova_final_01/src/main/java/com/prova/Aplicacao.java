package com.prova;

import java.math.BigDecimal;
import java.util.Scanner;

import com.prova.model.AbrirConta;
import com.prova.model.Conta;


/**
 * Aplicação destinada à resolução do problema elaborado pela primeira prova na trilha cloud da Let's Code.
 *
 */
public class Aplicacao 
{
    public static void main( String[] args )
    {
        Integer opcao = 0;
        BigDecimal valor = new BigDecimal("0.00");
        String numeroConta = "";

        System.out.println("Bem-vindo ao Banco zoado:");
        System.out.println("Primeiro, precisaremos de alguns dados para criar uma conta...");
        Conta conta  = AbrirConta.abrirConta();
        Conta.listagemContas.add(conta);

        do {
            System.out.printf("\n%s - %s\n", conta.getNumero(), conta.getTitular().getNome());
            System.out.println("\nEscolha uma opção: \n1 - Abrir conta;\n2 - Depositar;\n3 - Sacar;\n4 - Transferir;\n5 - Investir;\n6 - Consultar Saldo;\n8 - Trocar de Conta;\n9 - Sair.");
            System.out.println();
    
            opcao = new Scanner(System.in).nextInt();

            switch (opcao) {
                case 1:
                    Conta novaConta  = AbrirConta.abrirConta();
                    Conta.listagemContas.add(novaConta);
                    conta = novaConta;
                    break;
                case 2:
                    System.out.print("Valor a depositar: ");
                    valor = new Scanner(System.in).nextBigDecimal();
                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 3:
                    System.out.print("Valor a sacar: ");
                    valor = new Scanner(System.in).nextBigDecimal();
                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso.");
                    break;
                case 4:
                    System.out.println("Contas disponíveis para transferência: ");
                    Conta.listarContas();
                    System.out.print("Digite o número da conta para a qual deseja transferir: ");
                    numeroConta = new Scanner(System.in).nextLine();
                    Conta contaDestino = conta.escolherConta(numeroConta);
                    System.out.print("Digite o valor a ser transferido: ");
                    valor = new Scanner(System.in).nextBigDecimal();
                    conta.transferir(valor, contaDestino);
                    System.out.println("Transferência realizada com sucesso.");
                    break;
                case 5:
                    System.out.print("Valor a investir: ");
                    valor = new Scanner(System.in).nextBigDecimal();
                    conta.investir(valor);
                    break;
                case 6:
                    conta.consultarSaldo();
                    break;
                case 8: 
                    System.out.println("Contas disponíveis para acessar: ");
                    Conta.listarContas();
                    System.out.print("Digite o número da conta que deseja acessar: ");
                    numeroConta = new Scanner(System.in).nextLine();
                    conta = conta.escolherConta(numeroConta);
                    break;
            }    

        } while (opcao != 9);


        System.out.println("Operação finalizada.");
        
    }
}
