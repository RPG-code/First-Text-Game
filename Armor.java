import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Armor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armor extends Item
{
    // instance variables - replace the example below with your own
    
    public Armor()
    {
       Random rgen = new Random();
        name = new ArrayList<>();
        name.add("LeatherArmor");
        name.add("LeatherArmor");
        name.add("LeatherArmor");
        name.add("LeatherArmor");
        name.add("Chainmail");
        name.add("Chainmail");
        name.add("PlateArmor");
        name.add("Kevlar");
        item  = rgen.nextInt(8);
        if(item == 0 || item == 1 || item == 2 || item == 3){
            weight = 2 + rgen.nextInt(2);
            slashDefense = weight;
            pierceDefense = slashDefense;
            description = "Light armor that provides okay protection.";
        }
        if(item == 4 || item == 5){
            weight = 2 + rgen.nextInt(4);
            slashDefense = 3 + weight;
            pierceDefense = weight - 2;
            description = "Medium armor that provides decent slashing protection.";
        }
        if(item == 6){
            weight = 7 + rgen.nextInt(6);
            slashDefense = 2 + weight;
            pierceDefense = weight - 1;
            description = "Heavy armor that provides great protection.";
        }
        if(item == 7){
            weight = 1 + rgen.nextInt(3);
            pierceDefense = weight + rgen.nextInt(7);
            slashDefense = weight;
            description = "Light armor that provides decent piercing protection.";
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
