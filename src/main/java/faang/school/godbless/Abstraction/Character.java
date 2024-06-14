package faang.school.godbless.Abstraction;
public abstract class Character {
    int healf = 100;
    String name;
    int sila, lovkost, intelect;

    public Character(String name) {
        this.name = name;
    }

    /* public Character(int sila, int lovkost, int intelect) {  // не вижу смысла в этом конструкторе.
        this.sila = sila;                                    // когда переопределю конструктор под воина и лучника
        this.lovkost = lovkost;                              // в теле конструктора хоть и укажу заданные значения
        this.intelect = intelect;                       //для силы и т.д все равно они изменяться когда создам обьект
    } */                                   //Воина или Лучника, потому что будет явное указание переменных
                                         // например Warrior war10 = new Warrior (3 , 5 ,10 );
    abstract void attack(Character charter);  // и тогда несмотря на заданные параметры силы = 10
                                             //силу в итоге будет 3
}

class Warrior extends Character {
    Warrior(String name) {              //задаю конструктор воину где ввожу имя воина , а его данные
        super (name);                   // сила ловкость интелект будут всегда заданны стандартно
        sila=10;
        lovkost=5;
        intelect=3;
    }

    void attack(Character character) {               //метод атаки для воина
        character.healf = character.healf - sila;
    }
}

class Archer extends Character {
    Archer(String name){                           //аналогичный конструктор лучника
        super(name);
        sila=3;
        lovkost=10;
        intelect=5;
    }

    void attack(Character character) {                    //метод атаки для лучника
        character.healf = character.healf - lovkost;
    }
}

class Test  {

    public static void main(String[] args) {
        Warrior war1 = new Warrior("voin");        //создаю персонажей с именами воин и лучник
        Archer archer1 = new Archer("luchnik");    //с заданными параметрами под каждого в конструкторе


        war1.attack(archer1);                      //атакую воином лучника
        war1.attack(archer1);                      //вторая атака воина
        archer1.attack(war1);                      //лучник атакует воина
        System.out.println(archer1.healf);
        System.out.println(war1.healf);
        System.out.println(war1.name);

    }
}

