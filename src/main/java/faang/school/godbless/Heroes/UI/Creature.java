package faang.school.godbless.Heroes.UI;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode
public abstract class Creature {
    @Getter
    protected String name;
    @NonNull
    protected int level;
    @NonNull
    protected int damage;
    @NonNull
    protected int protection;
    @NonNull
    protected int speed;
    @Getter
    @Setter
    protected int count = 0;

    public Creature(int level, int damage, int protection, int speed, int count) {
        this.level = level;
        this.damage = damage*(level);
        this.protection = protection*(level);
        this.speed = speed*(level);
        this.count += count;
    }

    //метод атаки
    public void attack(Creature creature) {
        //возможность уклониться засчет ловкости и защиты:
        //если случайно выпавшее число от 0 до 100 + дамаг
        //меньше , чем значение скорости + треть дамага,
        //то юнит не умирает
        if ((int) (Math.random() * 100 + damage) < (creature.speed + creature.protection/3)) {
            creature.count--;
        }
        if (creature.count<=0 || count<=0){
            throw new IllegalArgumentException();//если несуществующие мобы бьют/защищаются
        }
    }
}
