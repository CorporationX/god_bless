package ru.kraiush.threads.BJS2_18339;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AppSupercow {

    public static void main(String[] args) {

        Queue<Member> currentPlayers = new LinkedList<>();
        int maxPlayers = 2;
        int maxMembers = 3;

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        startBattle(currentPlayers, maxMembers, new Boss(currentPlayers, maxPlayers));
    }

    static void startBattle(Queue<Member> currentPlayers, int maxMembers, Boss boss) {

        for (int i = 0; i < 15; i++) {
            Thread player = new Player(currentPlayers, maxMembers, new Member(getPlayerName()));
            player.start();
        }
        boss.start();
    }

    public static String getPlayerName() {
        String[] memberNames = {"Peter", "Sharon", "Maggie", "Lewis", "Steve", "Bridget", "Jessica", "Om", "Sikha", "Elvis"};
        return memberNames[new Random().nextInt(memberNames.length)];
    }
}
