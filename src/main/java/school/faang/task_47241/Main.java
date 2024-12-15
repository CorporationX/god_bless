package school.faang.task_47241;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) throws JsonProcessingException {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		String jsonString = "{\"Russia\": \"Moscow\", \"USA\": \"Washington\", \"Germany\": \"Berlin\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> countryCapitalMap = objectMapper.readValue(jsonString, HashMap.class);

        System.out.println(SteamApi2Testing.uniquePairsNumbers(numbers,7));
        System.out.println(SteamApi2Testing.sortedCapitals((HashMap<String, String>) countryCapitalMap));
	}
}
