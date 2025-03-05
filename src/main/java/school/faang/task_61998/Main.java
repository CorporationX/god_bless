package school.faang.task_61998;

public class Main {
    public static void main(String[] args) throws PaymentProcessingException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
