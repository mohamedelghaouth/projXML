package bo;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	
	private int num;
	private int capp;
	private List<hoccp>l=new ArrayList<hoccp>();
	

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCapp() {
		return capp;
	}
	public void setCapp(int capp) {
		this.capp = capp;
	}
	public List<hoccp> getL() {
		return l;
	}
	public void setL(List<hoccp> l) {
		this.l = l;
	}
	

	public Sale(int num, int capp, List<hoccp> l) {
		this.num = num;
		this.capp = capp;
		this.l = l;
	}
	public Sale() {
	}
	
}
