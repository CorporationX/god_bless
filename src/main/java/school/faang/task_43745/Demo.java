package school.faang.task_43745;

public class Demo {
    public static void main(String[] args) {

        try {
            User user1 = new User("Den", 18, "Uber",
                    "New York");
            System.out.println(user1);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
