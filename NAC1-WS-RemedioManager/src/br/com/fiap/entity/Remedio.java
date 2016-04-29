package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC1_REMEDIO")
@SequenceGenerator(name="sqRemedio", sequenceName="SQ_NAC1_REMEDIO", allocationSize=1)
public class Remedio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqRemedio")
	@Column(name="CD_REMEDIO", nullable=false)
	private int codigo;
	
	@Column(name="NM_REMEDIO", nullable=false)
	private String nome;
		
	@Column(name="DS_REMEDIO")
	private String descricao;
		
	@Enumerated(EnumType.STRING)
	@Column(name="NM_TIPO_REMEDIO", nullable=false)
	private TipoRemedio tipo;
	
	public Remedio(int codigo, String nome, String descricao, TipoRemedio tipo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
	}
			
	public Remedio() {
		super();
	}

	//Getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoRemedio getTipo() {
		return tipo;
	}
	public void setTipo(TipoRemedio tipo) {
		this.tipo = tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
