package school.faang.task_43746;

public class Main {
    public static void main(String[] args) {
        try {
            User us1 = new User("Nepo", 18, "Uber", "Amsterdam");
            System.out.println(us1);
            User us2 = new User("Olga", 23, "Amazon", "London");
            System.out.println(us2);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
