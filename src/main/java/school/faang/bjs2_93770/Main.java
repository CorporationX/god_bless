package school.faang.bjs2_93770;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Donation>> allDonations = new ArrayList<>();

        allDonations.add(organization.addDonation(new Donation(1000)));
        allDonations.add(organization.addDonation(new Donation(500.50)));
        allDonations.add(organization.addDonation(new Donation(100)));
        allDonations.add(organization.addDonation(new Donation(10000.10)));

        CompletableFuture.allOf(allDonations.toArray(new CompletableFuture[0]))
                .thenRun(organization::printTotalAmount);

        organization.shutdownCorrectly();
    }
}
