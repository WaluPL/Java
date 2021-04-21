package pl.wit.lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Klasa testów jednostkowych dla klasy Point
 * 
 * @author Michał Walkiewicz
 *
 */
public class PointTest {

	private float x = 2.13f;
	private float y = 3.45f;

	@Before
	public void setUp() throws Exception {
		this.x = 2.13f;
		this.y = 3.45f;
	}

	/**
	 * Test sprawdzający poprawność tworzenia obiektu oraz inicjalizacji obiektu
	 */
	@Test
	public void createObjectTest() {

		Point pt = null;
		pt = new Point(x, y);
		// sprawdzenie czy powiodło sie tworzenie obiektu
		assertNotNull(pt);
		// sprawdzenie poprawności zainicjowania zmiennej x w konstruktorze
		assertEquals(x, pt.getX(), 0.0);
		// sprawdzenie poprawności zainicjowania zmiennej y w konstruktorze
		assertEquals(y, pt.getY(), 0.0);
	}
	/**
	 * Test sprawdzający poprawność przesuwania punktu na osi X i osi Y
	 */
	@Test
	public void shiftPointTest() {
		Point pt = new Point(x, y);
		float shift = 0.5f;
		// przesuniecie na osi x
		pt.ShiftX(shift);
		// sprawdzenie poprawności operacji przesunięcia
		assertEquals(this.x + shift, pt.getX(), 0.0f);
		// sprawdzenie niezmienności drugiej zmiennej
		assertEquals(this.y, pt.getY(), 0.0f);
		// Przesunięcie na osi Y
		pt.ShiftY(shift);
		// sprawdzenie poprawności działania przesunięcia Y
		assertEquals(this.y + shift, pt.getY(), 0.0f);
		// sprawdzenie niezmiennosci drugiej zmiennej
		assertEquals(this.x + shift, pt.getX(), 0.0f);
	}

	/**
	 * Test sprawdzający poprawność dodawania i odejmowanie 2 punktów
	 */
	@Test
	public void addandSubstractNewPoint() {
		Point pt = new Point(x,y);
		Point pt2 = new Point(4.0f,5.5f);
		//Dodaeanie pt2 do pt
		pt.add(pt2);
		//sprawdzenie poprwnosci działania dla X
		assertEquals(this.x+pt2.getX(),pt.getX(),0.00001f);
		//sprawdzenie poprwnosci działania dla Y
		assertEquals(this.y+pt2.getY(),pt.getY(),0.00001f);
		//odejmowanie pt2 od pt
		pt.substract(pt2);
		//sprawdzenie poprawnosci dzialan dla X w penym przyblizeniu
		assertEquals(this.x,pt.getX(),0.00001f);
		//sprawdzenie poprawnosci dzialan dla Y w penym przyblizeniu
		assertEquals(this.y,pt.getY(),0.00001f);
	}
	/**
	 * Test sprawdzający poprawność tworzenia nowego obiektu po dodaniu 2 punktów
	 */
	@Test
	public void addAndCreateNewPointTest() {
		Point pt = new Point(x,y);
		Point pt2 = new Point(1.5f,2.6f);
		Point pt3 = null;
		
		pt3 = pt.addPointAndReturnNew(pt2);
		//Sprawdzenie czy utworzony został obiekt 
		assertNotNull(pt3);
		//sprawdzenie poprawnosci inicjalizacji obietu pt dla x
		assertEquals(this.x,pt.getX(),0.00001f);
		//sprawdzenie pprawnosci inicjalizacji obietu pt dla y
		assertEquals(this.y,pt.getY(),0.00001f);
		//sprawdzenie czy zmienne nie wskazuja na ten sam obiekt
		assertNotSame(pt, pt3);
		//sprwdzenie poprawnosci obliczen wykonanaych dla nowego obniektu pt3 dla x
		assertEquals(this.x+pt2.getX(),pt3.getX(),0.00001f);
		//sprwdzenie poprawnosci obliczen wykonanaych dla nowego obniektu pt3 dla y
		assertEquals(this.y+pt2.getY(),pt3.getY(),0.00001f);
	}
	
}