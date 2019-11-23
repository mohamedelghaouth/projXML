package bo;

import java.util.ArrayList;
import java.util.List;

public class etage {
	
	private int num;
	private List<Sale>l=new ArrayList<Sale>();
	

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Sale> getL() {
		return l;
	}
	public void setL(List<Sale> l) {
		this.l = l;
	}

	public etage(int num, List<Sale> l) {
		this.num = num;
		this.l = l;
	}
	public etage() {
	}

	

}
