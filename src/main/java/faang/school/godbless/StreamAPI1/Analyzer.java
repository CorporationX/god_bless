package faang.school.godbless.StreamAPI1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Analyzer {

    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        Optional<Integer> optionalInteger = (Optional<Integer>) nums.stream().max((x, y) -> x - y);
        return optionalInteger.orElse(nums.get(0));
    }

    public static double avg(List<Integer> nums){
        return nums.stream().mapToInt(x -> x).average().orElse(0);
    }

    public static List<String> startsWith(List<String> strings, char ch){
        return Optional.of(strings.stream().filter(s -> s.startsWith(Character.toString(ch))).toList()).orElse(new ArrayList<>());
    }

    public static List<String> contents(List<String> strings, String substring){
        return Optional.of(strings.stream().peek(s -> s.toLowerCase()).filter(s -> s.contains(substring.toLowerCase())).toList()).orElse(new ArrayList<>());
    }

    public static List<String> SortByLength(List<String> strings){
        return Optional.of(strings.stream().sorted((s1, s2) -> s1.length()-s2.length()).toList()).orElse(strings); //реализация по умолчанию, но всё равно напишем для тренировки
    }

    public static <T> boolean checkCondition(List<T> list, Predicate<T> predicate){
        return Optional.of(list.stream().allMatch(predicate)).orElse(false);
    }

    public static Optional<Integer> minBiggerThen(List<Integer> nums, int num){
        return Optional.of(nums.stream().filter(x -> x > num).min((x1,x2)->x1-x2)).orElseThrow(() -> new IllegalArgumentException("Нет чисел больше переданного"));
    }

    public static List<Integer> stringsLength(List<String> strings){
        return Optional.of(strings.stream().map(s -> s.length()).toList()).orElseThrow(()-> new IllegalArgumentException("Список пуст"));
    }
}
