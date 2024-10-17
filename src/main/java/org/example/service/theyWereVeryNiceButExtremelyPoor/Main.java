package org.example.service.theyWereVeryNiceButExtremelyPoor;

import org.example.model.theyWereVeryNiceButExtremelyPoor.Chore;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            weasleyFamily.addChore(new Chore(Integer.toString(i)));
        }

        weasleyFamily.gettingStartTheWorks(weasleyFamily.getWorks());
    }
}
