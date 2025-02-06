package school.faang.BJS2_56426;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        try {
            if (ThreadLocalRandom.current().nextInt(2) == 0) {
                User unvalidUser = new User("", 10, "anyWork", "anyAddress");
            } else {
                User unvalidUser = new User("Ramil", 33, "Google", "London");
                System.out.println(unvalidUser.toString());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
