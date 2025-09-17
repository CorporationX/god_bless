package school.faang.s1.java_core;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Greg", 25, "Google", "London");
            System.out.println("Пользователь создан: " + validUser.getName());

            User invalidAgeUser = new User("Gary", 17, "Amazon", "Amsterdam");
            User invalidJobUser = new User("Gary", 19, "AmazIn", "Amsterdam");
            User invalidAddressUser = new User("Gary", 19, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
