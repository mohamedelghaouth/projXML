package bo;

import java.util.ArrayList;
import java.util.List;

public class Block {

	private String nom;
	private List<etage>l=new ArrayList<etage>();
	

	public List<etage> getL() {
		return l;
	}
	public void setL(List<etage> l) {
		this.l = l;
	}
	

	public Block(String num, List<etage> l) {
		this.nom = num;
		this.l = l;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String num) {
		this.nom = num;
	}
	public Block() {
	}
	
	
	
}
