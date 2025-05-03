package school.faang.bjs2_74556;

/**
 * Задача "Асинхронность и Future"
 */
public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();

        System.out.println("Done");
    }
}
