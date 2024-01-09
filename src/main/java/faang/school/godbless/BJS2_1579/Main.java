package faang.school.godbless.BJS2_1579;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                double donationAmount = Math.random() * 100;

                Donation donation = new Donation(donationAmount);

                organization.addDonation(donation);

                System.out.println("Donation added. ID: " + donation.getId() +
                        ", Amount: $" + donation.getAmount() +
                        ", Total Balance: $" + organization.getBalance());
            });

            thread.start();
        }
    }
}