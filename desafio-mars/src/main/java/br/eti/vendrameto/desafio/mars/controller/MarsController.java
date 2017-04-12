/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.eti.vendrameto.desafio.mars.exceptions.InvalidActionException;
import br.eti.vendrameto.desafio.mars.exceptions.NavigationErrorException;
import br.eti.vendrameto.desafio.mars.model.Position;
import br.eti.vendrameto.desafio.mars.model.Region;
import br.eti.vendrameto.desafio.mars.services.MarsService;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
@RestController
@RequestMapping("/rest")
public class MarsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MarsService marsService;

	@RequestMapping(value = "/mars/{actions}", method = RequestMethod.GET)
	public ResponseEntity<String> mars(@PathVariable String actions) {
		Region region = new Region(new Position(0, 0), new Position(5, 5));

		ResponseEntity<String> responseEntity = null;

		try {
			String result = marsService.explore(region, actions);
			responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		} catch (InvalidActionException e) {
			logger.error("InvalidActionException", e);
			responseEntity = new ResponseEntity<>("x", HttpStatus.BAD_REQUEST);
		} catch (NavigationErrorException e) {
			logger.error("NavigationErrorException", e);
			responseEntity = new ResponseEntity<>("x", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

}
