package org.example.model.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private double experience;
}
