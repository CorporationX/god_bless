package com.multithreading.homm;

import com.multithreading.homm.Model.Unit;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Army {
    private final List<Unit> listUnits = new ArrayList<>();
    private final List<Calculator> calculatorList = new ArrayList<>();
    private int total;

    public void addUnit(Unit unit) {
        Optional.ofNullable(unit).ifPresent(listUnits::add);
    }

    public Integer calculateTotalPower() throws InterruptedException {
        for (Unit unit : listUnits) {
            Calculator calculator = new Calculator(unit);
            calculatorList.add(calculator);
            calculator.start();

        }

        for (Calculator calculator : calculatorList) {
            calculator.join();
            total += calculator.getPower();
        }
        return total;
    }

}
