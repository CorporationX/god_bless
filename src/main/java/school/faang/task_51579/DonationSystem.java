package school.faang.task_51579;

public class DonationSystem {
    public static void main(String[] args) {
        Organization organization = new Organization();

        Runnable volunteer1 = () -> {
            for (int i = 0; i < 5; i++) {
                organization.addDonation(new Donation(i, 100.0));
            }
        };

        Runnable volunteer2 = () -> {
            for (int i = 5; i < 10; i++) {
                organization.addDonation(new Donation(i, 200.0));
            }
        };

        Thread thread1 = new Thread(volunteer1);
        Thread thread2 = new Thread(volunteer2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + organization.getBalance());
    }
}
