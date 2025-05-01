package school.faang.bjs2_76380;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnauthorizedModificationException extends SecurityException {
    public UnauthorizedModificationException() {
        super("You cannot edit or delete someone else's comment");
        log.error("You cannot edit or delete someone else's comment");
    }
}
