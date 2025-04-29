package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class SchoolNotFoundException extends NoSuchElementException {
    public SchoolNotFoundException() {
        super("School not found");
        log.error("School not found");
    }
}
