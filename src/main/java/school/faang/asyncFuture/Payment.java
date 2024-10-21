package school.faang.asyncFuture;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Payment {
    private final int id;
    private final String type;
    private final int moneyAmount;

    public static List<Payment> generatePayments(int end) {
        Random random = new Random();
        List<Payment> payments = new ArrayList<>();
        List<String> types = List.of("Shopping", "Bank loans", "Entertainment");
        for (int i = 0; i < end; i++) {
            payments.add(new Payment(i, types.get(random.nextInt(types.size())), random.nextInt(100_000)));
        }
        return payments;
    }
}