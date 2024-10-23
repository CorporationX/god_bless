package school.faang.Multithreading.sprint_4.AsynchronyFuture;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
