package school.faang.bjs2_72053;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Operations {

    public List<List<Integer>> uniquePairs(Set<Integer> numbers, int number) {
        List<Integer> sorted = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .sorted(((a, b) -> number - a - b))
                .toList();
        System.out.println(sorted);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i) + sorted.get(i + 1) == number) {
                result.add(List.of(sorted.get(i), sorted.get(i + 1)));
            }
        }
        return result;
    }

    public List<String> capitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(comparingInt(a -> a.getKey().charAt(0)))
                .collect(ArrayList::new,
                        (list, entrySet) -> list.add(entrySet.getValue()),
                        (list, endList) -> endList.addAll(list));
    }

    public List<String> stringSort(List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(firstLetter)))
                .sorted().toList();
    }

    public List<String> toBinary(List<Integer> numbers) {
        return numbers.stream().map(this::binary).toList();
    }

    private String binary(int a) {
        StringBuilder binary = new StringBuilder();
        while (a > 0) {
            binary.append(a % 2);
            a /= 2;
        }
        return binary.reverse().toString();
    }

    public List<String> sortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream().filter(s -> {
            for (int code : s.chars().toArray()) {
                if (!alphabet.contains(Character.toString(code))) {
                    return false;
                }
            }
            return true;
        }).toList();
    }
}
