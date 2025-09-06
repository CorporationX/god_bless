package school.faang.bjs2_85558;

public class Main {
    public static void main(String[] args) {
        try {
            new User("Margaret", 39, "Google", "London");
            new User("", 30, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }
}
