package game.of.trone;

import java.util.Map;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public static void addFamily(String familyName, Map<String,House> test) {
        test.put(familyName, new House(familyName, familyName + "Герб"));
    }
    public static void deleteFamily(String familyName, Map<String,House> test){
        test.remove(familyName);
    }
    public static void searchFamily(String familyName, Map<String,House> test){
        if(test.containsKey(familyName)){
            System.out.println(test.get(familyName).sigil);
        }
    }
    public static void allHouse(Map<String,House> test){
        for (Map.Entry<String,House> pair : test.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue().sigil);
        }

    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }
}
