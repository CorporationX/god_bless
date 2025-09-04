package school.faang.bjs2_85551;

public class Main {
    public static void main(String[] args) {
        try {
            new User("Edvard", 20, "Actor", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
