package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
