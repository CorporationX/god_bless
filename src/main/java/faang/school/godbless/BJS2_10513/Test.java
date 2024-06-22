package faang.school.godbless.BJS2_10513;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            numbers.add(i);
        }

        lines.add("He looked around wildly. The walls and ceiling of the hotel");
        lines.add("Mr. Jacobs turned his attention to treatment.");
        lines.add("Sir sailor, but do whales have christenings?");
        lines.add("He headed for the bathroom.");
        lines.add("Hanna, your father and I have a long history.");


        System.out.println("Сумма четных чисел: " + SomeClass.sumEvenNumbers(numbers));
        System.out.println("Max: " + SomeClass.findMaxNumber(numbers));
        System.out.println("Average: " + SomeClass.findAverageNumber(numbers));
        System.out.println("Строки начинающиеся с символа H: " + SomeClass.countLinesStartingWithCharacter(lines, "H"));
        System.out.println("_________________________________");
        System.out.println("Строки со словом 'He':");
        for (String s : SomeClass.filterLinesContainsSubstring(lines, "He")) {
            System.out.println(s);
        }
        System.out.println("_________________________________");



        System.out.println("_________________________________");
        System.out.println("Строки отсортированные по длинне:");
        for (String s : SomeClass.sortLinesByLength(lines)) {
            System.out.println(s);
        }
        System.out.println("_________________________________");

        System.out.println("Все элементы больше чем 3: "+SomeClass.checkAllElementsForTheCondition(numbers,n->n>3));

        System.out.println("Минимальное число которое больше 7: " + SomeClass.findMinAmongMax(numbers,7));
        System.out.println("Преобразовать список строк в список их длин: "+SomeClass.mapToLength(lines));

    }
}
