package Async_1;

public class Application {
    public static void main(String[] args) {
        MasterCardService.doAll();
        MasterCardService.getExecutor().shutdown();
    }
}
