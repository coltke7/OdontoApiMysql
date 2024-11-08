package com.api.odonto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
    
    @OneToOne(mappedBy = "paciente")
    private Historico historico;

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
    
    @Column(name = "genero")
    @NotNull
    private char genero;
    
    @ElementCollection
    @CollectionTable(name = "medi_list", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "medicacao")
    private List<String> medicacao;
    
    @Column(name = "hipertensao")
    @NotNull
    private char hipertensao;
    
    @Column(name = "gravidez")
    @NotNull
    private char gravidez;
    
    @Column(name = "avc")
    @NotNull
    private char avc;

    @ElementCollection
    @CollectionTable(name = "alergia_list", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "alergia")
    @NotNull
    private List<String> alergia;
    
    @ElementCollection
    @CollectionTable(name = "cirurgia_list", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "cirurgia")
    @NotNull
    private List<String>cirurgia;

    
    public Paciente() {
    
    }
    
	public Paciente(@NotEmpty @NotNull String nome, @NotNull @NotEmpty String rg, Long id,
			@NotNull @NotEmpty String cpf, @NotNull Date data_nascimento, @NotNull int idade,
			@NotNull @NotEmpty String endereco, @NotNull String numero, @NotNull char genero,
			@NotNull List<String> medicacao, @NotNull char hipertensao, @NotNull char gravidez, @NotNull char avc,
			@NotNull List<String> alergia, @NotNull List<String> cirurgia) {
		this.nome = nome;
		this.rg = rg;
		this.id = id;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.idade = idade;
		this.endereco = endereco;
		this.numero = numero;
		this.genero = genero;
		this.medicacao = medicacao;
		this.hipertensao = hipertensao;
		this.gravidez = gravidez;
		this.avc = avc;
		this.alergia = alergia;
		this.cirurgia = cirurgia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public List<String> getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(List<String> medicacao) {
		this.medicacao = medicacao;
	}

	public char getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(char hipertensao) {
		this.hipertensao = hipertensao;
	}

	public char getGravidez() {
		return gravidez;
	}

	public void setGravidez(char gravidez) {
		this.gravidez = gravidez;
	}

	public char getAvc() {
		return avc;
	}

	public void setAvc(char avc) {
		this.avc = avc;
	}

	public List<String> getAlergia() {
		return alergia;
	}

	public void setAlergia(List<String> alergia) {
		this.alergia = alergia;
	}

	public List<String> getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(List<String> cirurgia) {
		this.cirurgia = cirurgia;
	}
	
	
    
    
    
    
    
}

  