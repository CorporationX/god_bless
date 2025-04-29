package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolIsEmptyException extends RuntimeException {
    public SchoolIsEmptyException() {
        super("No students at the school");
        log.error("No students at the school");
    }
}
