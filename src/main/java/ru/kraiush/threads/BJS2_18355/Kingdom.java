package ru.kraiush.threads.BJS2_18355;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Kingdom {

    private String name;

    @Override
    public String toString() {
        return "Kingdom {" + name + "}";
    }
}
