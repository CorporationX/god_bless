package lru_cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@lombok.Data
@RequiredArgsConstructor
@Getter
public class Data {
    private final int id;
    private final int value;
    @Setter
    private LocalTime timestamp;



}
