package school.faang.bjs2_80777;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationStreams {

    public static List<String> findPeopleWithCommonFriends(Map<String, List<String>> network) {
        List<String> people = new ArrayList<>(network.keySet());

        return IntStream.range(0, people.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, people.size())
                        .mapToObj(j -> {
                            String person1 = people.get(i);
                            String person2 = people.get(j);
                            List<String> friends1 = network.getOrDefault(person1, List.of());
                            List<String> friends2 = network.getOrDefault(person2, List.of());

                            boolean notDirectFriends = !friends1.contains(person2) && !friends2.contains(person1);
                            boolean hasCommonFriend = friends1.stream().anyMatch(friends2::contains);

                            if (notDirectFriends && hasCommonFriend) {
                                return Optional.of("(" + person1 + ", " + person2 + ")");
                            } else {
                                return Optional.<String>empty();
                            }
                        }))
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    String str = Integer.toString(number);
                    return str.equals(new StringBuilder(str).reverse().toString());
                })
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> findPalindromicSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, input.length())
                        .mapToObj(end -> input.substring(start, end)))
                .filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> num > 0 && IntStream.rangeClosed(1, num / 2)
                                                  .filter(d -> num % d == 0).sum() == num)
                .boxed()
                .collect(Collectors.toList());
    }
}