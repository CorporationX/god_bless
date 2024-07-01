package faang.school.godbless.sprint3.asyncAndFuture;

public class Main {

    public static void main(String[] args) {
        try {
            MasterCardService masterCardService = new MasterCardService(ExecutorServiceUtil.getExecutorService());

            masterCardService.doAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
