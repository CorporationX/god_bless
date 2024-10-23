package school.faang.stripe;

public class Main {

    public static void main(String[] args) {
        try (MasterCardService service = new MasterCardService()) {
            service.doAll();
        }
    }
}
