package com.example.springsocial.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class IdpaqueteDetalle implements Serializable{
	
	
	@Column(name="IDPAQUETE")
	private String IDPAQUETE;
	
	@Column(name="AÑOFOLIO")
	private Integer AÑOFOLIO;
	
	
	
	
	

	public IdpaqueteDetalle() {
	}

	public IdpaqueteDetalle(String iDPAQUETE, Integer aÑOFOLIO) {
		IDPAQUETE = iDPAQUETE;
		AÑOFOLIO = aÑOFOLIO;
	}

	public String getIDPAQUETE() {
		return IDPAQUETE;
	}

	public void setIDPAQUETE(String iDPAQUETE) {
		IDPAQUETE = iDPAQUETE;
	}

	public Integer getAÑOFOLIO() {
		return AÑOFOLIO;
	}

	public void setAÑOFOLIO(Integer aÑOFOLIO) {
		AÑOFOLIO = aÑOFOLIO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AÑOFOLIO == null) ? 0 : AÑOFOLIO.hashCode());
		result = prime * result + ((IDPAQUETE == null) ? 0 : IDPAQUETE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdpaqueteDetalle other = (IdpaqueteDetalle) obj;
		if (AÑOFOLIO == null) {
			if (other.AÑOFOLIO != null)
				return false;
		} else if (!AÑOFOLIO.equals(other.AÑOFOLIO))
			return false;
		if (IDPAQUETE == null) {
			if (other.IDPAQUETE != null)
				return false;
		} else if (!IDPAQUETE.equals(other.IDPAQUETE))
			return false;
		return true;
	}
	
	
	
	
	
	
}
