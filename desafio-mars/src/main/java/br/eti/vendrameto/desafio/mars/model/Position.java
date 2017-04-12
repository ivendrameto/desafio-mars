/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.model;

import java.io.Serializable;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
public class Position implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6950560151157312725L;

	private Integer xAxis;
	private Integer yAxis;

	/**
	 * Construtor.
	 * 
	 * @param xAxis
	 * @param yAxis
	 */
	public Position(Integer xAxis, Integer yAxis) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	/**
	 * @return the xAxis
	 */
	public Integer getXAxis() {
		return xAxis;
	}

	/**
	 * @param xAxis
	 *            the xAxis to set
	 */
	public void setXAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * @return the yAxis
	 */
	public Integer getYAxis() {
		return yAxis;
	}

	/**
	 * @param yAxis
	 *            the yAxis to set
	 */
	public void setYAxis(Integer yAxis) {
		this.yAxis = yAxis;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
	}
}
