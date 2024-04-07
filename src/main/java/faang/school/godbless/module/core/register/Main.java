package faang.school.godbless.module.core.register;

public class Main {
    public static void main(String[] args) {
        User ivan = null;
        try {
            ivan = new User("", 20, "Google", "London");
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
        User vlad = null;
        try {
            vlad = new User("Vlad", 17, "Google", "London");
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
        User vova = null;
        try {
            vova = new User("Володька", 31, "Фрезировщик", "London");
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
        User lilya = null;
        try {
            lilya = new User("Лилия", 31, "Google", "Улица Пушкина");
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
    }
}
