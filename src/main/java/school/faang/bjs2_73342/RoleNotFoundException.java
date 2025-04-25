package school.faang.bjs2_73342;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class RoleNotFoundException extends NoSuchElementException {
    public RoleNotFoundException() {
        super("Role not found");
        log.error("Role not found");
    }
}
