package faang.school.godbless.streamAPI.streamAPI2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var nums = List.of(1, 9, 3, 5, 3, 6, 4, 5);

        Map<String, String> capitalsOfCountries = new HashMap<>();
        capitalsOfCountries.put("Moldova", "Kishinev");
        capitalsOfCountries.put("Germany", "Berlin");
        capitalsOfCountries.put("Romania", "Bucharest");
        capitalsOfCountries.put("Estonia", "Tallinn");
        capitalsOfCountries.put("Russia", "Moscow");


        Map<String, List<String>> personsWithFriends = new HashMap<>();
        var vasya = "Vasya";
        var oleg = "Oleg";
        var alex = "Alex";
        var yarik = "Yarik";
        var denis = "Denis";
        var ann = "Ann";
        var katie = "Katie";

        personsWithFriends.put(vasya, List.of(oleg, yarik, denis));
        personsWithFriends.put(oleg, List.of(vasya, yarik, alex));
        personsWithFriends.put(yarik, List.of(vasya, oleg, katie));
        personsWithFriends.put(denis, List.of(vasya, ann, alex));
        personsWithFriends.put(alex, List.of(oleg, denis));
        personsWithFriends.put(ann, List.of(denis, katie));
        personsWithFriends.put(katie, List.of(ann, yarik));


        List<Employee> employees = List.of(new Employee("Oleg", 100_000, Department.BACKEND),
                new Employee("Vasya", 120_000, Department.BACKEND),
                new Employee("Yarik", 80_000, Department.FRONTEND),
                new Employee("Alex", 100_000, Department.QA),
                new Employee("Ann", 60_000, Department.QA));


        //1 пункт
        System.out.println("Пары чисел (" + nums + ") равные по сумме десяти:");
        System.out.println(getPairsBySum(nums, 10));


        //2 пункт
        System.out.println("\nСтраны и их столицы: " + capitalsOfCountries);

        System.out.println("\nСтолицы стран отсортированных по алфавиту: ");
        printCapitals(capitalsOfCountries);


        //3 пункт
        System.out.println("\nСтроки (страны), начинающиеся на R:");
        getStringsBeginWithChar(capitalsOfCountries.keySet().stream().toList(), 'R').forEach(System.out::println);


        // 4 пункт
        System.out.println("\nЛюди и их друзья:\n" + personsWithFriends);

        System.out.println("\nПары людей, не являющихся прямыми друзьями, но имеющие общих:");
        getFriendsByFriend(personsWithFriends).forEach(System.out::println);


        //5 пункт
        System.out.println("\nРаботники абстрактной конторы:\n" + employees);
        System.out.println("\nСредняя зарплата по отделам:\n" + getMeanSalaryByDepartments(employees));


        //6 пункт
        var alphabet = new char[]{'M', 'o', 'l', 'd', 'v', 'a', 'R', 'm', 'n', 'i'};
        System.out.println("\nСтроки (" + capitalsOfCountries.keySet() + "), состоящие только из символов заданного алфавита (" + Arrays.toString(alphabet) + ") :");
        System.out.println(filterStringsByGivenAlphabet(capitalsOfCountries.keySet().stream().toList(), alphabet));


        //7 пункт
        nums = List.of(1, 2, 3);

        System.out.println("\nЧисла (" + nums + ") в двоичном представлении:");
        System.out.println(transformIntoBinaryView(nums));


        //8 пункт
        System.out.println("\nПалиндромы в диапазоне (1, 131):");
        System.out.println(getPalindromesInRange(1, 131));
    }

    //1 task
    public static List<List<Integer>> getPairsBySum(List<Integer> nums, int sum) {
        return nums.stream()
                .map(num -> {
                    var secondHalfs = new ArrayList<>(nums.stream()
                            .filter(currentNum -> currentNum + num == sum)
                            .toList());

                    secondHalfs.remove(num);

                    return secondHalfs.stream()
                            .map(secondHalf -> Stream.of(num, secondHalf).sorted().toList())
                            .findFirst();
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .distinct()
                .toList();
    }

    //2 task
    public static void printCapitals(Map<String, String> capitalsOfCountries) {
        capitalsOfCountries.keySet().stream()
                .sorted()
                .map(capitalsOfCountries::get)
                .forEach(System.out::println);
    }

    //3 task
    public static List<String> getStringsBeginWithChar(List<String> strings, char character) {
        return strings.stream().filter(string -> string.matches(character + ".*")).sorted(Comparator.comparing(String::length)).toList();
    }

    //4 task
    public static List<? extends List<?>> getFriendsByFriend(Map<String, List<String>> personsWithFriends) {
        return personsWithFriends.keySet().stream()
                .map(person -> personsWithFriends.keySet().stream()
                        .map(candidate -> {
                            if (person.equals(candidate)) {
                                return List.of();
                            }

                            if (areFriends(person, candidate, personsWithFriends)) {
                                return List.of();
                            }

                            if (!haveCommonFriends(person, candidate, personsWithFriends)) {
                                return List.of();
                            }

                            return Stream.of(person, candidate).sorted().toList();
                        })
                        .filter(list -> !list.isEmpty())
                        .toList())
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    private static boolean haveCommonFriends(String person, String candidate, Map<String, List<String>> personsWithFriends) {
        if (person == null || person.isBlank() || candidate == null || candidate.isBlank()) {
            return false;
        }

        var personFriends = personsWithFriends.get(person);
        var candidateFriends = personsWithFriends.get(candidate);

        return personFriends.stream()
                .anyMatch(candidateFriends::contains);
    }

    private static boolean areFriends(String person, String candidate, Map<String, List<String>> personsWithFriends) {
        if (person == null || person.isBlank() || candidate == null || candidate.isBlank()) {
            return false;
        }

        var personFriends = personsWithFriends.get(person);
        var candidateFriends = personsWithFriends.get(candidate);

        return personFriends.contains(candidate) && candidateFriends.contains(person);
    }

    //5 task
    public static Map<String, Integer> getMeanSalaryByDepartments(List<Employee> employees) {
        if (employees == null) {
            return new HashMap<>();
        }

        var employeesByDepartments = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));

        return employeesByDepartments.keySet().stream()
                .map(department -> {
                    var employeesOfCurrentDepartment = employeesByDepartments.get(department);
                    int[] salarySum = {0};
                    employeesOfCurrentDepartment
                            .forEach(employee -> salarySum[0] = employee.salary() + salarySum[0]);

                    var meanSalary = salarySum[0] / employeesOfCurrentDepartment.size();
                    return new Employee("Department mean salary", meanSalary, department);
                })
                .collect(Collectors.toMap(abstractEmployee -> abstractEmployee.department().name(), Employee::salary));
    }

    //6 task
    public static List<String> filterStringsByGivenAlphabet(List<String> strings, char[] alphabet) {
        if (strings == null) {
            return List.of();
        }

        return strings.stream()
                .filter(string -> string.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(character -> String.valueOf(alphabet).contains(character.toString())))
                .sorted()
                .toList();
    }

    // 7 task
    public static List<String> transformIntoBinaryView(List<Integer> nums) {
        if (nums == null) {
            return List.of();
        }

        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    //8 task
    public static List<Integer> getPalindromesInRange(int low, int high) {
        return IntStream.range(low, high + 1)
                .mapToObj(String::valueOf)
                .filter(num -> {
                    var reversed = new StringBuilder(num).reverse().toString();

                    return num.equals(reversed);
                })
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
    }
}
