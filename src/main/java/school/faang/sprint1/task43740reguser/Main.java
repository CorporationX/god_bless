package school.faang.sprint1.task43740reguser;


public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            User user = new User("Maxim", 0, "Google", "London");
            System.out.println(user.getName());
        } catch (Exception e){
            System.out.println("Ошибка");
        }
    }
}
