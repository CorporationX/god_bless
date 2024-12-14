package school.faang.streamapi3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTester {
    public static Set<List<String>> getJointFriends(Map<String, List<String>> friendMap) {

        return friendMap.values().stream()
                .filter(friendList -> {
                    boolean isFriends = false;
                    for (String friend : friendList) {
                        for (String otherFriend : friendMap.get(friend)) {
                            if (friendList.contains(otherFriend)) {
                                isFriends = true;
                                break;
                            }
                        }
                        if (isFriends) {
                            break;
                        }
                    }
                    return !isFriends;
                })
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                .entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().stream()
                                            .collect(Collectors.averagingDouble(Employee::getSalary))
                        )
                );
    }

    public static List<Integer> getPalindromes(int left, int right) {
        return IntStream.range(left, right)
                .filter(i -> isPalindrome(String.valueOf(i)))
                .boxed()
                .toList();
    }

    public static List<String> getSubstringPalindromes(String string) {

        List<String> result = new ArrayList<>();
        List<String> stringArray = string.chars()
                .boxed()
                .collect(
                        ArrayList::new,
                        (list, item) -> list.add(String.valueOf((char) item.intValue())),
                        ArrayList::addAll
                );

        for (int i = 0; i < stringArray.size(); i++) {
            StringBuilder builder = new StringBuilder(stringArray.get(i));
            for (int j = i; j < stringArray.size(); j++) {
                if (i != j) {
                    builder.append(stringArray.get(j));
                }

                if(isPalindrome(builder.toString())) {
                    result.add(builder.toString());
                }
            }
        }
        return result;
    }

    public static List<Integer> getPerfectNumber(int left, int right) {
        return IntStream.range(left, right)
                .filter(StreamApiTester::isPerfectNumber)
                .boxed()
                .toList();
    }

    private static boolean isPalindrome(String str) {
        var sPointer = 0;
        var ePointer = str.length() - 1;

        while (sPointer <= ePointer) {
            if (str.charAt(sPointer) != str.charAt(ePointer)) {
                return false;
            }
            sPointer++;
            ePointer--;
        }
        return true;
    }

    private static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
