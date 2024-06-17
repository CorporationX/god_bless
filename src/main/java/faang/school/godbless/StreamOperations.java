package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
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
    //Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
    //Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
    //Тоже нет идей

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    //Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
    // и отсортируйте их в порядке возрастания длины строк.
    // C последовательностью символов легко, а вот именно с алфавитом сложно, нет идей, прошу помощи
    public static List<String> sortStringsWithLetters(List<String> strings, char[] letters) {
        CharSequence charSequence = Arrays.toString(letters);
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
        char[] charArray = new char[2];
        charArray = "12".toCharArray();
        //System.out.println(charArray);
        //System.out.println(sortStringsWithLetters(Strings, charArray));
    }
}
