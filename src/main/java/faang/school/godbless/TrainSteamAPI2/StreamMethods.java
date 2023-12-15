package faang.school.godbless.TrainSteamAPI2;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;


@UtilityClass
public class StreamMethods {

    //Найдите все уникальные пары чисел, сумма которых равна заданному числу
    public static Set<List<Integer>> uniquePairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pair = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == sum && j != i)
                        .map(j -> Arrays.asList(Math.min(i, j), Math.max(i, j))))
                .collect(Collectors.toSet());
        return pair;
    }


    //На вход получаем мапу с названиями стран и их столицами.
    // Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public List<String> capitalsSort(Map<String, String> country) {
        List<String> entryStream = country.entrySet().stream()
                .sorted((x, y) -> x.getKey().compareTo(y.getKey()))
                .sorted(Comparator.comparing(Map.Entry::getKey))
                //.sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
        return entryStream;
    }


    //Получаем список строк и букву в виде char.
    // Отфильтруйте строки, которые начинаются с заданной буквы,
    // и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
    public List<String> sortStringsByLength(List<String> strings, Character character) {
        List<String> sortStrings = strings.stream()
                .filter(string -> string.startsWith(character.toString()))
                .sorted()
                .toList();
        return sortStrings;
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    // Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья
    public Set<List<String>> friendsFriends(Map<String, List<String>> friends) {
        Set<List<String>> pairFriends = friends.entrySet().stream()
                .flatMap(friend1 -> friends.entrySet().stream()
                        .filter(friend2 -> !friend1.getKey().equals(friend2.getKey()))
                        .filter(friend2 -> !friend1.getKey().contains(friend2.getKey()))
                        .filter(friend2 -> friend2.getValue().stream()
                                .anyMatch(friend1.getValue()::contains))
                        .map(friend2 -> { //тут по-другому не смогла сравнить ключи
                            if (friend1.getKey().compareToIgnoreCase(friend2.getKey()) > 0)
                                return Arrays.asList(friend1.getKey(), friend2.getKey());
                            else
                                return Arrays.asList(friend2.getKey(), friend1.getKey());
                        }))
                .collect(Collectors.toSet());
        return pairFriends;
    }

    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    // Найдите среднюю зарплату для каждого отдела.
    // Должна получится map с именем отдела и средней зарплатой.
        public Map<String, Double> averageDepartmentSalary(List<Employee> employees){
            return  employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)));

        }



}
