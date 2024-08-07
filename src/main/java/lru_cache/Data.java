package lru_cache;

import lombok.AllArgsConstructor;

import java.time.LocalTime;

@lombok.Data
@AllArgsConstructor
public class Data {
    private int id;
    private int value;
    private LocalTime timestamp;
}
