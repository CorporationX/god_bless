package BJS2_9319;

public class SpellCaster {

   public void cast ( String name, SpellAction<String> act) {
       String result = act.action(name);
       System.out.println(result);

   }
}
