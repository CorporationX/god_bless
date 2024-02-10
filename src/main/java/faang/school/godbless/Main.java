package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User(null,19 ,"Uber", "Amsterdam");
            System.out.println(user1.getName());
            System.out.println(user1.getAge());
            System.out.println(user1.getWork());
            System.out.println(user1.getAddress());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
