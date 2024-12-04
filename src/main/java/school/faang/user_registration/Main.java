package school.faang.user_registration;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {

            String name = "Jack";
            int age = 18;
            String job = "Google";
            String address = "Big street";

            switch (i) {
                case 1:
                    name = "";
                    break;
                case 2:
                    age = 17;
                    break;
                case 3:
                    job = "other job";
                    break;
                case 4:
                    address = "other street";
                    break;
            }
            User user = new User(name, age, job, address);
        }
    }
}
