 package rubrica;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRubrica {
	
	static Rubrica r;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r=new Rubrica("vahid");
	}

	@Test
	public void testCreazioneRubrica(){	
		assertNotNull(r);
	}
	
	@Test
	public void testCollezioneRubrica(){
		Map<String,Voce> voci=r.getVoci();
		 assertNotNull(voci);	
	}
	
	@Test
	public void testAggiungiVoce() throws VoceGiaEsiste{
		Voce v=r.aggiungiVoce("AAA","BBB","1111111111");
		assertNotNull(v);
		Map<String ,Voce> voci =r.getVoci();
		assertEquals(1, voci.size());
	}
	
	@Test
	public void testAggiungiVoce2(){
		try{
			Voce v=r.aggiungiVoce("AAA","BBB","1111111111");
			Voce v1=r.aggiungiVoce("AAA","BBB","1111111111");
			fail("aspettavo che lanciava l' eccezione ");
		}catch(VoceGiaEsiste e){
			System.out.println(e.getMessage());
		}
	}
		
	@Test 
	public void testGetVoce() throws VoceGiaEsiste, VoceNonEsiste{
		Rubrica r2=new Rubrica("aaaa");
		Voce v=r2.aggiungiVoce("hhh","ggg","1111111111");		
		Voce voceTornata = r2.getVoce("hhh","ggg");	
		assertEquals(v, voceTornata);
	}
  	
	@Test 
	public void testGetVoce2() {
		Rubrica r2=new Rubrica("aaaa");
		try {
			Voce voceTornata= r2.getVoce("zzzz","zzzzzz");
			fail("non ha laciato ");
		} catch (VoceNonEsiste e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTutteVoci() throws VoceGiaEsiste{
		Rubrica r2=new Rubrica("aaaa");
		Voce v =r2.aggiungiVoce("hhh","ggg","1111111111");	
		Voce v2 =r2.aggiungiVoce("bbb","aaa","1111111111");	
		List<Voce> tutte = r.getTutteVoci();
		assertNotNull(tutte);
	}
	
	@Test
	public void testAggiornaVoce() throws VoceGiaEsiste, VoceNonEsiste{
		Rubrica r2=new Rubrica("aaaa");
		try{
			Voce v2 = r2.aggiornaVoce("aaa", "bbb", "hhh", "kkk", "1111111111");
			fail("Mi aspettavo l-eccezione!");
		}catch(VoceNonEsiste e){
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testAggiornaVoce2() throws VoceGiaEsiste, VoceNonEsiste{
		Rubrica r2=new Rubrica("aaaa");
		Voce v =r2.aggiungiVoce("bbb","aaa","1111111111");
		String nome = v.getNome();
		String cognome = v.getCognome();		
		Voce v2 = r2.aggiornaVoce("bbb", "aaa", "hhh", "kkkk", "22222222");
		assertNotEquals(nome, v2.getNome());
		assertNotEquals(cognome, v2.getCognome());
	}
}
