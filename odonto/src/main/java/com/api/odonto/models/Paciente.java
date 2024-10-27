package com.api.odonto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Column(name = "nome",length = 100,nullable = false)
    @NotEmpty
    @NotNull
    private String nome;

    @Column(name = "rg" ,length = 20, nullable = false,unique = true,updatable = false)
    @NotNull
    @NotEmpty
    private String rg;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    @JsonIgnore
    private Long id;


    @Column(name ="cpf",length = 15, updatable = false,nullable = false,unique = true)
    @NotNull
    @NotEmpty
    private String cpf;

    @Column(name = "data_nascimento",nullable = false)
    @NotNull
    private Date data_nascimento;

    @Column(name = "idade",nullable = false)
    @NotNull
    private int idade;

    @Column(name = "endereco",length = 255,nullable = false)
    @NotNull
    @NotEmpty
    private String endereco;

    @Column(name = "numero",length = 255,nullable = false)
    @NotNull
    private String numero;


    public Paciente() {
    }


    public Paciente(String nome, String rg, Long id, String cpf, Date data_nascimento, int idade, String endereco, String numero) {
        this.nome = nome;
        this.rg = rg;
        this.id = id;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.idade = idade;
        this.endereco = endereco;
        this.numero = numero;
    }

    public @NotEmpty @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty @NotNull String nome) {
        this.nome = nome;
    }

    public @NotNull @NotEmpty String getRg() {
        return rg;
    }

    public void setRg(@NotNull @NotEmpty String rg) {
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotEmpty String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotEmpty String cpf) {
        this.cpf = cpf;
    }

    public @NotNull  Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(@NotNull Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @NotNull
    public int getIdade() {
        return idade;
    }

    public void setIdade(@NotNull @NotEmpty int idade) {
        this.idade = idade;
    }

    public @NotNull @NotEmpty String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotEmpty String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @NotEmpty String getNumero() {
        return numero;
    }

    public void setNumero(@NotNull @NotEmpty String numero) {
        this.numero = numero;
    }
}
