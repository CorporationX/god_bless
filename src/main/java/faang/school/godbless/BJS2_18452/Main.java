package faang.school.godbless.BJS2_18452;

public class Main {
    private static void nonNullNameValidation() {
        try {
            new User(null, 25, "Google", "Amsterdam");
        } catch (IllegalArgumentException exception) {
            System.out.println("Null name!");
        }
    }

    private static void ageValidation() {
        try {
            new User("Oleg", 12, "Google", "Amsterdam");
        } catch (IllegalArgumentException exception) {
            System.out.println("Wrong age!");
        }
    }

    private static void workPlaceValidation() {
        try {
            new User("Oleg", 25, "Yandex", "Amsterdam");
        } catch (IllegalArgumentException exception) {
            System.out.println("Wrong work place!");
        }
    }

    private static void workAddressValidation() {
        try {
            new User("Oleg", 25, "Uber", "Moscow");
        } catch (IllegalArgumentException exception) {
            System.out.println("Wrong work address!");
        }
    }

    public static void main(String[] args) {
        nonNullNameValidation();
        ageValidation();
        workPlaceValidation();
        workAddressValidation();
    }
}
