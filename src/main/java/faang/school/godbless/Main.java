package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        try {
            App user = new App("Behzod", 20, "Uber", "Amsterdam"); //не понял почему кидает Error: Address is not in the VALID_ADDRESSES если London есть в Сете
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getWork());
            System.out.println(user.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
