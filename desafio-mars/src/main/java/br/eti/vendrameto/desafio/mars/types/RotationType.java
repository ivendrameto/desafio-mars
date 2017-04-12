/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.types;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
public enum RotationType {
	LEFT(1, -1), RIGHT(2, 1);

	Integer code;
	Integer orientationAffect;

	/**
	 * @param code
	 * @param orientationAffect
	 */
	RotationType(Integer code, Integer orientationAffect) {
		this.code = code;
		this.orientationAffect = orientationAffect;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the orientationAffect
	 */
	public Integer getOrientationAffect() {
		return orientationAffect;
	}

	/**
	 * @param orientationAffect
	 *            the orientationAffect to set
	 */
	public void setOrientationAffect(Integer orientationAffect) {
		this.orientationAffect = orientationAffect;
	}

}
