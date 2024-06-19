package faang.school.godbless.BJS210900;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamMethodsTest {
    @Test
    void testGetPairsWithSumOf() {
        List<Integer> nums = List.of(5, 5, 5, 6, 6, 6, 4, 4, 4, 1, 9, 8, 2, 3, 8, 2, 20, -10);
        Set<List<Integer>> expected = Set.of(
                List.of(5, 5), List.of(4,6), List.of(1, 9), List.of(2, 8), List.of(-10, 20)
        );

        assertEquals(expected, StreamMethods.getPairsWithSumOf(nums, 10));
    }

    @Test
    void testSortCapitals() {
        Map<String, String> input = new HashMap<>();
        input.put("Russia", "Moscow");
        input.put("Argentina", "Buenos-Aires");
        input.put("Belarus", "Minsk");
        List<String> expected = List.of("Buenos-Aires", "Minsk", "Moscow");

        assertEquals(expected, StreamMethods.sortCapitals(input));
    }

    @Test
    void testSortFilteredStrings() {
        List<String> input = List.of("Russia", "Moscow", "Argentina", "Buenos-Aires", "Belarus", "Minsk");
        List<String> expected = List.of("Minsk", "Moscow");

        assertEquals(expected, StreamMethods.sortFilteredStrings(input, 'M'));
    }

    @Test
    void testFindStrangersWithCommonFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Vasya", List.of("Petya", "Grisha"));
        friends.put("Tanya", List.of("Petya", "Grisha"));
        Set<Set<String>> actual = StreamMethods.findStrangersWithCommonFriends(friends);

        Set<Set<String>> expected = Set.of(Set.of("Petya", "Grisha"), Set.of("Tanya", "Vasya"));


        assertEquals(expected, StreamMethods.findStrangersWithCommonFriends(friends));
    }
}
