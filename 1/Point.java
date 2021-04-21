package pl.wit.lab1;
/**
 * Klasa Point
 * @author Michał Walkiewicz
 *
 */
public class Point {
private float x;
private float y;

/**
 * Konstruktor parametryczny 2 argumentowy
 * @param x - inicjalizacja wartosci na osi x
 * @param y - inicjalizacja wartosci na osi y
 */
public Point(float x, float y) {
	this.x=x;
	this.y=y;
}
/**
 * Metoda przesuwająca parametr x o shift
 * @param shift - wartosc przesuniecia
 */
public void ShiftX(float shift) {
	this.x=this.x+shift;
}
/**
 * Metoda przesuwająca parametr y o shift
 * @param shift - wartosc przesuniecia y-ka
 */
public void ShiftY(float shift) {
	this.y=this.y+shift;
}
/**
 * Metoda dodająca do siebie aktualny punkt oraz przekazany w argumencie
 * @param pt
 */
public void add(Point pt) {
if(pt!=null) {
ShiftX(pt.getX());
ShiftY(pt.getY());
}
}
/**
 * Metoda odejmująca od siebie dwa punkty
 * @param pt
 */
public void substract(Point pt) {
	if(pt!=null) {
		ShiftX(-1*pt.getX());
		ShiftY(-1*pt.getY());		
	}
}
/**
 * Dodaje punkt do obecnego ale zwraca nowy obiekt wynikowy
 * @param pt
 * @return
 */
public Point addPointAndReturnNew(Point pt) {
Point pt2 = new Point(this.getX(),this.getY());
if(pt!=null) {
	pt2.add(pt2);
}
return pt2;
}
//gettery do xa i ya
public float getX() {
	return x;
}
public float getY() {
	return y;
}
}



