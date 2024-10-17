package org.example.service.theyWereVeryNiceButExtremelyPoor;

import org.example.model.theyWereVeryNiceButExtremelyPoor.Chore;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            WeasleyFamily.addChore(new Chore(Integer.toString(i)));
        }

        WeasleyFamily.gettingStartTheWorks(WeasleyFamily.works);
    }
}
