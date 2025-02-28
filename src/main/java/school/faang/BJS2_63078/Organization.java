package school.faang.BJS2_63078;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private static final AtomicInteger balance = new AtomicInteger(0);

    private static void addDonation(int amount) {
        Organization.addDonation(amount); // Добавляем пожертвование
        Organization.getBalance();
    }


    private static void getBalance() {
        balance.get();
    }
}

