package school.faang.BJS2_79141;

public class Main {
    public static void main(String[] args) {

        try {
            User user1 = new User("Nikita", 19, "Student", "Петергоф");
            User user2 = new User("Steve", 20, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }
}
