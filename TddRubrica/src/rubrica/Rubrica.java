package rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rubrica {
	private String nome;
	
	private Map<String,Voce> voci=new TreeMap<String,Voce>();
	

	public Rubrica(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String,Voce> getVoci() {
	
		return voci;
	}

	public Voce aggiungiVoce(String nome, String cognome, String tel) throws VoceGiaEsiste {
		
		
		if(voci.containsKey(nome+" "+cognome)){
			throw new VoceGiaEsiste("");
		}
		Voce v=new Voce(nome,cognome,tel);
		
		voci.put(nome+" "+cognome, v);
		
		return v;
	}

	public Voce getVoce(String nome, String cognome) throws VoceNonEsiste {
		
		if(!voci.containsKey(nome+" "+cognome)){
			throw new VoceNonEsiste();
		}	
		
		Voce v=voci.get(nome+" "+cognome);
	
		return v;
	}

	public List<Voce> getTutteVoci() {
		List<Voce> tutte = new ArrayList<Voce>(); 
		tutte.addAll(voci.values());		
		return tutte;
	}

	public Voce aggiornaVoce(String nomeVecchio, String cognomeVecchio, String nomeNuovo,
			String cognomeNuovo, String telefono) throws VoceNonEsiste {
		if(!voci.containsKey(nomeVecchio+" "+cognomeVecchio)){
			throw new VoceNonEsiste();
		}
		Voce v = voci.remove(nomeVecchio+" "+cognomeVecchio);
		v.setNome(nomeNuovo);
		v.setCognome(cognomeNuovo);
		v.setTel(telefono);
		voci.put(nomeNuovo+" "+cognomeNuovo, v);
		return v;
	}
}
