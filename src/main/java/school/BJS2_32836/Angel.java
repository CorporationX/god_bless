package school.BJS2_32836;

public class Angel extends Creature {

    public Angel(String name) {
        super(name, 1, 45, 10, 12,500);
    }

    public int getDamage() {
        if (this.health < 30) {
            //странные нынче ангелы) у них начинается вампиризм при незком хп =)
            this.health += 20;
            return attack * 3 + (speed * 2);
        }
        return attack + (int) (Math.random() * speed);
    }
}
