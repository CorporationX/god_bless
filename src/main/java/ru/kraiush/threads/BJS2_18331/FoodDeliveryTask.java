package ru.kraiush.threads.BJS2_18331;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FoodDeliveryTask {

    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character) {
        this.character = character;
    }




}
