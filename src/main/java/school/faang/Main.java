package school.faang;

import school.faang.services.User;

public class Main {
    public static void main(String[] args) {
        try {
            User testUser = new User("Вася",25,"Uber","Amsterdam");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
