package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final MasterCardService service = new MasterCardService();

    public static void main(String[] args) {
        service.doAll();
    }
}
