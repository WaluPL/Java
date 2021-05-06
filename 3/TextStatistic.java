package pl.wit.lab2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Michał Walkiewicz
 *
 */
public class TextStatistic {
	//Stała separatora Reg-exp
	private final String SEPARATOR="[ ,.:;!()\\r\\n-?]+";
	//tablica wyrazów
	private String words[] = null;
	//Mapa słowo->iczba
	private Map<String,Integer> mapWordsCount = null;
	/**
	 * Konstruktor parametryczny
	 * @param sentence
	 */
	public TextStatistic(String sentence) {
		if(sentence!=null)
			this.words = sentence.trim().split(SEPARATOR);
		
		mapWordsCount = new HashMap<String,Integer>();
		//Parsowanie
		if(words!=null)
		{
			int count=0;
			for(String word:words) {
				count = (mapWordsCount.containsKey(word))?mapWordsCount.get(word):0;
				mapWordsCount.put(word,++count);
			}
		}
	}
	
	public int getWordsCount() {
		if(words!=null)
			return words.length;
		else
			return 0;
	}
	
	public boolean containsWord(String word) {
		return mapWordsCount.containsKey(word);
	}
	
	/**
	 * Pobiera statystykę jako łańcuch
	 * @return
	 */
	public String getTextStatisticsInfo() {
		if(mapWordsCount.size()==0)
			return "";
		
		StringBuilder stStats = new StringBuilder();
		Set<String> keys = mapWordsCount.keySet();
		String uniqueWords[] = new String[keys.size()];
		keys.toArray(uniqueWords);
		Arrays.sort(uniqueWords);
		for(String word:uniqueWords) {
			stStats.append(word).append("=").append(mapWordsCount.get(word)).append("\n");
		}
		return stStats.toString();
	}
	
}
