package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String... args) {
        Methods methods = new Methods();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> textList = List.of("test", "2test", "3test", "4test", "test5", "test6");
        System.out.println(methods.sum(numbers));
        System.out.println(methods.max(numbers));
        System.out.println(methods.average(numbers));
        System.out.println(methods.countStringFirsElement(textList, "t"));
        System.out.println(methods.FilterStringElement(textList, new StringBuilder("test")));
        System.out.println(methods.CortStringElement(textList));
        System.out.println(methods.checkCondition(textList, (text) -> text.isEmpty()));
        System.out.println(methods.minWithCount(numbers, 4));
        System.out.println(methods.lengsString(textList));
    }


}
