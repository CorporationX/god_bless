package school.faang;


public class Main {
    public static void main(String[] args) {
        try {
            User mark = new User("Mark", 15, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
