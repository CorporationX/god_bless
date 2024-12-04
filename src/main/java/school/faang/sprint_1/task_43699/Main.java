package school.faang.sprint_1.task_43699;

public class Main {
    public static void main(String[] args) {
        try {
            var user = new User("", 23, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            var user = new User("Vanya", 17, "Google", "London");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            var user = new User("Dima", 24, "Facebook", "Amsterdam");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            var user = new User("Ira", 22, "Uber", "Paris");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            var user = new User("Olya", 27, "Amazon", "New York");
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
