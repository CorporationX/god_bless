package school.faang.task_51569;

import school.faang.exception.CheckException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private final DoubleAdder totalAmount = new DoubleAdder();

    public CompletableFuture<Void> addDonation(Donation donation, ExecutorService executorService) {
        if (donation == null) {
            throw new CheckException("donation");
        }
        return CompletableFuture.runAsync(() -> this.totalAmount.add(donation.getAmount()), executorService);
    }

    public double getTotalAmount() {
        return this.totalAmount.sum();
    }
}
