package school.faang;

public class Main {
    public static void main(String[] args) {
        checkUser("Alex", 20, "Google", "London");
        checkUser("", 20, "Google", "London");
        checkUser(null, 20, "Google", "London");
        checkUser("Alex", 10, "Google", "London");
        checkUser("Alex", 20, "Burger King", "London");
        checkUser("Alex", 20, "Google", "USA");

    }

    public static void checkUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.printf("Пользователь (%s, %d, %s, %s) был успешно создан\n",
                    user.getName(), user.getAge(), user.getJob(), user.getAddress());
        } catch (Exception e) {
            System.out.printf("Ошибка при создании пользователя (%s, %d, %s, %s): %s\n",
                    name, age, job, address, e.getMessage());
        }
    }

}
