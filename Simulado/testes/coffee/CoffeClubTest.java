package coffee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeClubTest {
	
	private CoffeClubController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		controller = new CoffeClubController();
	}

	@Test
	void testCadastrarSocio() {
		assertTrue(controller.cadastrarSocio("socio1", "João"));
	}
	
	@Test
    void testCadastrarSocioIgual() {
        controller.cadastrarSocio("socio1", "João");
        try {
            controller.cadastrarSocio("socio1", "Ana");
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Elemento ja existe", iae.getMessage());
        }
    }
	
	@Test
	void testSocioCodigoNulo() {
		try {
			controller.cadastrarSocio(null, "Eduardo");
			fail("Era esperado lançar exceção");
		}catch(IllegalArgumentException iae) {
			assertEquals("Argumentos inválidos", iae.getMessage());
		}
	}
	
	@Test
	void testSocioCodigoVazio() {
		try {
			controller.cadastrarSocio("", "Eduardo");
			fail("Era esperado lançar exceção");
		}catch(IllegalArgumentException iae) {
			assertEquals("Argumentos inválidos", iae.getMessage());
		}
	}
	
	@Test
	void testSocioNomeNulo() {
		try {
			controller.cadastrarSocio(null, "Eduardo");
			fail("Era esperado lançar exceção");
		}catch(IllegalArgumentException iae) {
			assertEquals("Argumentos inválidos", iae.getMessage());
		}
	}
	
	@Test
	void testSocioNomevazio() {
		try {
			controller.cadastrarSocio("", "Eduardo");
			fail("Era esperado lançar exceção");
		}catch(IllegalArgumentException iae) {
			assertEquals("Argumentos inválidos", iae.getMessage());
		}
	}
	
	@Test
	void testCadastrarCafeTradicionalComSucesso() {
	    assertTrue(controller.cadastrarCafeTradicional("Pilão", "Brasil", 3, 10));
	}

	@Test
    void testCadastrarCafeTradicionalDuplicado() {
        controller.cadastrarCafeTradicional("Pilão", "Brasil", 3, 10);
        try {
            controller.cadastrarCafeTradicional("Pilão", "Etiópia", 4, 5);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Elemento ja existe", iae.getMessage());
        }
    }

	@Test
    void testTradicionalIntensidadeInvalidaLimiteSuperior() {
        try {
            controller.cadastrarCafeTradicional("Forte", "Brasil", 6, 10);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	@Test
    void testTradicionalIntensidadeInvalidaLimiteInferior() {
        try {
            controller.cadastrarCafeTradicional("Fraco", "Brasil", 0, 10);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	@Test
	void testCafeTradicionalNomeNulo() {
	    try {
	        controller.cadastrarCafeTradicional(null, "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafeTradicionalNomeVazio() {
	    try {
	        controller.cadastrarCafeTradicional("", "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafeTradicionalOrigemNula() {
	    try {
	        controller.cadastrarCafeTradicional("Forte", null, 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}

	@Test
	void testCafeTradicionalOrigemVazia() {
	    try {
	        controller.cadastrarCafeTradicional("Forte", "", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCadastrarCafeEspecialComSucesso() {
	    assertTrue(controller.cadastrarCafeEspecial("Pilão", "Brasil", 3, 10));
	}

	
	@Test
    void testCadastrarCafeEspecialDuplicado() {
		controller.cadastrarCafeEspecial("Pilão", "Brasil", 3, 10);
        try {
        	controller.cadastrarCafeEspecial("Pilão", "Etiópia", 4, 5);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Elemento ja existe", iae.getMessage());
        }
    }

	@Test
	void testEspecialIntensidadeInvalidaLimiteSuperior() {
	    try {
	        controller.cadastrarCafeEspecial("Forte", "Brasil", 6, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
    void testEspecialIntensidadeInvalidaLimiteInferior() {
        try {
            controller.cadastrarCafeEspecial("Fraco", "Brasil", 0, 10);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	@Test
	void testCafeEspecialNomeNulo() {
	    try {
	        controller.cadastrarCafeEspecial(null, "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafeEspecialNomeVazio() {
	    try {
	        controller.cadastrarCafeEspecial("", "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafeEspecialOrigemNula() {
	    try {
	        controller.cadastrarCafeEspecial("Forte", null, 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}

	@Test
	void testCafeEspecialOrigemVazia() {
	    try {
	        controller.cadastrarCafeEspecial("Forte", "", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	

	@Test
	void testCadastrarCafePremiumComSucesso() {
	    assertTrue(controller.cadastrarCafePremium("Pilão", "Brasil", 3, 10));
	}

	@Test
    void testCadastrarCafePremiumDuplicado() {
		controller.cadastrarCafePremium("Pilão", "Brasil", 3, 10);
        try {
        	controller.cadastrarCafePremium("Pilão", "Etiópia", 4, 5);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Elemento ja existe", iae.getMessage());
        }
    }

	@Test
	void testPremiumIntensidadeInvalidaLimiteSuperior() {
	    try {
	        controller.cadastrarCafePremium("Forte", "Brasil", 6, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
    void testPremiumIntensidadeInvalidaLimiteInferior() {
        try {
            controller.cadastrarCafePremium("Fraco", "Brasil", 0, 10);
            fail("Era esperado lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	@Test
	void testCafePremiumNomeNulo() {
	    try {
	        controller.cadastrarCafePremium(null, "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafePremiumNomeVazio() {
	    try {
	        controller.cadastrarCafePremium("", "Brasil", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testCafePremiumOrigemNula() {
	    try {
	        controller.cadastrarCafePremium("Forte", null, 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}

	@Test
	void testCafePremiumOrigemVazia() {
	    try {
	        controller.cadastrarCafePremium("Forte", "", 3, 10);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testMudaStatusSocio() {
		Socio s = new Socio("socio1", "João");
	    s.setStatus();
	    assertFalse(s.getStatus());
	}
	
	@Test
	void testDegustarComSucesso() {
		controller.cadastrarSocio("socio1", "João");
	    controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 2);
	    assertTrue(controller.degustar("socio1", "Forte", 5, "Excelente café!"));
	}
	
	@Test
    void testDegustarComNotaAcimaDaMargem() {
        controller.cadastrarSocio("socio1", "João");
        controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 2);
        try {
            controller.degustar("socio1", "Forte", 6, "Excelente café!");
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	@Test
    void testDegustarComNotaAbaixoDaMargem() {
        controller.cadastrarSocio("socio1", "João");
        controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 2);
        try {
            controller.degustar("socio1", "Forte", -1, "Excelente café!");
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
    }
	
	
	@Test
	void testDegustarSocioInexistente() {
		controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 2);
        try {
            controller.degustar("socio1", "Forte", 5, "Excelete!");
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
	}
	
	@Test
	void testDegustarCafeInexistente() {
		controller.cadastrarSocio("socio1", "João");
		try {
			controller.degustar("socio1", "Forte", 5, "Excelente café!");
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException iae) {
            assertEquals("Argumentos inválidos", iae.getMessage());
        }
	}
	
	@Test
	void testDegustarSocioInativo() {
		controller.cadastrarSocio("socio1", "João");
		controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 2);
	    controller.mudaStatusSocio("socio1");
	    assertFalse(controller.degustar("socio1", "Forte", 5, "Sócio desativado"));
	}
	
	@Test
	void testBuscarCafeMelhorAvaliado() {
		controller.cadastrarCafeTradicional("Cafe1", "Brasil", 3, 1);
	    controller.cadastrarCafeEspecial("Cafe2", "Colombia", 4, 1);
	    controller.cadastrarCafePremium("Cafe3", "Etiopia", 4, 1);
	    
	    controller.cadastrarSocio("socio1", "Eduardo");
	    
	    controller.degustar("socio1", "Cafe1", 3, "Bom");
	    controller.degustar("socio1", "Cafe2", 4, "Otimo");
	    controller.degustar("socio1", "Cafe3", 5, "Incrível");
	    
	    assertEquals("Cafe3: Etiopia, 4", controller.buscarCafeMelhorAvaliado());
	}
	
	@Test
	void testListarOpinioesRecentesSucesso() {
	    controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 1);
	    controller.cadastrarSocio("socio1", "Eduardo");
	    
	    controller.degustar("socio1", "Forte", 2, "Antiga");
	    controller.degustar("socio1", "Forte", 5, "Nova");
	    
	    String[] resultado = controller.listarOpinioesRecentes("Forte", 2);
	    
	    assertEquals("Cliente: Eduardo. Nota: 5. Comentário: Nova", resultado[0]);
	    assertEquals("Cliente: Eduardo. Nota: 2. Comentário: Antiga", resultado[1]);
	}
	
	@Test
	void testListarOpinioesCafeInexistente() {
	    controller.cadastrarSocio("socio", "Eduardo");
	    try {
	        controller.listarOpinioesRecentes("Invisivel", 1);
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	
	@Test
	void testAdicionarFavoritoSocioInexistente() {
	    controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 1);
	    try {
	        controller.adicionarCafeMeusFavoritos("Forte", "socio1");
	        fail("Era esperado lançar exceção: Argumentos inválidos");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testAdicionarFavoritoCafeInexistente() {
		controller.cadastrarSocio("socio1", "Eduardo");
	    try {
	    	controller.adicionarCafeMeusFavoritos("Forte", "socio1");
	        fail("Era esperado lançar exceção");
	    } catch (IllegalArgumentException iae) {
	        assertEquals("Argumentos inválidos", iae.getMessage());
	    }
	}
	
	@Test
	void testAdicionarFavoritoComSucesso() {
	    controller.cadastrarSocio("socio1", "Eduardo");
	    controller.cadastrarCafeTradicional("Forte", "Brasil", 3, 1);
	    controller.degustar("socio1", "Forte", 5, "Incrível");
	   	assertEquals(true, controller.adicionarCafeMeusFavoritos("Forte", "socio1"));
	}
	
	@Test
	void testListarCafesOrdenados() {
	    controller.cadastrarCafeTradicional("Cafe B", "Brasil", 3, 1);
	    controller.cadastrarCafeTradicional("Cafe A", "Brasil", 3, 1); 
	    controller.cadastrarCafePremium("Cafe P", "Etiopia", 5, 2);  
	    controller.cadastrarSocio("socio1", "Eduardo");
	    controller.degustar("socio1", "Cafe B", 5, "Bom");
	    controller.degustar("socio1", "Cafe A", 5, "Bom");
	    controller.degustar("socio1", "Cafe P", 5, "Excelente");
	    
	    String[] resultado = controller.listarCafes();
	    
	    String[] esperado = {"Cafe P: Etiopia, 5", "Cafe A: Brasil, 3", "Cafe B: Brasil, 3"};

	    assertArrayEquals(esperado, resultado);
	}
	
	@Test
	void testListarSocios() {
	    controller.cadastrarSocio("socio1", "Eduardo");
	    String[] resultado = controller.listarSocios();
	    String[] esperado = {"Eduardo, ativo"};
	    assertArrayEquals(esperado, resultado);
	}
	

}
