package school.faang.registerUsers;

public class Main {

    public static void main(String[] args) {
        try {
            User userRegister = new User.Builder()
                    .setName("Jon")
                    .setAge(20)
                    .setWork("Uber")
                    .setAddress("New York")
                    .build();
            System.out.println(userRegister);
        } catch (IllegalArgumentException exception) {
            System.out.println("Неверные данные");
        }
    }
}
