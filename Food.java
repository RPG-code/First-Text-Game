import java.util.ArrayList;
import java.util.Random;
/**
 * Write a name of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Item
{
    /**
     * Constructor for objects of class Food
     */
    public Food()
    {
        Random rgen = new Random();
        name = new ArrayList<>();
        name.add("Cookie");
        name.add("Steak");
        name.add("Cheese");
        name.add("Sweetroll");
        name.add("Apple");
        name.add("Pizza");
        name.add("Bread");
        name.add("Water");
        name.add("Cookie");
        name.add("Sweetroll");
        item  = rgen.nextInt(10);
        if(item == 0 || item == 3 || item == 8 || item == 9){
            weight = 1;
            energy = 1;
            description = "A small snack.";
        }
        if(item == 2 || item == 4){
            weight = 1;
            energy = 1 + rgen.nextInt(4);
            description = "A small healthy snack.";
        }
        if(item == 1){
            weight = 2 + rgen.nextInt(3);
            energy = 3 + rgen.nextInt(6);
            description = "A large meal.";
        }
        if(item == 5){
            weight = 2 + rgen.nextInt(3);
            energy = 1 + rgen.nextInt(6);
            description = "A decent meal.";
        }
        if(item == 6){
            weight = 1 + rgen.nextInt(4);
            energy = 2 + rgen.nextInt(4);
            description = "A decent snack.";
        }
        if(item == 7){
            weight = 1 + rgen.nextInt(3);
            energy = 2;
            description = "A small drink.";
        }
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
