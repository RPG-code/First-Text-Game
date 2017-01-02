import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Item
{

    public Weapon()
    {
        Random rgen = new Random();
        name = new ArrayList<>();
        name.add("Dagger");
        name.add("Dagger");
        name.add("Dagger");
        name.add("Dagger");
        name.add("Sword");
        name.add("Sword");
        name.add("Sword");
        name.add("Axe");
        name.add("Axe");
        name.add("Pistol");
        name.add("Shotgun");
        item  = rgen.nextInt(11);
        if(item == 0 || item == 1 || item == 2 || item == 3){
            weight = 1 + rgen.nextInt(3);
            slashAttack = 2 + weight;
            pierceAttack = 0;
            description = "A small, short slashing weapon.";
        }
        if(item == 4 || item == 5 || item == 6){
            weight = 2 + rgen.nextInt(4);
            slashAttack = 3 + weight;
            pierceAttack = 0;
            description = "A long slashing weapon.";
        }
        if(item == 7 || item == 8){
            weight = 4 + rgen.nextInt(6);
            slashAttack = 4 + weight;
            pierceAttack = 0;
            description = "A heavy slashing weapon.";
        }
        if(item == 9){
            weight = 1 + rgen.nextInt(3);
            pierceAttack = 5 + rgen.nextInt(3);
            slashAttack = 0;
            description = "A small piercing weapon.";
        }
        if(item == 10){
            weight = 3 + rgen.nextInt(4);
            pierceAttack = 7 + rgen.nextInt(4);
            slashAttack = 0;
            description = "A large piercing weapon.";
        }
    }

}
