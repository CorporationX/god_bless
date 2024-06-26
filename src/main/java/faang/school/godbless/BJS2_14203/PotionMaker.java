package faang.school.godbless.BJS2_14203;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PotionMaker {
    public static void main(String[] args) {
        Map<String,Integer> paralysisDamageHealthIngredients = new HashMap<>();
        Map<String,Integer> ravageMagickaIngredients = new HashMap<>();
        Map<String,Integer> cureDiseaseIngredients = new HashMap<>();
        paralysisDamageHealthIngredients = Map.of("Canis Root",2,"Imp Stool",10,"River Betty",5);
        ravageMagickaIngredients = Map.of("Orange Dartwing",15,"Red Mountain Flower",16);
        cureDiseaseIngredients = Map.of("Vampire Dust",8,"Charred Skeever Hide",27);
        Potion paralysisDamageHealth = new Potion("Paralysis and Damage Health", paralysisDamageHealthIngredients);
        Potion ravageMagicka = new Potion("Ravage Magicka", ravageMagickaIngredients);
        Potion cureDisease = new Potion("Cure Disease", cureDiseaseIngredients);
        List<Potion> potions = Arrays.asList(paralysisDamageHealth,ravageMagicka,cureDisease);

    }

    public static void gatherIngredients(Potion potion){

    }

}
