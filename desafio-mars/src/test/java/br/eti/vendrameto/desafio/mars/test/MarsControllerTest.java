/*
 * COPYRIGHT. ITALO VENDRAMETO 2017. ALL RIGHTS RESERVED.
 */
package br.eti.vendrameto.desafio.mars.test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

/**
 * @author (iVedrameto) Italo Vendrameto
 */
@RunWith(SpringRunner.class)
public class MarsControllerTest {

	private static final String URL_BASE = "http://localhost:8080/rest/mars/";

	@Before
	public void init() {
		RestAssured.registerParser("text/plain", Parser.TEXT);
	}

	@Test
	public void testChamadaValida() throws Exception {
		get(URL_BASE + "MMRMMRMM").then().statusCode(200).contentType(ContentType.TEXT).body(containsString("(2, 0, S)"));
	}

	@Test
	public void testChamadaValida2() throws Exception {
		get(URL_BASE + "MML").then().statusCode(200).contentType(ContentType.TEXT).body(containsString("(0, 2, W)"));
	}

	@Test
	public void testDuplaChamadaValida() throws Exception {
		get(URL_BASE + "MML").then().statusCode(200).contentType(ContentType.TEXT).body(containsString("(0, 2, W)"));
		get(URL_BASE + "MML").then().statusCode(200).contentType(ContentType.TEXT).body(containsString("(0, 2, W)"));
	}

	@Test
	public void testChamadaComandoInvalido() throws Exception {
		get(URL_BASE + "AAA").then().statusCode(400).contentType(ContentType.TEXT).body(containsString(""));
	}

	@Test
	public void testChamadaMovimentoForaDaRegiano() throws Exception {
		get(URL_BASE + "MMMMMMMMMMMMMMMMMMMMMMMM").then().statusCode(400).contentType(ContentType.TEXT).body(containsString(""));
	}
}
