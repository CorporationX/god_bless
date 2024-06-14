package faang.school.godbless.StreamAPI2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 1, 3, 2, 6, 4, 3, 5, 3, 2);
        System.out.println(StaticMetodStream.sumUnique(nums, 5));

        Map<String, String> map = Map.of("Франция", "Париж", "Голландия", "Харлем", "Россия", "Москва", "Британия", "Лондон");
        System.out.println(StaticMetodStream.capitalsList(map));

        List<String> strings = List.of("vова", "дима", "дом", "vодолей", "ром", "vи", "сад", "vорот");
        char b = 'v';
        System.out.println(StaticMetodStream.filterString(strings, b));

        Map<String, List<String>> mapList = Map.of("vova", List.of("lera", "sasha", "roma"), "grisha", List.of("roma", "lera", "katia"), "lera", List.of("Kolia", "grisha", "vova"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A", 200, "O1"));
        employees.add(new Employee("B", 300, "O1"));
        employees.add(new Employee("C", 400, "O2"));
        System.out.println(StaticMetodStream.avgSalaryToDivision(employees));

        List<String> strings1 = List.of("apple", "banana", "123", "dog", "cat");
        List<Character> characters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        System.out.println(StaticMetodStream.filterString(strings1, characters));

//        long
        List<Integer> numbinary = List.of(2, 3, 4, 5, 6);
        System.out.println(StaticMetodStream.convertsNumInString(numbinary));

        System.out.println(StaticMetodStream.filterNumberPalindrom(100, 150));

        String palindrom = "D did yon ganag min";
        System.out.println(StaticMetodStream.palindromString(palindrom));
    }
}
