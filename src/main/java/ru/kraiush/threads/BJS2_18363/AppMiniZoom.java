package ru.kraiush.threads.BJS2_18363;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AppMiniZoom {

    public static void main(String[] args) {

        String[] memberNames = {"Sharon", "Lewis", "Bridget", "Jessica", "Elvis"};

        CountDownLatch latch = new CountDownLatch(5);

        List<Thread> listParticipants= new ArrayList<>();

        for (int i = 0; i < memberNames.length; i++) {
            listParticipants.add(new Participant(memberNames[i], latch, "PARTICIPANT-" + i));
        }

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        Thread conference= new Conference(listParticipants, latch, "CONFERENCE");
        conference.start();
    }
}
