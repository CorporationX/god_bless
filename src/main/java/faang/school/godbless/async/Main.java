package faang.school.godbless.async;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterClassService MCService = new MasterClassService();

        try {
            MCService.doAll();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
