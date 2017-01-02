import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy
{
    private ArrayList<String> name;
    private int speed;
    private int energy;
    private int slashAttack;
    private int pierceAttack;
    private int slashDefense;
    private int pierceDefense;
    private int enemy;
    private Player player;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(Player player)
    {
        Random rgen = new Random();
        name = new ArrayList<>();
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Zombie");
        name.add("Werewolf");
        name.add("Werewolf");
        name.add("Werewolf");
        name.add("Vampire");
        name.add("Vampire");
        name.add("Vampire");
        name.add("Demon");
        name.add("Demon");
        name.add("Devil");
        enemy = rgen.nextInt(17);
        if(enemy <= 7){
            speed = 3 + rgen.nextInt(3);
            energy = 5 + rgen.nextInt(10);
            pierceAttack = 0;
            slashAttack = 5 + rgen.nextInt(5);
            pierceDefense = 1 + rgen.nextInt(3);
            slashDefense = 1 + rgen.nextInt(3);
        }else if(enemy > 7 && enemy <= 10){
            speed = 8 + rgen.nextInt(8);
            energy = 20 + rgen.nextInt(10);
            pierceAttack = 0;
            slashAttack = 10 + rgen.nextInt(10);
            pierceDefense = 3 + rgen.nextInt(3);
            slashDefense = 4 + rgen.nextInt(5);
        }else if(enemy > 10 && enemy <= 13){
            speed = 10 + rgen.nextInt(10);
            energy = 10 + rgen.nextInt(15);
            pierceAttack = 0;
            slashAttack = 6 + rgen.nextInt(12);
            pierceDefense = 4 + rgen.nextInt(5);
            slashDefense = 3 + rgen.nextInt(3);
        }else if(enemy > 13 && enemy <= 15){
            speed = 15 + rgen.nextInt(10);
            energy = 30 + rgen.nextInt(10);
            pierceAttack = 10 + rgen.nextInt(8);
            slashAttack = 0;
            pierceDefense = 5 + rgen.nextInt(3);
            slashDefense = 5 + rgen.nextInt(3);
        }else if(enemy == 16){
            speed = 30;
            energy = 50 + rgen.nextInt(20);
            pierceAttack = 15 + rgen.nextInt(10);
            slashAttack = 0;
            pierceDefense = 7 + rgen.nextInt(3);
            slashDefense = 7 + rgen.nextInt(3);
        }
        this.player = player;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName(){
        return name.get(enemy);
    }

    public int getSpeed(){
        return speed;
    }

    public int getEnergy(){
        return energy;
    }

    public int getPierceAttack(){
        return pierceAttack;
    }

    public int getSlashAttack(){
        return slashAttack;
    }

    public int getPierceDefense(){
        return pierceDefense;
    }

    public int getSlashDefense(){
        return slashDefense;
    }

    public int attack(){
        if(getPierceAttack() == 0){
            return getSlashAttack();
        }
        if(getSlashAttack() == 0){
            return getPierceAttack();
        }
        return 0;
    }

    public void takeDamage(int damage){
        if(player.getWeapon() == null){
            return;
        }
        if(player.getWeapon().getPierceAttack() == 0){
            if(damage - getSlashDefense() <= 0){
                return;
            }else{
                energy -= (damage - getSlashDefense());
                return;
            }
        }
        if(player.getWeapon().getSlashAttack() == 0){
            if(damage - getPierceDefense() <=  0){
                return;
            }else{
                energy -= (damage - getPierceDefense());
                return;
            }
        }
    }
}
