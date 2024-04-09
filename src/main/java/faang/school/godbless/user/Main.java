package faang.school.godbless.user;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Vasya", 20, "Google", "New York");
            System.out.println(user1);
            User user2 = new User("Vova", 16, "Get", "Moscow");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
