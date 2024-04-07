package faang.school.godbless.module.core.group;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User ivan = new User("Иван", 20, "Фрезировщик", "Улица Кукева");
        User vova = new User("Володька", 31, "Фрезировщик", "Улица Пушкина");
        User lilya = new User("Лилия", 31, "Прогер", "Улица Пушкина");

        System.out.println(User.groupUsers(List.of(ivan, vova, lilya)));
    }
}
