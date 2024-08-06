package com.map.lrucache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@lombok.Data
@Getter
@ToString
@Setter


public class Data {
    private int id;
    private int value;
    private String timestamp;

    public Data(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && value == data.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
