package faang.school.godbless.StreamAPI1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> str = List.of("Letooo", "Moreeee", "Jaraa", "Mir", "Mart", "Love");
        List<String> str2 = List.of("Лето в столице", "Лето зимой", "вперед лето", "нилето");
        System.out.println(StaticMetod.sumNumsList(nums));
        System.out.println(StaticMetod.maxNumList(nums));
        System.out.println(StaticMetod.avgNumsList(nums));
        System.out.println(StaticMetod.findNumLine(str, "L"));
        System.out.println(StaticMetod.filterList(str2, "Лето"));
        System.out.println(StaticMetod.sortListString(str));
        System.out.println(StaticMetod.anyMatchTest(str));
        System.out.println(StaticMetod.minNumListBigNum(nums, 4));
        System.out.println(StaticMetod.stringConvertLength(str));
    }
}
