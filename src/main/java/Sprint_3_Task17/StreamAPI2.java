package Sprint_3_Task17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamAPI2 {
    public static Map<Integer, Integer> API(List<Integer> integerList) {
        int a = 5;
        Map<Integer, Integer> map = new HashMap<>();
//        На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
        integerList.stream()
                .forEach(s -> {
                    if (integerList.contains(a - s)) {
                        int min = Math.min(s, a - s);
                        int max = Math.max(s, a - s);
                        map.put(min, max);
                    }
                });
        return map;
    }

    public static List<String> API2(Map<String, String> map) {
//        На вход получаем мапу с названиями стран и их столицами.
//        Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
        return map.entrySet().stream().
                sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> API3(List<String> list, char c) {
//        Получаем список строк и букву в виде char.
//        Отфильтруйте строки, которые начинаются с заданной буквы,
//        и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, String> API4(Map<String, List<String>> listMap) {
//        Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
//        Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
        Map<String, String> map = new HashMap<>();
        listMap.forEach((s1, listS1) -> {
            listMap.forEach((s2, listS2) -> {
                if (!(s1.equals(s2)) && !(listS1.contains(s2))) {
                    listS1.stream()
                            .filter(listS2::contains)
                            .findFirst()
                            .ifPresent(s -> {
                                if (!(map.containsKey(s2)) || !(map.get(s2).equals(s1))) {
                                    map.put(s1, s2);
                                }});
                }
            });
        });
        return map;
    }
    public static int API5(){
//        Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
//        Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.
        return
    }

    public static void main(String[] args) {

        Map<String, List<String>> listMap = Map.of(
                "Коля",List.of("Влад","Инна"),
                "Никита", List.of("Инна"),
                "Петя", List.of("Влад"));
        System.out.println(API4(listMap));

        char c = 'N';
        List<String> stringList = List.of("dg", "Nikita", "Vlad");
        System.out.println(API3(stringList, c));

        Map<String, String> stringStringMap = Map.of("Россия", "Москва", "M", "f");
        System.out.println(API2(stringStringMap));

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, -1); // 1+4 , 2+3, -1+6
        System.out.println(API(integerList));

    }
}
