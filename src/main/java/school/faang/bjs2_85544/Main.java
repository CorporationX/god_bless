package school.faang.bjs2_85544;

public class Main {
    public static void main(String[] args) {

        try {
            new User("Michail", 15, "Amazon", "St Peterburg");
        } catch (IllegalArgumentException exp) {
            System.out.println(exp.getMessage());
        }
    }
}
