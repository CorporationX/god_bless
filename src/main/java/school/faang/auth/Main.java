package school.faang.auth;

public class Main {

    public static void main(String[] args) {
        addAndPrintUser("Petr", 1984, 6, 12, "Hamburg", "Amazon");
        addAndPrintUser("Ivan", 1900, 6, 12, "London", "Uber");
        addAndPrintUser("Ivan", 1984, 6, 12, "London", "Uber");
        addAndPrintUser("Ivan", 1984, 6, 12, " ", "Uber");
        addAndPrintUser("Ivan", 2020, 6, 12, "London", "Uber");
        addAndPrintUser("Lisa", 1984, 6, 12, "Berlin", "Uber");
        addAndPrintUser("Lisa", null, 6, 12, "Hamburg", "Uber");
        addAndPrintUser(null, 1984, 6, 12, "Hamburg", "Uber");
    }

    private static void addAndPrintUser(String name, Integer year, Integer month, Integer day,
                                        String address, String job) {
        try {
            System.out.println(new User(name, year, month, day, address, job));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
