package school.faang.task_43655;

public class Main {

    public static void main(String[] args) {

        try {
            User validUser = new User("Albert", 18, "Uber", "Amsterdam");
            System.out.println("Пользователь создан" + validUser.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании пользователя " + e.getMessage());
        }
    }
}
