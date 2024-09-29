package ru.kraiush.threads.BJS2_18339;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
