package school.faang.multithreading.stripe;

public class Main {

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();

        service.doAll();
    }
}
