package school.faang.futureworld;

public class Main {
    public static void main(String[] args) {
        try{
            User user1 = new User("Alexey", 23, "Google", "Amsterdam");
            System.out.println("Пользователь создан: " + user1);
            User user2 = new User("Bobby", 25, "Facebook", "Russia");
            System.out.println("Пользователь создан: " + user2);
            User user3 = new User("Bobby", 26, null, "New York");
            System.out.println("Пользователь создан: " + user3);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
