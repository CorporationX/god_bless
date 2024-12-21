package school.faang.sprint4.task50070;

import school.faang.sprint4.task50070.service.MasterCardService;

public class paymentApp {
    public static void main(String[] args) {
        MasterCardService paymentService = new MasterCardService();
        paymentService.doAll();
    }


}
