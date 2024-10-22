package school.BJS2_40118;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    List<Donation> listOfDonations = new ArrayList<>();

    public void addDonation(Donation donation) {
        atomicInteger.addAndGet(donation.getAmount());
        synchronized(listOfDonations) {
            listOfDonations.add(donation);
        }
    }

    public void printDonations() {
        System.out.println("Cумма доната равна в итоге: " + atomicInteger.get());
        listOfDonations.forEach(System.out::println);
    }


}
