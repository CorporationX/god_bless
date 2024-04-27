package faang.school.godbless.animal_support;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation){
        balance.addAndGet(donation.getAmount());
        System.out.println("Пожертвование от Id: " + donation.getId()
                + ", в размере: " + donation.getAmount() + " руб. добавлено на общий счёт оргазиции");
    }
}
