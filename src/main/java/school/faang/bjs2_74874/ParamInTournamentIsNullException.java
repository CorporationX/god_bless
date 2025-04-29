package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParamInTournamentIsNullException extends RuntimeException {
    public ParamInTournamentIsNullException() {
        super("Param in tournament is null");
        log.error("Param in tournament is null");
    }
}
