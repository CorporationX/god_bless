package faang.school.godbless.streamAPI2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> str = List.of("Baku", "Berlin", "Valencia", "Varna", "Madrid", "Mexico");
        List<Character> characters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
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

        System.out.println("Пары чисел: " + StaticMethod.pairChisel(nums, 5));
        System.out.println("Название столиц: " + StaticMethod.cityList(cityCapital));
        System.out.println("Строки с буквы В: " + StaticMethod.wordList(str, 'B'));
        System.out.println("Строки с буквы В: " + StaticMethod.friendsPair(friends));
    }
}
