package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC1_MEDICACAO")
@SequenceGenerator(name="sqMedicacao", sequenceName="SQ_MEDICACAO", allocationSize=1)
public class Medicacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqMedicacao")
	@Column(name="CD_MEDICACAO", nullable=false)
	private int codigo;
	
	@Column(name="NM_DOSAGEM", nullable=false)
	private double dosagem; // quantidade de gotas, mls ou de pírulas
	
	@Column(name="NM_INTERVALO_HORAS", nullable=false)
	private int intervalo; // De quantas em quantas horas será tomado.
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_INICIO", nullable=false)
	private Calendar dataInicio; //Data de inicio do tratamento
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIM")
	private Calendar dataTermino; //Data término do tratamento
	
	@Column(name="QNT_DIAS")
	private int pediodo;  //Por quantos dias será tomado o medicamento
	
	@ManyToOne
	private Pessoa pessoa;
	
	@ManyToOne
	private Remedio remedio;
	
	
		
	public Medicacao(int codigo, double dosagem, int intervalo,
			Calendar dataInicio, Calendar dataTermino, int pediodo,
			Pessoa pessoa, Remedio remedio) {
		super();
		this.codigo = codigo;
		this.dosagem = dosagem;
		this.intervalo = intervalo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.pediodo = pediodo;
		this.pessoa = pessoa;
		this.remedio = remedio;
	}
	
	public Medicacao() {
		super();
	}

	//Getters and setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public int getPediodo() {
		return pediodo;
	}
	public void setPediodo(int pediodo) {
		this.pediodo = pediodo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Remedio getRemedio() {
		return remedio;
	}
	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}
	public double getDosagem() {
		return dosagem;
	}
	public void setDosagem(double dosagem) {
		this.dosagem = dosagem;
	}
	public Calendar getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
	
}
