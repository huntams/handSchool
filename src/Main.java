

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Monster monster = null;
        boolean StatusCreated = false;
        while (!StatusCreated) {//Создание игрока
            StatusCreated = player.CreateCreature();
        }
        StatusCreated = false;
        while (!StatusCreated) {//Создание монстра
            monster = new Monster();
            StatusCreated = monster.CreateCreature();
        }
        while (true) {//Пока одно из существ не умрёт
            monster.AttackEnemy(player);
            if (player.getMaxHP() / 2 > player.getHP() && player.getHP() > 0)//Восстановление здоровье
                player.RestoreHP();
            if (player.DeadCreature()) {
                System.out.println("Конец игры,монстр победил");
                break;
            }
            player.AttackEnemy(monster);
            if (monster.DeadCreature()) {
                System.out.println("Конец игры,игрок победил");
                break;
            }
        }
    }

}