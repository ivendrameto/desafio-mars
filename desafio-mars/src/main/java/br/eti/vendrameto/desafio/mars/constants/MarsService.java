/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.eti.vendrameto.desafio.mars.exceptions.InvalidActionException;
import br.eti.vendrameto.desafio.mars.exceptions.NavigationErrorException;
import br.eti.vendrameto.desafio.mars.model.Region;
import br.eti.vendrameto.desafio.mars.model.Robot;
import br.eti.vendrameto.desafio.mars.types.RotationType;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
@Service
public class MarsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * @param region
	 * @param actions
	 * @return
	 * @throws InvalidActionException
	 * @throws NavigationErrorException
	 */
	public String explore(Region region, String actions) throws InvalidActionException, NavigationErrorException {
		logger.debug(String.format("explore Region [%s] Actions [%s]", region, actions));

		if (!validateActions(actions)) {
			throw new InvalidActionException();
		}

		Robot robot = new Robot(MarsConstants.ROBOT_CURIOSIT, region);

		for (char action : actions.toCharArray()) {
			logger.debug(String.format("{%s, %s, %s}", robot.getPosition().getXAxis(), robot.getPosition().getYAxis(),
					robot.getOrientation().getAcronym()));
			switch (action) {
			case 'M':
				robot.move();
				break;
			case 'L':
				robot.turnTo(RotationType.LEFT);
				break;
			case 'R':
				robot.turnTo(RotationType.RIGHT);
				break;
			}
		}

		String result = String.format("(%s, %s, %s)", robot.getPosition().getXAxis(), robot.getPosition().getYAxis(),
				robot.getOrientation().getAcronym());

		logger.debug(String.format("explore Action [%s] Result [%s]", actions, result));

		return result;
	}

	/**
	 * 
	 * @param actions
	 * @return
	 */
	public boolean validateActions(String actions) {
		String pattern = "[MLR\\s]*";
		return actions.matches(pattern);
	}
}
