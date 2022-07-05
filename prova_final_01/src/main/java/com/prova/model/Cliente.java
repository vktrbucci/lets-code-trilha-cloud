package com.prova.model;

public class Cliente {
    
    private String nome;
    private TipoCliente tipo;

    public Cliente(String nome, TipoCliente tipo) {
        this.setNome(nome);
        this.setTipo(tipo);
    }    

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return TipoCliente return the tipo
     */
    public TipoCliente getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

}
