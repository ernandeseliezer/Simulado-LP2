package coffee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Lembrem que não se instancia classe abstrata, então usei uma das classes que extendem Café pra testar os métodos

class CafeTest { 
	
	private Cafe cafe;

	@BeforeEach
	void setUp() throws Exception {
		cafe = new CafeTradicional("Pilão", "Brasil", 3, 2);
	}

	@Test
    void testGetNome() {
        assertEquals("Pilão", cafe.getNome());
    }

    @Test
    void testToString() {
        assertEquals("Pilão: Brasil, 3", cafe.toString());
    }

    @Test
    void testMediaComUmaOpiniao() {
        cafe.adicionaOpiniao("Eduardo", 5, "Excelente");
        assertEquals(5.0, cafe.media());
    }
    
    @Test
    void testMediaComVariasOpinioes() {
        cafe.adicionaOpiniao("Eduardo", 5, "Excelente");
        cafe.adicionaOpiniao("Ana", 3, "Regular");
        assertEquals(4.0, cafe.media());
    }
    
    @Test
    void testGetOpinioesRecentes() {
        cafe.adicionaOpiniao("Eduardo", 2, "Ruim");
        cafe.adicionaOpiniao("Ana", 5, "Ótimo");
        
        String[] opinioes = cafe.getOpinioes(2);
        
        assertEquals("Cliente: Ana. Nota: 5. Comentário: Ótimo", opinioes[0]);
        assertEquals("Cliente: Eduardo. Nota: 2. Comentário: Ruim", opinioes[1]);
    }
    
    @Test
    void testEqualsMesmoNome() {
        Cafe outroCafe = new CafeTradicional("Pilão", "Etiópia", 5, 1);
        assertTrue(cafe.equals(outroCafe));
    }

    @Test
    void testEqualsNomesDiferentes() {
        Cafe outroCafe = new CafeTradicional("Melitta", "Brasil", 3, 2);
        assertFalse(cafe.equals(outroCafe));
    }

}
