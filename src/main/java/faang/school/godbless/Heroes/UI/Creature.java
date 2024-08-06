package faang.school.godbless.Heroes.UI;


public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int protection;
    protected int speed;
    protected int health;

    public Creature(String name, int level, int attack, int protection, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        health = 100;
    }

    //метод атаки
    public void attack(Creature creature){
        //возможность уклониться засчет ловкости:
        //если случайно выпавшее число от 0 до 100 меньше, чем значение скорости,
        //то количество наносимого урона сокращается до 5% от начального числа
        if((int)(Math.random()*100)<creature.speed){
            creature.health-=(attack-creature.protection/3)/20;
            //механизм атаки:
            //кол-во наносимого урона равно количеству атаки у атакующего
            //за вычетом трети защиты у защищающегося
        }else {
            creature.health-=(attack-creature.protection/3);
        }
    }
}
