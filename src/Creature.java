import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Creature {
    public int MaxHP;
    private String Name;

    private int HP, MinDamage, MaxDamage;
    private final int Attack, Protection;
    Random random = new Random();

    public String getName() {
        return Name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Creature() {
        this.Attack = random.nextInt(1, 20);
        this.Protection = random.nextInt(1, 20);
        MaxHP = HP;
    }

    public Creature(int HP, int MinDamage, int MaxDamage) {
        Attack = random.nextInt(1, 20);
        Protection = random.nextInt(1, 20);
        this.HP = HP;
        this.MinDamage = MinDamage;
        this.MaxDamage = MaxDamage;
    }

    public boolean DeadCreature() {//Возвращает true, если здоровье существа меньше 0
        return getHP() <= 0;
    }

    public boolean CreateCreature() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите имя:  ");
            Name = reader.readLine();
            System.out.print("Введите количество здоровья:  ");
            HP = Integer.parseInt(reader.readLine());
            System.out.println("Введите минимальный урон:  ");
            MinDamage = Integer.parseInt(reader.readLine());
            System.out.println("Введите максимальный урон(Больше чем минимальный урон):  ");
            MaxDamage = Integer.parseInt(reader.readLine());
            int rand = random.nextInt(MinDamage, MaxDamage);
            MaxHP= HP;
            return true;
        } catch (Exception e) {
            System.out.println("Введены не корректные данные");
        }
        return false;

    }

    public void AttackEnemy(Creature creature) {//Отнимаем здоровье противника по алгоритму
        System.out.println("Здоровье " + creature.Name + " до получения урона: " + creature.HP);
        int ModAttack = Attack - creature.Protection + 1;//ModAttack- количество возможных бросков кубика
        int Dice = 0;
        if (ModAttack <= 0)
            ModAttack = 1;
        for (int i = 0; i < ModAttack; i++) {
            Dice = random.nextInt(1, 6);
            if (Dice == 5 || Dice == 6)
                creature.HP -= random.nextInt(MinDamage, MaxDamage);
        }
        System.out.println("Здоровье " + creature.Name + "  после получения урона: " + creature.HP);
    }
}
