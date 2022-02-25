package no.hvl.dat102.mengde.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class MengdeADTTest {
	
	MengdeADT<Integer> m1, m2;
	
	@Before
	public void Setup() {
		m1 = getTomMengde();
		m2 = getTomMengde();
	}
	
	@Test
	public void union() {
		m1.leggTil(0);
		m1.leggTil(1);
		m1.leggTil(2);
		m2.leggTil(1);
		m2.leggTil(2);
		m2.leggTil(3);
		m2.leggTil(4);
		
		MengdeADT<Integer> union = m1.union(m2);
		
		// er lengde riktig
		assertEquals(5, union.antall());
		
		// Er innholdet riktig
		assertTrue(union.inneholder(0));
		assertTrue(union.inneholder(1));
		assertTrue(union.inneholder(2));
		assertTrue(union.inneholder(3));
		assertTrue(union.inneholder(4));
	}
	
	@Test
	public void snittIngenFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(2);
		m2.leggTil(3);
		
		MengdeADT<Integer> snitt = m1.snitt(m2);
		
		// Riktig lengde
		assertEquals(0, snitt.antall());
		
		// Inneholder ingen av elementa
		assertFalse(snitt.inneholder(0));
		assertFalse(snitt.inneholder(1));
		assertFalse(snitt.inneholder(2));
		assertFalse(snitt.inneholder(3));
	}
	
	@Test
	public void snittNoenFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(1);
		m2.leggTil(2);
		
		MengdeADT<Integer> snitt = m1.snitt(m2);
		
		// Riktig lengde
		assertEquals(1, snitt.antall());
		
		// Riktig innhold
		assertFalse(snitt.inneholder(0));
		assertTrue(snitt.inneholder(1));
		assertFalse(snitt.inneholder(2));
	}
	
	@Test
	public void snittBareFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(0);
		m2.leggTil(1);
		
		MengdeADT<Integer> snitt = m1.snitt(m2);
		
		// Riktig lengde
		assertEquals(2, snitt.antall());
		
		// Riktig innhold
		assertTrue(snitt.inneholder(0));
		assertTrue(snitt.inneholder(1));
	}
	
	@Test
	public void differansIngenFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(2);
		m2.leggTil(3);
		
		MengdeADT<Integer> diff = m1.differens(m2);
		
		assertEquals(2, diff.antall());
		assertTrue(diff.inneholder(0));
		assertTrue(diff.inneholder(1));
		assertFalse(diff.inneholder(2));
		assertFalse(diff.inneholder(3));
	}
	
	@Test
	public void differansNokonFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(1);
		m2.leggTil(2);
		
		MengdeADT<Integer> diff = m1.differens(m2);
		
		assertEquals(1, diff.antall());
		
		assertTrue(diff.inneholder(0));
		assertFalse(diff.inneholder(1));
		assertFalse(diff.inneholder(2));
		assertFalse(diff.inneholder(3));
	}
	
	@Test
	public void differansAlleFelles() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(0);
		m2.leggTil(1);
		
		MengdeADT<Integer> diff = m1.differens(m2);
		
		assertEquals(0, diff.antall());
		
		assertFalse(diff.inneholder(0));
		assertFalse(diff.inneholder(1));
		assertFalse(diff.inneholder(2));
		assertFalse(diff.inneholder(3));
	}
	
	@Test
	public void undermengdeLik() {
		m1.leggTil(0);
		m1.leggTil(1);
		m2.leggTil(0);
		m2.leggTil(1);
		
		assertTrue(m1.undermengde(m2));
	}
	
	@Test
	public void undermengdeEkteDelmengde() {
		m1.leggTil(0);
		m2.leggTil(0);
		m2.leggTil(1);
		
		assertTrue(m1.undermengde(m2));
	}
	
	@Test
	public void undermengdeTom() {
		m2.leggTil(0);
		m2.leggTil(1);
		
		assertTrue(m1.undermengde(m2));
	}
	
	@Test
	public void undermengdeTomAvTom() {		
		assertTrue(m1.undermengde(m2));
	}
	
	protected abstract MengdeADT<Integer> getTomMengde();
}
