package school.faang.bjs2_68208;

public class Main {
    public static void main(String[] args) {
        try {
            new User("Alena", 23, "Google", "Amsterdam");
            new User("Lena", 19, null, "New York");
        } catch (IllegalArgumentException ex) {
            System.out.println("Validation FAILED: " + ex);
        }
    }
}
