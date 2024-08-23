package com.multithreading.homm;

import com.multithreading.homm.Model.Unit;
import lombok.Getter;

@Getter
public class Calculator extends Thread {
    private int power;
    private Unit unit;

    public Calculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
