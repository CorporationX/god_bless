package school.faang.multithreading.asynchronism.asynch.and.future;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
