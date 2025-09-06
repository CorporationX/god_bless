package school.faang.bjs2_85527;


public class Main {

    public static void main(String[] args) {
        try {

            User user1 = new User("Vitali", 35, "Uber", "Madrid");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}