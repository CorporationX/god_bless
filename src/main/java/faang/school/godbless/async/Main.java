package faang.school.godbless.async;

public class Main {

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        Stripe stripe = new Stripe(masterCardService);

        stripe.doAll();
    }
}
