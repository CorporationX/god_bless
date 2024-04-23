package faang.school.godbless.BJS2_5965;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        try {

            masterCardService.doAll();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("exception: " + e);
        }
    }
}
