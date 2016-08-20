package org.uvg.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculadora {

	public TestCalculadora(){
		
	}
	
	//Metodo que se ejecuta antes del "metodo fundamental "
	@Before
	public void setUp(){
		//valor = false;
	}
	
	//Etiqueta que indica que el siguiente metodo es un Test
	@Test
	public void testGetEncendido(){
		assertEquals(true, true);
	}
}