public class Player extends Creature {
    private int Potion = 3;

    public Player() {

    }

    public void RestoreHP() {
        int hp = getHP();
        setHP(Math.min((MaxHP / 2) + hp, MaxHP));
        System.out.println(" Использовано зелье " + MaxHP);
        Potion--;
    }
}