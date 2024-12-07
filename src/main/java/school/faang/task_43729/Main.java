package school.faang.task_43729;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {

        try {
            User user = new User("Wow", 18, "Google", "Amsterdam");
            System.out.println(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
