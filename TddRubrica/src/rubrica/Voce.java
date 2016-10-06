package rubrica;

public class Voce {
	
	private String nome;
	private String cognome;
	private String tel;
	
	
public Voce() {
		
	} 

	public Voce(String nome, String cognome, String tel) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.tel = tel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	} 
	
	
	
	
	
}
