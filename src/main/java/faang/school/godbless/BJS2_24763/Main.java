package faang.school.godbless.BJS2_24763;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    private static final MasterCardService MASTER_CARD_SERVICE = new MasterCardService();

    public static void main(String[] args) {
        MASTER_CARD_SERVICE.doAll();
    }

}
