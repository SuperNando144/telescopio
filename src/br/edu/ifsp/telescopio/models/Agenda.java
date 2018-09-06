package br.edu.ifsp.telescopio.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AGENDA")
public class Agenda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "AGE_COD")
	private long age_cod;
	
	@JoinColumn(name = "USU_COD",referencedColumnName = "USU_COD")
	@NotNull
	@ManyToOne
	private Usuario usu_cod;
	
	@Column(name = "AGE_DATA")
	@NotNull
	private Date age_data;
	
	@Column(name = "AGE_COORD_AZIMUTE")
	private Double age_coord_azimute;
	
	@Column(name = "AGE_COORD_DECLIN")
	private Double age_coord_declin;

	public long getAge_cod() {
		return age_cod;
	}

	public void setAge_cod(long age_cod) {
		this.age_cod = age_cod;
	}

	public Usuario getUsu_cod() {
		return usu_cod;
	}

	public void setUsu_cod(Usuario usu_cod) {
		this.usu_cod = usu_cod;
	}

	public Date getAge_data() {
		return age_data;
	}

	public void setAge_data(Date age_data) {
		this.age_data = age_data;
	}

	public Double getAge_coord_azimute() {
		return age_coord_azimute;
	}

	public void setAge_coord_azimute(Double age_coord_azimute) {
		this.age_coord_azimute = age_coord_azimute;
	}

	public Double getAge_coord_declin() {
		return age_coord_declin;
	}

	public void setAge_coord_declin(Double age_coord_declin) {
		this.age_coord_declin = age_coord_declin;
	}

	@Override
	public String toString() {
		return "Agenda [age_cod=" + age_cod + ", usu_cod=" + usu_cod + ", age_data=" + age_data + ", age_coord_azimute="
				+ age_coord_azimute + ", age_coord_declin=" + age_coord_declin + "]";
	}
	
	
}
