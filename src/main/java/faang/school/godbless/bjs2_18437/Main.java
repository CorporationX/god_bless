package faang.school.godbless.bjs2_18437;

public class Main {
    public static void main(String[] args) {
        try {
            var user1 = new User("", 17, "x", "x", false);
        } catch (Exception e) {
            System.out.println("1 case: " + e.getMessage());
        }

        try {
            var user2 = new User("", 17, "x", "x", true);
        } catch (Exception e) {
            System.out.println("2 case: " + e.getMessage());
        }

        try {
            var user3 = new User("Alexander", 18, "Google", "London", true);
        } catch (Exception e) {
            System.out.println("3 case: " + e.getMessage());
        }
    }
}
