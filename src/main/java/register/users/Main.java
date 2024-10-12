package register.users;

public class Main {
    public static void main(String[] args) {
        try {
            User users = new User("Ivan", 18, "Uber", "New York");
            System.out.println(users);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}