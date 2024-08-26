package faang.school.godbless;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Knight arthurDayne = new Knight("Arthur Dayne",new ArrayList<>());
        Knight barristanSelmy = new Knight("Barristan Selmy",new ArrayList<>());

        arthurDayne.addtrial(new Trial("Arthur Dayne","Trial of strength"));
        arthurDayne.addtrial(new Trial("Arthur Dayne","Trial of swordsmanship"));

        barristanSelmy.addtrial(new Trial(barristanSelmy.getName(), "Trial of swordsmanship"));
        barristanSelmy.addtrial(new Trial(barristanSelmy.getName(), "Trial of of archery"));

        arthurDayne.startTrial();
        barristanSelmy.startTrial();
    }
}