package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC1_PESSOA")
public class Pessoa {
	
	 @Id
	 @Column(name="NR_CPF", nullable=false)
	 private long cpf;
	 
	 @Column(name="NM_PESSOA", nullable=false)
	 private String nome;
	 
	 @Column(name="NR_IDADE")
	 private int idade;
	 
	 @Enumerated(EnumType.STRING)
	 @Column(name="DS_SEXO")
	 private Sexo sexo;
	 
	 @OneToMany(mappedBy="pessoa")
	 private List<Medicacao> medicacoes;	 
	 

	public Pessoa(long cpf, String nome, int idade, Sexo sexo,
			List<Medicacao> medicacoes) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.medicacoes = medicacoes;
	}
	 
	public Pessoa() {
		super();
	}

	//Getters and setters
	public List<Medicacao> getMedicacoes() {
		return medicacoes;
	}
	
	public void setMedicacoes(List<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}
