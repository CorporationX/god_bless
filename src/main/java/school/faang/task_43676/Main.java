package school.faang.task_43676;

public class Main {
    public static void main(String[] args){
        try {
            User user = new User("NoName", 12, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("", 20, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("NoName", 20, "T1", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("NoName", 20, "Google", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("NoName", 20, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
