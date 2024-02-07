package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        //UserGroup.groupUsers();
        try {
            App user = new App("", -1, "Developer", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
