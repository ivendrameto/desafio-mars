/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.eti.vendrameto.desafio.mars.exceptions.InvalidActionException;
import br.eti.vendrameto.desafio.mars.exceptions.NavigationErrorException;
import br.eti.vendrameto.desafio.mars.model.Position;
import br.eti.vendrameto.desafio.mars.model.Region;
import br.eti.vendrameto.desafio.mars.services.MarsService;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
@RunWith(SpringRunner.class)
public class MarsServiceTest {

	MarsService marsService;
	Region region;
	
	@Before
	public void init() {
		marsService = new MarsService();
		region = new Region(new Position(0, 0), new Position(5, 5));
	}
	
	@Test
	public void testValidActions() {
		assertThat(marsService.validateActions("MMMLMMRMM")).isEqualTo(true);
	}

	@Test
	public void testNotValidActions() {
		assertThat(marsService.validateActions("MMMLMMRMA")).isEqualTo(false);
	}
	
	@Test
	public void testValidarResultado() {
		try {
			assertThat(marsService.explore(region, "MMRMMRMM")).isEqualTo("(2, 0, S)");
		} catch (InvalidActionException e) {
			e.printStackTrace();
		} catch (NavigationErrorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testValidarResultadoDuasChamadas() {
		try {
			marsService.explore(region, "MML");
			assertThat(marsService.explore(region, "MML")).isEqualTo("(0, 2, W)");
		} catch (InvalidActionException e) {
			e.printStackTrace();
		} catch (NavigationErrorException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testResultadoInvalido() {
		try {
			marsService.explore(region, "AAA");
			assertThat(true).isEqualTo(false);
		} catch (InvalidActionException e) {
			assertThat(true).isEqualTo(true);
		} catch (NavigationErrorException e) {
			assertThat(true).isEqualTo(false);
		}
	}
	
	@Test
	public void testResultadoInvalido2() {
		try {
			marsService.explore(region, "MMMMMMMMMMMMMMMMMMMMMMMM");
			assertThat(true).isEqualTo(false);
		} catch (InvalidActionException e) {
			assertThat(true).isEqualTo(false);
		} catch (NavigationErrorException e) {
			assertThat(true).isEqualTo(true);
		}
	}

}
