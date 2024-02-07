package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        try {
            App user = new App("Behzod", 20, "Uber", "London"); //не понял почему кидает Error: Address is not in the VALID_ADDRESSES если London есть в Сете
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
