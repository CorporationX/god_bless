package school.faang.task_43673;

public class Main {
    public static void main(String[] args) {

        try {
            User user = new User("Maksim", 19, "Uber", "New York");
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


