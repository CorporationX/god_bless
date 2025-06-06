package school.faang;

import school.faang.userValidation.User;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Egor", 18, "Yandex", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}