package faang.school.godbless.letsSupportAnimals;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        Thread t1 = new Thread(() -> organization.addDonation(new Donation(3, 1590)));
        Thread t2 = new Thread(() -> organization.addDonation(new Donation(4, 200)));
        Thread t3 = new Thread(() -> organization.addDonation(new Donation(5, 300)));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(organization.getTotalBalance());
    }
}
