package school.faang.bjs2_68174;

public class Main {
    public static void main(String[] args) {
        User ivan = createUser("Ivan", 30, "uber", "London");
        User nonameUser = createUser("", 10, "Uber", "Amsterdam");
        User stepan = createUser("Stepan", 10, "Uber", "London");
        User john = createUser("John", 41, "Yahoo!", "Berlin");
    }

    public static User createUser(String name, Integer age, String job, String address) {
        User user = null;
        try {
            user = new User(name, age, job, address);
        } catch (RuntimeException e) {
            System.out.printf("Ошибка создания пользователя: %s\n", e);
        }
        return user;
    }
}
