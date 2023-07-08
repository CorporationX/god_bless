package faang.school.godbless.stream.task01_StreamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Math {
    public <T> void listException(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Лист пуст");
        }
    }
    public int calculateSumOfEvenNumbers(List<Integer> integerList) {
        listException(integerList);
        return integerList.stream()
                .filter(x -> x%2==0)
                .mapToInt(Integer::intValue).sum();
    }
    public int maxNumber(List<Integer> integerList) {
        listException(integerList);
        return integerList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }
    public double averageNumber(List<Integer> integerList) {
        listException(integerList);
        return integerList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }
    public List<String> valueString(List<String> stringList, char findChar) {
        listException(stringList);
        return stringList.stream()
                .filter(string -> string.charAt(0)==findChar)
                .toList();
    }
    public List<String> filterString(List<String> stringList, String substring) {
        listException(stringList);
        return stringList.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }
    public List<String> filterByLengthString(List<String> stringList){
        listException(stringList);
        return stringList.stream()
                .sorted(Comparator.reverseOrder()) //Вместо .sorted((s1, s2) -> s2.length() - s1.length())
                .toList();
    }
//    public List<Integer> ifElseList(List<Integer> integerList){
//        listException(integerList);
//        return integerList.stream()
//                .filter(integer -> integer > 5) //я просто такое условие придумал, мб его можно будет задать через Predicate?
//                .mapToInt(Integer); //этот метод скорее всего неправильный
//    }
//    public List<Integer> ifElseList(List<Integer> integerList){
//        listException(integerList);
//        return integerList.stream()
//                .filter(integer -> integer > 5) //я просто такое условие придумал, мб его можно будет задать через Predicate?
//                .mapToInt(Integer); //этот метод скорее всего неправильный
//    }
    public int minNumberPredicate(List<Integer> integerList, Predicate<Integer> integerPredicate){
        listException(integerList);
        return integerList.stream()
                .filter(integerPredicate)
                .min(Integer::compareTo)
                .orElse(0); //ошибок не выдает, но кажется что неправильно что-то
    }
    public List<Integer> convertingListStringToListLength(List<String> stringList){ //слишком длинное название ?
        listException(stringList);
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
