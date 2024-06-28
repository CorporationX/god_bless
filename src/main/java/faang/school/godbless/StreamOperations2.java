package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations2 {
    public static Set<Pair> findPairs(List<Integer> list, int summ) {
        Set<Pair> sumPair = list.stream()
                .flatMap(i -> list.stream()
                        .filter(p -> (i + p) == summ && list.indexOf(p) != list.indexOf(i))
                        .map(p -> new Pair(i, p)))
                .collect(Collectors.toSet());
        return sumPair;
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).toList();
    }

    public static List<String> sortStrings(List<String> strings, char letter) {
        return strings.stream().filter(str -> str.startsWith(String.valueOf(letter))).sorted((o1, o2) -> o1.length() - o2.length()).toList();
    }

    //Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
    //Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
    public static List<Pair> findCommonFriends(Map<String, List<String>> friends) {
        return new ArrayList<Pair>();
        //помогите с этим пунктом, как-то сложно и нет идей
    }
    public static Map<String,Double> findAvSalaryInDep (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    // C последовательностью символов легко, а вот именно с алфавитом сложно, нет идей, прошу помощи
    public static List<String> sortStringsWithLetters(List<String> strings, CharSequence charSequence) {
        return strings.stream()
                .filter(str -> str.contains(charSequence))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }


    public static void main(String[] args) {
        List<Integer> listToStream = new ArrayList<Integer>();
        listToStream.add(1);
        listToStream.add(5);
        listToStream.add(2);
        listToStream.add(4);
        listToStream.add(16);
        listToStream.add(15);
        listToStream.add(18);
        Set<Pair> sumPair = findPairs(listToStream, 20);
        for (Pair pair : sumPair) {
            System.out.println(pair);
        }

        Map<String, String> countries = new HashMap<String, String>();
        countries.put("Great Britain", "London");
        countries.put("America", "Washington");
        countries.put("Russia", "Moscow");
        countries.put("Spain", "Milan");
        List<String> capitals = sortCapitals(countries);
        System.out.println(sortCapitals(countries));

        List<String> Strings = new ArrayList<>();
        Strings.add("zzzzpp000000000");
        Strings.add("zzzzppp");
        Strings.add("222ffzppp");
        Strings.add("222zzpff");
        Strings.add("222zzpff1111");
        Strings.add("122zzzppp9999");
        System.out.println(sortStrings(Strings, '2'));

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alex", List.of("Maria", "Kevin"));
        friends.put("Ivan", List.of("Maria", "Alex"));
        friends.put("Sveta", List.of("Maria", "Dima"));

        System.out.println(convertToBinary(listToStream));
        System.out.println(sortStringsWithLetters(Strings,"222"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Vasya",4000,"DEVOPS"));
        employees.add(new Employee("Petya",3000,"QA"));
        employees.add(new Employee("Mikhail",5000,"DEVOPS"));
        employees.add(new Employee("Mikhail",2000,"QA"));
        Map<String, Double> avSalariesInDep = findAvSalaryInDep(employees);
        //Просто тренировка вывода списка отделов
        List<String> departments = employees.stream()
                .map(e -> e.getDepartment()).distinct().toList();
        avSalariesInDep.entrySet().stream()
                .map(e -> " "+e.getKey()+" "+e.getValue())
                .forEach(System.out::println);
        departments.stream().forEach(System.out::println);
    }
}
