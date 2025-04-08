package school.faang.userregistr;

public class Main {
    public static void main(String[] args) {
        testValidUser();
        testInvalidUser();
        testNotNullUser();
    }

    public static void testValidUser() {
        try {
            new User("Oleg", 19, "Google", "London");
            System.out.println("КОРРЕКТНА РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ: ТЕСТ ПРОЙДЕН");
        } catch (Exception e) {
            System.out.println("КОРРЕКТНАЯ РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ: ТЕСТ НЕ ПРОЙДЕН.");
        }
    }

    public static void testInvalidUser() {
        initInvalidUser("", 19, "Google", "London");
        initInvalidUser("Oleg", 17, "Google", "London");
        initInvalidUser("Oleg", 19, "GazProm", "London");
        initInvalidUser("Oleg", 19, "Google", "Moscow");
    }

    public static void initInvalidUser(String name, int age, String job, String address) {
        try {
            new User(name, age, job, address);
            System.out.println("НЕ КОРРЕКТНА РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ: ТЕСТ НЕ ПРОЙДЕН.");
        } catch (IllegalArgumentException e) {
            System.out.println("НЕКОРРЕКТНА РЕГИСТРАЦИЯ ПОЛЬЗОВАТЕЛЯ: ТЕСТ ПРОЙДЕН. " + e.getMessage());
        }
    }

    public static void testNotNullUser() {
        initNullUser(null, 30, "Google", "London");
        initNullUser("Oleg", 30, null, "London");
        initNullUser("Oleg", 30, "Google", null);
    }

    public static void initNullUser(String name, int age, String job, String address) {
        try {
            new User(name, age, job, address);
            System.out.println("ВХОДЯЩИЕ ДАННЫЕ NULL: ТЕСТ НЕ ПРОЙДЕН.");
        } catch (NullPointerException e) {
            System.out.println("ВХОДЯЩИЕ ДАННЫЕ NULL: ТЕСТ ПРОЙДЕН. " + e.getMessage());
        }
    }
}

