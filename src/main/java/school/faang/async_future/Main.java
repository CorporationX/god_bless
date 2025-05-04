package school.faang.async_future;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        final int paymentAmount = scanner.nextInt();
        System.out.print("Enter amount of data to analyze: ");
        final int analyticsAmount = scanner.nextInt();
        scanner.close();

        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll(paymentAmount, analyticsAmount);
    }
}
