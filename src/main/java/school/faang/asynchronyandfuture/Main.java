package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
