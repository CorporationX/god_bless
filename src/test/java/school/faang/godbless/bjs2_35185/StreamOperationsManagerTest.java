package school.faang.godbless.bjs2_35185;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamOperationsManagerTest {

    @ParameterizedTest
    @MethodSource("getTestCasesForGetPairsThatSumUpToTarget")
    void getPairsThatSumUpToTarget(List<StreamOperationsManager.Pair<Integer>> expected, List<Integer> numbers, int target) {
        expected = sortPairs(expected);
        List<StreamOperationsManager.Pair<Integer>> actual = sortPairs(StreamOperationsManager.getPairsThatSumUpToTarget(numbers, target));
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    static Stream<Arguments> getTestCasesForGetPairsThatSumUpToTarget() {
        return Stream.of(
                Arguments.of(List.of(new StreamOperationsManager.Pair<>(0, 12), new StreamOperationsManager.Pair<>(2, 10)),
                        List.of(0, 2, 10, 12, 0, 5), 12),
                Arguments.of(List.of(new StreamOperationsManager.Pair<>(0, 2), new StreamOperationsManager.Pair<>(-3, 5)),
                        List.of(0, 2, 10, 12, 0, 5, -3), 2),
                Arguments.of(List.of(),
                        List.of(0, 2, 10, 12, 0, 5, -3), 8)
        );
    }

    private List<StreamOperationsManager.Pair<Integer>> sortPairs(List<StreamOperationsManager.Pair<Integer>> pairs) {
        return pairs.stream().sorted((a, b) -> {
            if (Objects.equals(a.getFirstObject(), b.getFirstObject())) {
                return a.getSecondObject() - b.getSecondObject();
            }
            return a.getFirstObject() - b.getFirstObject();
        }).toList();
    }
}