package school.faang.BJS2_79251;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Amir", 19, "Google", "New-York");
        User user2 = new User("Altyn", 18, "Uber", "Amsterdam");
        try {
            User user3 = new User("", 10, "", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            User user4 = new User("A", 10, "", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            User user5 = new User("dv", 19, "", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            User user5 = new User("dv", 19, "Amazon", "");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
