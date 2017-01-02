import java.util.ArrayList;
import java.util.Random;
/**
 * Write a name of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    public ArrayList<String> name;
    public String description;
    public int weight;
    public int item;
    public int energy;
    public int pierceAttack;
    public int slashAttack;
    public int pierceDefense;
    public int slashDefense;
    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        Random rgen = new Random();
        name = new ArrayList<>();
        name.add("Flashlight");
        name.add("Pen");
        name.add("Notebook");
        name.add("Tape");
        name.add("Tape");
        name.add("Tape");
        name.add("Tape");
        name.add("Tape");
        item  = rgen.nextInt(8);
        weight = 1;
        if(item == 0){
            description = "Can be used to illuminate a dark room.";
        }
        if(item == 1){
            description = "Can be used to write notes.";
        }
        if(item == 2){
            description = "Can be used to write notes on.";
        }
        if(item == 3 || item == 4 || item == 5 || item == 6 || item == 7){
            description = "Can be used to seal an exit.";
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName(){
        return name.get(item);
    }

    public int getWeight(){
        return weight;
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

    public String getDescription(){
        return description;
    }
}
