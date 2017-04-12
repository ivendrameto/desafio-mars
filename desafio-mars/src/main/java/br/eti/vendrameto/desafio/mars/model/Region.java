/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.model;

import java.io.Serializable;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
public class Region implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -379370487529877725L;

	private Position initialPositon;
	private Position finalPosition;

	/**
	 * Construtor padrão.
	 */
	public Region() {
	}

	/**
	 * Construtor.
	 * 
	 * @param initialPositon
	 * @param finalPosition
	 */
	public Region(Position initialPositon, Position finalPosition) {
		this();
		this.initialPositon = initialPositon;
		this.finalPosition = finalPosition;
	}

	/**
	 * @return the initialPositon
	 */
	public Position getInitialPositon() {
		return initialPositon;
	}

	/**
	 * @param initialPositon
	 *            the initialPositon to set
	 */
	public void setInitialPositon(Position initialPositon) {
		this.initialPositon = initialPositon;
	}

	/**
	 * @return the finalPosition
	 */
	public Position getFinalPosition() {
		return finalPosition;
	}

	/**
	 * @param finalPosition
	 *            the finalPosition to set
	 */
	public void setFinalPosition(Position finalPosition) {
		this.finalPosition = finalPosition;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Region [initialPositon=" + initialPositon + ", finalPosition=" + finalPosition + "]";
	}

}
