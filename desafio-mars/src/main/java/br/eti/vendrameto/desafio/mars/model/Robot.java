/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.model;

import java.io.Serializable;

import br.eti.vendrameto.desafio.mars.exceptions.NavigationErrorException;
import br.eti.vendrameto.desafio.mars.types.AxisType;
import br.eti.vendrameto.desafio.mars.types.OrientationType;
import br.eti.vendrameto.desafio.mars.types.RotationType;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
public class Robot implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3931555253280277442L;

	private String name;
	private Position position;
	private OrientationType orientation;
	private Region region;

	/**
	 * Construtor padrão.
	 */
	public Robot() {
		this.position = new Position(0, 0);
		this.orientation = OrientationType.NORTH;
	}

	/**
	 * Construtor.
	 * 
	 * @param name
	 * @param region
	 */
	public Robot(String name, Region region) {
		this();
		this.name = name;
		this.region = region;
	}
	
	/**
	 * Move o robo.
	 * 
	 * @return
	 * @throws NavigationErrorException 
	 */
	public Position move() throws NavigationErrorException {
		if (orientation.getAxisAffect().equals(AxisType.X)) {
			position.setXAxis(position.getXAxis() + orientation.getFactor());
		} else if (orientation.getAxisAffect().equals(AxisType.Y)) {
			position.setYAxis(position.getYAxis() + orientation.getFactor());
		}

		validatePosition();
		
		return position;
	}
	
	/**
	 * Verifica se a atual posição do robo está na região delimitada.
	 * 
	 * @throws NavigationErrorException 
	 */
	private void validatePosition() throws NavigationErrorException {
		if (position.getXAxis() < region.getInitialPositon().getXAxis() ||
				position.getXAxis() > region.getFinalPosition().getXAxis() ||
				position.getYAxis() < region.getInitialPositon().getYAxis() ||
				position.getYAxis() > region.getFinalPosition().getYAxis() ) {
			// Robo saiu da área delimitada
			throw new NavigationErrorException();
		}
	}
	
	/**
	 * Gira o robo deacordo com o comando de rotação.
	 * 
	 * @param rotation
	 */
	public void turnTo(RotationType rotation) {
		Integer pos = orientation.getCode() + rotation.getOrientationAffect();
		orientation = OrientationType.getOrientationByCode(pos);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the orientation
	 */
	public OrientationType getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 *            the orientation to set
	 */
	public void setOrientation(OrientationType orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

}
