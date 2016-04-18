package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC1_PESSOA")
public class Pessoa {
	
	 @Id
	 @Column(name="NR_CPF", nullable=false)
	 private long cpf;
	 
	 @Column(name="NM_PESSOA")
	 private String nome;
	 
	 @Column(name="NR_IDADE")
	 private int idade;
	 
	 @Enumerated(EnumType.STRING)
	 @Column(name="DS_SEXO")
	 private Sexo sexo;
		 
	 //Getters and setters
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
