package faang.school.godbless.StreamAPI1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> str = List.of("Letooo", "Moreeee", "Jaraa", "Mir", "Mart", "Love");
        List<String> str2 = List.of("Лето в столице", "Лето зимой", "вперед лето", "нилето");
        System.out.println(staticMetod.sumNumsList(nums));
        System.out.println(staticMetod.maxNumList(nums));
        System.out.println(staticMetod.avgNumsList(nums));
        System.out.println(staticMetod.findNumLine(str, "L"));
        System.out.println(staticMetod.filterList(str2, "Лето"));
        System.out.println(staticMetod.sortListString(str));
        System.out.println(staticMetod.anyMatchTest(str));
        System.out.println(staticMetod.minNumListBigNum(nums, 4));
        System.out.println(staticMetod.stringConvertLength(str));
    }
}
