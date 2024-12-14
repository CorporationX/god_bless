package org.example.model.tomAndJerry;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Room {
    private List<Food> foods;

    public boolean hasFoods() {
        return !foods.isEmpty();
    }
}
