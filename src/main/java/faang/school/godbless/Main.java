package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", 21, "Google", "Amsterdam");
        System.out.println("Пользователь " + user1 + " создан");

        try {
            User user2 = new User("  ", 18, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user3 = new User("Dima", 15, "Uber", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user4 = new User("Vika", 25, "Netflix", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user5 = new User("Egor", 20, "Google", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
