package school.faang.task_47241;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class SteamApi2Testing {

	public static Set<List<Integer>> uniquePairsNumbers( List<Integer> numbers,int targetSum){
		Set<Integer> set = new HashSet<>(numbers);
		return	numbers.stream()
				.filter(num ->set.contains(targetSum-num))
				.map(num -> Arrays.asList(num,targetSum-num))
				.peek(Collections::sort)
				.collect(Collectors.toSet());

	}

	public static List<String> sortedCapitals( Map<String, String> countries){
			return countries.entrySet().stream()
					.sorted(Map.Entry.comparingByKey())
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
		}
};



