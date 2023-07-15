package faang.school.godbless.kxnvg.animalsupport;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Organization freeAnimal = new Organization();
        List<Donation> donations = getRandomDonations();

        ExecutorService service = Executors.newFixedThreadPool(10);

        donations.forEach(donation -> service.execute(() -> freeAnimal.addDonation(donation)));

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Общая сумма доннаций составила: " + freeAnimal.getBalance().get());
    }

    private static List<Donation> getRandomDonations() {
        List<Donation> donations = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            donations.add(new Donation(i, new Random().nextInt(5000)));
        }
        return donations;
    }

    private static List<Donation> getEstablishedDonations(int sum) {
        List<Donation> donations = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            donations.add(new Donation(i, sum));
        }
        return donations;
    }
}
