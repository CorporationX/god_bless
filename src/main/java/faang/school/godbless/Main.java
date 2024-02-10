package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Behzod", 20, "Uber", "Amsterdam");
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getWork());
            System.out.println(user.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
