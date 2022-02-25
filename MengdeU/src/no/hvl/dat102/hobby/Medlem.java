package no.hvl.dat102.hobby;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	private String namn;
	private MengdeADT<Hobby> hobbyer;
	private int status = -1;
	
	public Medlem(String namn, MengdeADT<Hobby> hobbyer) {
		super();
		this.namn = namn;
		this.hobbyer = hobbyer;
		status = -1;
	}
	
	public Medlem(String namn, MengdeADT<Hobby> hobbyer, int status) {
		super();
		this.namn = namn;
		this.hobbyer = hobbyer;
		this.status = status;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Medlem [namn=" + namn + ", hobbyer=" + hobbyer + (status == -1 ? ", Har ingen match" : ", Har match") + "]";
	}
	
	
}
