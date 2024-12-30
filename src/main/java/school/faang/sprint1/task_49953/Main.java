package school.faang.sprint1.task_49953;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService server = new MasterCardService();
        server.addAll();
    }
}
