package pl.wit.lab2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
/**
 * 
 * @author Michał Walkiewicz
 * Presentation class
 */
public class Presentation {
	protected static final Logger log = LogManager.getLogger(Presentation.class.getName()); //logger 
	//separator to use
	protected static final String SEPARATOR = ".";
	//your name 
	private String firstName=null;
	//your last name
	private String lastName=null;
	//informations about ur birth
	private byte birthdayDay, birthdayMonth, birthdayYear;
	//full year of birth
	private int fullYearOfBirth;
	//where u were born
	private String placeOfBirth;
	//how many friends u have
	private short facebookFriendsQuantity=0;
	//visited places
	private String visitedPlaces[];
	//Actual date
	LocalDate currentDate = null;
	/**
	 * Konstruktor parametryczny
	 * @param firstName
	 * @param lastName
	 */
	public Presentation(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.visitedPlaces=new String[0]; //table of strings
	}
	
	public Presentation(String firstName,String lastName,int birthdayDay,int birthdayMonth,int birthdayYear) throws Exception {
		this(firstName,lastName);
		if(birthdayDay<=31 && birthdayMonth<=12 && birthdayYear<=99 && birthdayDay>0 && birthdayMonth>0 && birthdayYear>=0) {
		this.birthdayDay=(byte)birthdayDay;
		this.currentDate=LocalDate.now();
		this.birthdayMonth=(byte)birthdayMonth;
		this.birthdayYear=(byte)birthdayYear;
		this.fullYearOfBirth=this.birthdayYear<(currentDate.getYear()-2000)?2000+this.birthdayYear:1900+this.birthdayYear;
		}else {
			throw new Exception("Date items are incorect");
		}
	}
	
	public String getFullName() {
		//Full name with space separator
		return (firstName!=null ? firstName:"")+" "+(lastName!=null ? lastName:"");
	}
	
	public String getBirthdayDateAsString() {
		//Year in position like dd.MM.yy
		String day=(birthdayDay<10?"0":"")+String.valueOf(birthdayDay);
		String month=(birthdayMonth<10?"0":"")+String.valueOf(birthdayMonth);
		String year=String.valueOf(fullYearOfBirth);
		return day+SEPARATOR+month+SEPARATOR+year;
	}
	
	public byte getAge() {
		//LocalDate now = LocalDate.now();  
		//now.getYear();
		//Actual age
		LocalDate birthDate = LocalDate.of(fullYearOfBirth, birthdayMonth, birthdayDay);
		if ((birthDate != null) && (currentDate != null)) {
            return (byte)Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }	
	}
	
	public String getPresentationStory() {
		StringBuilder story = new StringBuilder("***PRESENTATION:***\n");
		prepareNameAndSurnameData(story);
		prepareBirthdayData(story);
		prepareAgeData(story);
		prepareVisitedPlaces(story);
		prepareFbFriendsData(story);
		
		return story.toString();
	}
	
	/**
	 * Presentation
	 * @param story
	 */
	private void prepareNameAndSurnameData(StringBuilder story) {
		story.append("Hello I'm ").append(getFullName()).append(".\n");
	}
	
	/**
	 * Date and where u were born
	 * @param story
	 */
	private void prepareBirthdayData(StringBuilder story) {
		story.append("I was born ").append(getBirthdayDateAsString());
		if(getPlaceOfBirth()!=null)
			story.append(" in town ").append(getPlaceOfBirth()).append(".\n");
		else
			story.append(".\n");
	}
	
	/**
	 * Information about age
	 * @param story
	 */
	private void prepareAgeData(StringBuilder story) {
		story.append("I'm ").append(getAge()).append(" Years old.\n");
	}
	
	/**
	 * Places where u were
	 * @param story
	 */
	private void prepareVisitedPlaces(StringBuilder story) {
		if(visitedPlaces.length==0) {
			story.append("I'm not traveling currently ");
		}else if(visitedPlaces.length<5) {
			story.append("I'm not traveling too much. ");
		}else if(visitedPlaces.length<=10) {
			story.append("I travel some. ");
		}else {
			story.append("I travel a lot. ");
			
		}
		if (visitedPlaces.length != 0) {
			story.append("I was in:");
			int i = 1;
			for (String place : visitedPlaces) {
				story.append(place);
				if (i < visitedPlaces.length)
					story.append(",");
				else
					story.append(".");
				i++;
			}
		}
		story.append("\n");
	}
	
	/**
	 * Count fb friends
	 * @param story
	 */
	private void prepareFbFriendsData(StringBuilder story) {
		if(facebookFriendsQuantity==0) {
			story.append("I dont have friends on FB. ");
		}else if(facebookFriendsQuantity<10) {
			story.append("I dont have many FB friends. ");
		}else if(facebookFriendsQuantity<50) {
			story.append("I have some FB friends. ");
		}else if(facebookFriendsQuantity<200) {
			story.append("I've a lot of friends on FB. ");
		}
		else
			story.append("I'm so popular on FB. ");
		story.append("\n");
	}
	
	/**
	 * Add new visited place
	 * @param visitedPlace
	 */
	public  void addVisitedPlaces(String visitedPlace) {
		visitedPlaces = Arrays.copyOf(visitedPlaces, visitedPlaces.length+1);
		visitedPlaces[visitedPlaces.length-1]=visitedPlace;
	}
	////////////////////////////////////////////
	// getters and setters
	////////////////////////////////////////////
	public void setFacebookFriendsQuantity(short facebookFriendsQuantity) {
		this.facebookFriendsQuantity = facebookFriendsQuantity;
	}
	
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public void setBirthdayDay(byte birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public void setBirthdayMonth(byte birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	public void setBirthdayYear(byte birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public String[] getVisitedPlaces() {
		return visitedPlaces;
	}

	public short getFacebookFriendsQuantity() {
		return facebookFriendsQuantity;
	}
}