package faang.school.godbless.javaCore.registerUser;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Вася", 25, "Google", "Moscow");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println("user1 не подходит");
        }

        try {
            User user2 = new User("Катя", 25, "Amazon", "New York");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("user2 не подходит");
        }

        try {
            User user3 = new User("Лиза", 28, "Uber", "Amsterdam");
            System.out.println(user3);
        } catch (IllegalArgumentException e) {
            System.out.println("user3 не подходит");
        }

        try {
            User user4 = new User("Костя", 28, "Apple", "California");
            System.out.println(user4);
        } catch (IllegalArgumentException e) {
            System.out.println("user4 не подходит");
        }
    }
}