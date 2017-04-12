/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.types;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
public enum OrientationType {

	NORTH(1, "N", "Norte", 1, AxisType.Y), 
	EAST(2, "E", "Leste", 1, AxisType.X), 
	SOUTH(3, "S", "Sul", -1, AxisType.Y), 
	WEST(4, "W", "Oeste", -1, AxisType.X);

	Integer code;
	String acronym;
	String description;
	Integer factor;
	AxisType axisAffect;

	/**
	 * @param code
	 * @param acronym
	 * @param description
	 * @param factor
	 * @param axisAffect
	 */
	OrientationType(Integer code, String acronym, String description, Integer factor, AxisType axisAffect) {
		this.code = code;
		this.acronym = acronym;
		this.description = description;
		this.factor = factor;
		this.axisAffect = axisAffect;
	}

	/**
	 * 
	 * @param pos
	 * @return
	 */
	public static OrientationType getOrientationByCode(Integer pos) {
		if (Integer.valueOf(0).equals(pos)) {
			pos = 4;
		}
		if (Integer.valueOf(5).equals(pos)) {
			pos = 1;
		}
		for (OrientationType ori : OrientationType.values()) {
			if (ori.getCode().equals(pos)) {
				return ori;
			}
		}
		return null;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the factor
	 */
	public Integer getFactor() {
		return factor;
	}

	/**
	 * @param factor
	 *            the factor to set
	 */
	public void setFactor(Integer factor) {
		this.factor = factor;
	}

	/**
	 * @return the axisAffect
	 */
	public AxisType getAxisAffect() {
		return axisAffect;
	}

	/**
	 * @param axisAffect
	 *            the axisAffect to set
	 */
	public void setAxisAffect(AxisType axisAffect) {
		this.axisAffect = axisAffect;
	}

	/**
	 * @return the acronym
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param acronym
	 *            the acronym to set
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

}
