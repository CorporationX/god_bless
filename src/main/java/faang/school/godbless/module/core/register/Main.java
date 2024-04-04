package faang.school.godbless.module.core.register;

import faang.school.godbless.module.core.group.User;

public class Main {
    public static void main(String[] args) {
        User ivan = new User("Иван", 20, "Google", "London");
        User vova = new User("Володька", 31, "Фрезировщик", "Улица Пушкина");
        User lilya = new User("Лилия", 31, "Прогер", "Улица Пушкина");
        User empty = new User(null, 12, "Прогер", "Улица Пушкина");
    }
}
