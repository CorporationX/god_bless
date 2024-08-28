package faang.school.godbless.BJS2_25231;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.DoubleAdder;

@Slf4j
public record Organization(DoubleAdder balance) {

    public void addDonation(Donation donation){
        log.info("Adding {} USD to the balance by tranfer №{}", donation.amount(), donation.id());
        balance.add(donation.amount());
    }

    public double getCurrentBalance(){
        return balance.sum();
    }
}
