package bjs2_31598;

public class Main {
    public static void main(String[] args) {
        String[] names = {"    ", "Bob", "John", "JD", "Eliot"};
        Integer[] ages = {25, 15, 29, 31, 31};
        String[] jobs = {"Google", "Uber", "frontend", "Amazon", "Uber"};
        String[] addresses = {"London", "New York", "Amsterdam", "address", "London"};

        for (int i = 0; i < 5; i++) {
            try {
                User user = new User(names[i], ages[i], jobs[i], addresses[i]);
                System.out.println("Created :" + user);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
