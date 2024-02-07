package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        //UserGroup.groupUsers();
        try {
            App user = new App("Behzod", 20, "Uber", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
