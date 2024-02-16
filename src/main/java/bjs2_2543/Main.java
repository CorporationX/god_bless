package bjs2_2543;

public class Main {
    public static void main(String[] args) {
        Kingdom houses = new Kingdom();
        houses.add("Baratheon", "A crowned stag black on a golden field");
        houses.add("Arryn", "A sky-blue falcon soaring against a white moon, on sky-blue");
        houses.add("Tully", "a leaping trout, silver, against a rippling blue-and-red field");
        houses.add("Stark", "A running grey direwolf, on an ice-white field");

        houses.delete("Baratheon");
        houses.getAll();
    }
}
