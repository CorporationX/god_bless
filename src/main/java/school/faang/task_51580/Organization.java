package school.faang.task_51580;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

@Getter
@Slf4j
public class Organization {

    private final DoubleAdder balance = new DoubleAdder();
    private final List<Donation> donations = Collections.synchronizedList(new ArrayList<>());
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public void addDonation(Donation donation) {
        balance.add(donation.getAmount());
        donations.add(donation);
    }

    public void donationsReport() {
        log.info("Генерация отчета...");
        double total = balance.sum();
        double average = donations.stream().mapToDouble(Donation::getAmount).average().orElse(0.0);
        double max = donations.stream().mapToDouble(Donation::getAmount).max().orElse(0.0);
        double min = donations.stream().mapToDouble(Donation::getAmount).min().orElse(0.0);

        log.info("Общая сумма: {} $, Среднее значение: {} $, Максимум: {} $, Минимум: {} $",
                decimalFormat.format(total), decimalFormat.format(average),
                decimalFormat.format(max), decimalFormat.format(min));
    }
}