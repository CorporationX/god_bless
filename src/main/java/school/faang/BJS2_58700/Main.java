package school.faang.BJS2_58700;

public class Main {
    public static void main(String[] args) {
        try {
            User userOne = new User("Uber", 8, "Google", "Amsterdam");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }
}
