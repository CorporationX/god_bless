package faang.school.godbless.streamAPI2;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> str = List.of("Baku", "Berlin", "Valencia", "Varna", "Madrid", "Mexico");
        HashMap<String, String> cityCapital = new HashMap<String,String>();
        cityCapital.put("Armenia", "Yerevan");
        cityCapital.put("Australia", "Canberra");
        cityCapital.put("Azerbaijan", "Baku");
        cityCapital.put("Belarus", "Minsk");

        System.out.println("Пары чисел: " + StaticMethod.pairChisel(nums, 5));
        System.out.println("Название столиц: " + StaticMethod.cityList(cityCapital));
//        System.out.println("Максимальное значение: " + StaticMethod.maxNum(nums));
//        System.out.println("Среднее значение: " + StaticMethod.averageNum(nums));
//        System.out.println("Кол-во строк начинающихся с B: "+ + StaticMethod.countStr(str, "B"));
//        System.out.println("Строки с подстрокой Va: " +  StaticMethod.filterStr(str, "Va"));
//        System.out.println("Сортировка по длине: " +  StaticMethod.sortForLenght(str));
//
//        Predicate<String> predicate = s -> s.length() > 5;
//        System.out.println("Условие: " + StaticMethod.anyMatchFind(str, predicate));
//
//        System.out.println("Первый мин элемент: " +  StaticMethod.minFind(nums, 4));
//        System.out.println("Строка -> длина: " +  StaticMethod.strLenght(str));
    }
}
