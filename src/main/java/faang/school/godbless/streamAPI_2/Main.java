package faang.school.godbless.streamAPI_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final List<Integer> NUMBERS = List.of(1, 9, 3, 6, 10, 5, 2, 7, 8, 4);
    private static final Map<String, String> COUNTRIES = new HashMap<>();
    private static final List<String> STRINGS = List.of("Russia", "Beijing",
            "Berlin", "Roma", "Moscow", "Madrid");
    private static final Map<String, List<String>> FRIENDS = new HashMap<>();
    private static final List<String> INPUT_STRINGS = List.of("apple", "banana", "123", "dog",
            "original", "oranges", "good", "go@od");
    private static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //пункт 1
    public static List<List<Integer>> getPairs(List<Integer> inputList, int target) {
        System.out.println("Input List: " + inputList);
        System.out.println("Target Sum: " + target);
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            //получаем  первое число для пары
            int firstNumber = inputList.get(i);
            //получаем новый список без уже полученного числа
            List<Integer> subbedList = inputList.subList(i + 1, inputList.size());
            //ищем в списке пару к полученному числу, которое в сумме даёт целевое число
            List<Integer> secondNumber = new ArrayList<>(subbedList.stream()
                    .filter(integer -> (target - firstNumber) == integer)
                    .toList());
            if (!secondNumber.isEmpty()) {
                List<Integer> pair = new ArrayList<>();//пара, дающая в сумме целевое число
                pair.add(firstNumber);
                pair.add(secondNumber.get(0));
                pairs.add(pair);
            }
        }
        return pairs;
    }

    //пункт 2
    public static List<String> getCapitalsSortedByCountry(Map<String, String> inputMap) {
        return inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList()
                .stream()
                .map(Map.Entry::getValue)
                .toList();
    }

    //пункт 3
    public static List<String> getStringsSortedByLength(List<String> inputStrings, char inputChar) {
        String input = String.valueOf(inputChar);
        return inputStrings.stream()
                .filter(string -> string.startsWith(input))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //пункт 4
//    public static List<List<String>> getFriendPairs(Map<String, List<String>> friends) {
//        List<List<String>> friendPairs = new ArrayList<>();
//
//        for (Map.Entry<String, List<String>> listFriends : friends.entrySet()) {
////            listFriends.getKey().
//            //создаём список не друзей данного человека
//
//            List<String> noFriendNames = listFriends.getValue().stream()
//
//                    .filter(friend -> !friend.equals(listFriends.getKey()))
//                    .toList();
//            if (!noFriendNames.isEmpty()) {
//                //по ключам находим список списков друзей не друзей данного человека
//                List<List<String>> listNoFriendNames = noFriendNames.stream()
//                        .map(friends::get)
//                        .toList();
//                //по ключу из входной мапы находим пару
//                for (List<String> strings : listNoFriendNames) {
//                    List<String> friendPair = strings.stream()
//                            .filter(name -> name.equals(listFriends.getKey()))
//                            .toList();
//                    if (!friendPair.isEmpty()) {
//                        List<String> pair = new ArrayList<>();
//                        pair.add(listFriends.getKey());
//                        pair.add(friendPair.get(0));
//                        friendPairs.add(pair);
//                    }
//                }
//            }
//        }
//
//        return friendPairs;
//    }

    //пунк 5
    public static Map<String, Double> getAvgSalariesGrouptByDepartment(List<Employee> employees) {
        Map<String, Double> avgSalaries = new HashMap<>();//итоговая мапа


        //получаем список ключей
        Set<String> keys = new HashSet<>();
        for (Employee employee : employees) {
            keys.add(employee.department());
        }

        for (String key : keys) {
            //вычисляем кол-во работников в каждом отделе
            long amountEmployeesInDepartment = employees.stream()
                    .filter(dep -> dep.department().equals(key))
                    .count();
            //вычисляем среднюю зарплату в каждом отделе
            double avgSalary = (double) employees.stream()
                    .filter(dep -> dep.department().equals(key))
                    .map(Employee::salary)
                    .reduce(0, Integer::sum) / amountEmployeesInDepartment;
            avgSalaries.put(key, avgSalary);
        }
        return avgSalaries;
    }

    //пункт 6
    public static List<String> getAlphabetStringsSortedByLength(
            List<String> strings, char[] chars) {
        List<String> outputStrings = new ArrayList<>();//результирующий список
        for (String string : strings) {
            int[] ints = string.toLowerCase().chars()//создаём поток кодов символов строки
                    //проверяем, что код символа соответствует коду символа из алфавита
                    .filter(integer -> integer >= 97 && integer <= 122)
                    .toArray();
            //если длина итогового массива равна длинге строки,
            // то строка состоит из символов алфавита
            if (string.length() == ints.length) {
                outputStrings.add(string);
            }
        }
        return outputStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    //пункт 7
    public static List<String> getNumbersToBinaryStrings(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //пункт 8
    public static List<Long> getPallindromNumbers(long first, long last) {
        if (first >= last) {
            throw new IllegalArgumentException("Второе число должно быть больше первого!");
        }
        //преобразуем числа в строки и создаём их список
        List<String> stringsOfNumbers = new ArrayList<>();
        for (long i = first; i <= last; i++) {
            String str = Long.toString(i);
            stringsOfNumbers.add(str);
        }
        System.out.printf("Диапазон чисел от %d до %d\n", first, last);
        return stringsOfNumbers.stream()
                .filter(string -> {
                    int length = string.length();
                    if (length != 1) {
                        //в цикле сравниваем элементы с начала и c конца строки, идя навстречу
                        for (int i = 0; i < length / 2; i++) {
                            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                                return false;
                            }
                        }
                    }
                    return true;
                })
                .toList().stream()
                .map(Long::parseLong)
                .toList();
    }

    public static void main(String[] args) {
        //пункт 1
        System.out.println("Point 1.");
        System.out.println(getPairs(NUMBERS, 10));

        //пункт 2
        System.out.println();
        System.out.println("Point 2.");

        COUNTRIES.put("Russia", "Moscow");
        COUNTRIES.put("USA", "New York");
        COUNTRIES.put("Germany", "Berlin");
        COUNTRIES.put("Spain", "Madrid");
        COUNTRIES.put("Italy", "Roma");
        COUNTRIES.put("China", "Beijing");

        System.out.println(getCapitalsSortedByCountry(COUNTRIES));

        //пункт 3
        System.out.println();
        System.out.println("Point 3.");
        char inputChar = 'R';
        System.out.println(inputChar);
        System.out.println(getStringsSortedByLength(STRINGS, inputChar));


        //пункт 5
        System.out.println();
        System.out.println("Point 5.");
        Employee igor = new Employee("Igor", 100, "Development");
        Employee maxim = new Employee("Maxim", 200, "Development");
        //получаем список объектов Employee
        List<Employee> employees = new ArrayList<>();
        employees.add(igor);
        employees.add(maxim);
        employees.add(new Employee("Sergy", 300, "Engineering"));
        employees.add(new Employee("Volodimir", 150, "Engineering"));
        employees.add(new Employee("Vlad", 250, "Production"));
        employees.add(new Employee("Oleg", 350, "Production"));
        System.out.println(getAvgSalariesGrouptByDepartment(employees));

        //пункт 6
        System.out.println();
        System.out.println("Point 6.");
        System.out.println(INPUT_STRINGS);
        System.out.println(ALPHABET);
        System.out.println(getAlphabetStringsSortedByLength(INPUT_STRINGS, ALPHABET));

        //пункт 7
        System.out.println();
        System.out.println("Point 7.");
        System.out.println(NUMBERS);
        System.out.println(getNumbersToBinaryStrings(NUMBERS));

        //пункт 8
        System.out.println();
        System.out.println("Point 8.");
        System.out.println(getPallindromNumbers(100, 200));

        //пункт 4
        FRIENDS.put("Igor", List.of("Sergey", "Nikolay", "Dmitry"));
        FRIENDS.put("Sergey", List.of("Igor", "Nikolay", "Vasily"));
        FRIENDS.put("Nikolay", List.of("Igor", "Sergey", "Vasily"));
        FRIENDS.put("Vasily", List.of("Sergey", "Dmitry", "Nikolay"));
        System.out.println();
        System.out.println("Point 4.");
//        System.out.println(getFriendPairs(FRIENDS));
    }
}
