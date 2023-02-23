import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player();
        Monster monster = null;
        boolean End = false;
        boolean StatusCreated = false;
        while (!StatusCreated) {
            StatusCreated = player.CreateCreature();
        }
        StatusCreated = false;
        while (!StatusCreated) {
            monster = new Monster();
            StatusCreated = monster.CreateCreature();
        }
        while (!End) {
            monster.AttackEnemy(player);
            if(player.MaxHP/2> player.getHP() && player.getHP()>0)
                player.RestoreHP();
            if (player.DeadCreature()){
                System.out.println("Конец игры,монстр победил");
                End=true;
                break;
            }
            player.AttackEnemy(monster);
            if(monster.DeadCreature()){
                System.out.println("Конец игры,игрок победил");
                End = true;
                break;
            }
        }
    }

}