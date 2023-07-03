package faang.school.godbless.sprint3.StreamAPI_1;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> listInt = List.of(7,1,2,3,4,5,6);

        int sumEven = listInt.stream().filter(a->a%2==0).parallel().mapToInt(Integer::intValue).sum();
        System.out.println("Сумма четных - "+sumEven);

        int maxNum = listInt.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Максимальное число - "+maxNum);

        int middleValue = listInt.stream().mapToInt(Integer::intValue).sum()/listInt.size();
        System.out.println("Среднее значение - "+middleValue);

        int minFromMore4 = listInt.stream().filter(a->a>4).min(Comparator.naturalOrder()).get();
        System.out.println("Минимальный элемент больше 4 - "+minFromMore4);

        List<String> listString = List.of("add", "buy", "kill", "application","ad");

        int countStringA =(int) listString.stream().filter(s->s.toLowerCase().toCharArray()[0]=='a').count();
        System.out.println("колличество букв начинающихся с А - "+countStringA);

        List<String> listAD= listString.stream().filter(a->a.toLowerCase().contains("ad")).toList();
        System.out.println("Список строк содержащих ad - "+ listAD);

        List<String> sortByLen = listString.stream().sorted(Comparator.comparingInt(a->a.length())).toList();
        System.out.println("Сортировка по длине - " + sortByLen);

        boolean allMatch = listString.stream().allMatch(a->!a.isEmpty());
        System.out.println("Список не пустой - "+allMatch);

        List<Integer> listLen = listString.stream().map(a->a.length()).toList();
        System.out.println("Список длин - "+ listLen);

    }
}
