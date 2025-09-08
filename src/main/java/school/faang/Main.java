package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Anton", 22, "Yandex", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user2 = new User("Alex", 20, "Google", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user3 = new User("Leo", 23, "Sber", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user4 = new User("Dan", 24, "Amazon", "Saransk");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user5 = new User(" ", 17, "Sber", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
