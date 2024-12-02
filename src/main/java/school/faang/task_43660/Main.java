package school.faang.task_43660;

public class Main {
    public static void main(String[] args) {

        try {
            User user1 = new User("", 19, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user1 = new User("some name1", 16, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user1 = new User("some name2", 19, "Googl", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user1 = new User("some name3", 19, "Uber", "Londn");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(new User("some name", 18, "Amazon", "New York"));
    }

}
