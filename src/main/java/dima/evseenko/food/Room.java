package dima.evseenko.food;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> foods = new ArrayList<>();
}
