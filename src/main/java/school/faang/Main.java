package school.faang;

public class Main {
    public static void main(String[] args) {
        User john = new User("john", 25, "Uber", "Amsterdam");
        System.out.println(john);

        User anna = new User("anna", 23, "Java", "Tashkent");
        System.out.println(anna);
    }
}
