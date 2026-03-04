package coffee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SocioTest {
	
	private Socio socio;
    private Cafe cafe;

	@BeforeEach
	void setUp() throws Exception {
		socio = new Socio("S01", "Eduardo");
        cafe = new CafeTradicional("Forte", "Brasil", 3, 2);
	}

	@Test
    void testSetStatusToggle() {
        socio.setStatus();
        assertFalse(socio.getStatus());
	}
	
	@Test
    void testToStringAtivo() {
        assertEquals("Eduardo, ativo", socio.toString());
    }

    @Test
    void testToStringInativo() {
        socio.setStatus();
        assertEquals("Eduardo, inativo", socio.toString());
    }
    
    @Test
    void testAddFavoritoSemDegustar() {
        assertFalse(socio.addFavoritos(cafe));
    }

    @Test
    void testAddFavoritoComDegustacaoPrevia() {
        socio.addDegustacao(cafe);
        assertTrue(socio.addFavoritos(cafe));
    }
    
    @Test
    void testEqualsMesmoCodigo() {
        Socio outroSocio = new Socio("S01", "Outro Nome");
        assertTrue(socio.equals(outroSocio));
    }

    @Test
    void testEqualsCodigosDiferentes() {
        Socio outroSocio = new Socio("S02", "Eduardo");
        assertFalse(socio.equals(outroSocio));
    }
}
