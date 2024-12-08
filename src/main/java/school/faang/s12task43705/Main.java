package school.faang.s12task43705;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Saveliy", 35, "Google", "London");
            System.out.println(user1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            User user2 = new User(" ", 35, "Google", "London");
            System.out.println(user2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            User user3 = new User("Saveliy", 16, "Google", "London");
            System.out.println(user3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            User user4 = new User("Saveliy", 35, "NII", "London");
            System.out.println(user4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            User user5 = new User("Saveliy", 35, "Google", "Vologda");
            System.out.println(user5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}