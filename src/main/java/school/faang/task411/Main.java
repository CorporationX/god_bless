package school.faang.task411;

import school.faang.task411.card.MasterCardService;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        MasterCardService mcs = new MasterCardService();
        mcs.doAll();
    }
}
