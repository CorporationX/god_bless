package school.faang;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Nariman",24,"New York","Google");

        System.out.println(user1.getAddress() + " " + user1.getJob());
        User user2 = new User("Era",21,"Almaty","No");
        System.out.println(user2.getAddress() + " " + user2.getJob());
    }
}
