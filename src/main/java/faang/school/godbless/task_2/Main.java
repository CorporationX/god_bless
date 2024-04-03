package faang.school.godbless.task_2;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("", 19, "Amazon", "Amsterdam");
            System.out.println(user1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user2 = new User("Nikita", 16, "Uber", "New York");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user3 = new User("Dasha", 21, "company", "London");
            System.out.println(user3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user4 = new User("Danya", 19, "Google", "address");
            System.out.println(user4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user5 = new User("Valera", 20, "Amazon", "London");
            System.out.println(user5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
