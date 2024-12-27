package derschrank.sprint03.task11.bjstwo_49559;

public class TamagotchiVlad implements  TamagotchiInterface {

    private final String name;
    private int hunger;
    private int tiredness;
    private int filthy;
    private int boredom;


    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        hunger = 0;
        tiredness++;
        boredom++;
        filthy++;
        filthy++;
        printMsg("eats");
    }

    public synchronized void play() {
        boredom = 0;
        tiredness++;
        tiredness++;
        tiredness++;
        filthy++;
        filthy++;
        filthy++;
        printMsg("plays");
    }

    public synchronized void clean() {
        filthy = 0;
        tiredness++;
        hunger++;
        boredom++;
        printMsg("cleans");
    }

    public synchronized void sleep() {
        tiredness = 0;
        hunger++;
        hunger++;
        hunger++;
        boredom++;
        printMsg("sleeps");
    }

    public synchronized void status() {
        System.out.print(name + " has hunger: " + hunger);
        System.out.print(", has tiredness: " + tiredness);
        System.out.print(", has filthy: " + filthy);
        System.out.println(", has boredom: " + boredom);
    }


    private void printMsg(String msg) {
        System.out.printf("%s -> %s %s%n",
                Thread.currentThread().getName(),
                name,
                msg);
    }

    @Override
    public String toString() {
        return name;
    }
}