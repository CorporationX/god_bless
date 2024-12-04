package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("Ivan", 18, "Google", "London");
            user.setAge(5);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}