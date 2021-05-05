package pl.wit.lab2;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PresentationTest {
protected static final Logger log = LogManager.getLogger(PresentationTest.class.getName());
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	/**
	 * Default configuration and logger
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}
	
	/**
	 * First configuration test = working
	 */
	@Test
	public void presentatonOK1Test() {
		Presentation pd = null;
		try {
			 pd = new Presentation("Jan","Kowalski",6,11,92);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertNotNull(pd);
		pd.setFacebookFriendsQuantity((short)67);
		pd.setPlaceOfBirth("Warszawa");
		for(int i=0;i<20;i++)
			pd.addVisitedPlaces("city"+(i+1));
		
		System.out.print(pd.getPresentationStory());
		assertEquals("Warszawa",pd.getPlaceOfBirth());
		assertEquals("Jan Kowalski",pd.getFullName());
		assertEquals("06.11.1992",pd.getBirthdayDateAsString());
	}

	/**
	 * Second configuration test = working
	 */
	@Test
	public void presentatonOK2Test() {
		Presentation pd = null;
		try {
			pd = new Presentation("Jan","Kowalski2",6,11,12);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		pd.setFacebookFriendsQuantity((short)10);
	
		for(int i=0;i<8;i++)
			pd.addVisitedPlaces("city"+(i+1));
		
		System.out.print(pd.getPresentationStory());
		assertEquals(10,pd.getFacebookFriendsQuantity());
		assertEquals("06.11.2012",pd.getBirthdayDateAsString());
	}
	
	/**
	 * Third configuration test = working
	 */
	@Test
	public void presentatonOK3Test() {
		Presentation pd = null;
		try {
			pd = new Presentation("Jan","Kowalski3",30,5,19);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		pd.setFacebookFriendsQuantity((short)100);
	
		for(int i=0;i<80;i++)
			pd.addVisitedPlaces("city"+(i+1));
		
		System.out.print(pd.getPresentationStory());
		assertNotNull(pd.getVisitedPlaces());
		assertEquals(80, pd.getVisitedPlaces().length);
	}
	
	/**
	 * Fourth configuration test = working
	 */
	@Test(expected = Exception.class)
	public void presentatonWrong1Test() throws Exception {
		@SuppressWarnings("unused")
		Presentation pd = null;
		//exception!!
		pd = new Presentation("Jan","Kowalski4",30,5,1999);
	
	}
	
	/**
	 * Fifth configuration test = working
	 */
	@Test
	public void presentatonWrong2Test() throws Exception {
		@SuppressWarnings("unused")
		Presentation pd = null;
		exceptionRule.expect(Exception.class);
	    exceptionRule.expectMessage("Date items are incorect");
		//exception!!
		pd = new Presentation("Jan","Kowalski4",30,5,1999);
	}
	
}