package no.hvl.dat102.hobby;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class MedlemKlient {
	
	public static void main(String[] args) {
		MengdeADT<Hobby> h = new KjedetMengde<Hobby>();
		h.leggTil(new Hobby("Programmering"));
		h.leggTil(new Hobby("Tur"));
		Medlem m = new Medlem("Bjøn-Sigurd", null);
		
		printMedlem(m);
	}
	
	public static void printMedlem(Medlem medlem) {
		System.out.println(medlem.toString());
	}
}
