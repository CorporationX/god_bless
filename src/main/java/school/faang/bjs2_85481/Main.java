package school.faang.bjs2_85481;

public class Main {
    public static void main(String[] args) {
        try {
            User test = new User(" ", 17, "Amazonn", "Londonn");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
