package faang.school.godbless.streamAPI2;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> str = List.of("Baku", "Berlin", "Valencia", "Varna", "Madrid", "Mexico");
        List<Character> characters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'i', 'v', 's', 'x');
        HashMap<String, String> cityCapital = new HashMap<>();
        cityCapital.put("Armenia", "Yerevan");
        cityCapital.put("Australia", "Canberra");
        cityCapital.put("Azerbaijan", "Baku");
        cityCapital.put("Belarus", "Minsk");

        HashMap<String, List<String>> friends = new HashMap<>();
        friends.put("Andrey", List.of("Sasha", "Dmitry"));
        friends.put("Ivan", List.of("Sasha", "Dmitry"));
        friends.put("Nikolai", List.of("Oleg", "Michail"));
        friends.put("Ilia", List.of("Oleg", "Michail"));

        Employee employee1 = new Employee("Vasya", 10000, "Dev");
        Employee employee2 = new Employee("Kolya", 20000, "QA");
        Employee employee3 = new Employee("Petya", 30000, "QA");
        Employee employee4 = new Employee("Sergey", 40000, "HR");
        Employee employee5 = new Employee("Anna", 50000, "HR");
        Employee employee6 = new Employee("Kate", 60000, "Dev");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        List<String> strWord = List.of("First", "Second", "Third", "Four", "Five", "Six", "Seven", "Eight", "Nine");

        System.out.println("Пары чисел: " + StaticMethod.pairChisel(nums, 5));
        System.out.println("Название столиц: " + StaticMethod.cityList(cityCapital));
        System.out.println("Строки с буквы В: " + StaticMethod.wordList(str, 'B'));
        System.out.println("Строки с буквы В: " + StaticMethod.friendsPair(friends));
        System.out.println("Средняя зарплата: " + StaticMethod.averageSalary(employees));
        System.out.println("Строки по длине: " + StaticMethod.sortWord(strWord, characters));
        System.out.println("Двоичное число: " + StaticMethod.integerInString(nums));
        System.out.println("Средняя зарплата: " + StaticMethod.integerInString(nums));
        System.out.println("Полиндром: " + StaticMethod.palindrome(1, 300));
    }
}
