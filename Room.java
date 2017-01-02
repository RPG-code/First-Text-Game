import java.util.HashMap;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    public HashMap<String, Room> dummyExits;
    public ArrayList<Item> items;
    private int numItems;
    private int numFood;
    private int numArmor;
    private int numWeapon;
    public boolean hasEnemy;
    public Enemy enemy;
    public boolean isDark;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, Player player) 
    {
        this.description = description;
        exits = new HashMap<>();
        dummyExits = new HashMap<>();
        items = new ArrayList<>();
        Random rgen = new Random();
        numItems = rgen.nextInt(10);
        for(int i = 0; i < numItems; i++){
            addItem();
        }
        numFood = rgen.nextInt(6);
        for(int i = 0; i < numFood; i++){
            addFood();
        }
        numArmor = rgen.nextInt(2);
        for(int i = 0; i < numFood; i++){
            addArmor();
        }
        numFood = rgen.nextInt(2);
        for(int i = 0; i < numFood; i++){
            addWeapon();
        }
        int isEnemy = rgen.nextInt(6);
        if(isEnemy > 3){
            hasEnemy = true;
            enemy = new Enemy(player);
        }else{
            hasEnemy = false;
            enemy = null;
        }
        int dark = rgen.nextInt(8);
        if(dark > 4){
            isDark = true;
        }else{
            isDark = false;
        }
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }

    public Room getDummyExit(String direction){
        return dummyExits.get(direction);
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null)
            exits.put("north", north);
        dummyExits.put("north", north);
        if(east != null)
            exits.put("east", east);
        dummyExits.put("east", east);
        if(south != null)
            exits.put("south", south);
        dummyExits.put("south", south);
        if(west != null)
            exits.put("west", west);
        dummyExits.put("west", west);
        if(up != null)
            exits.put("up", up);
        dummyExits.put("up", up);
        if(down != null)
            exits.put("down", down);
        dummyExits.put("down", down);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public String getExitString(){
        String exitString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            exitString += " " + exit;
        }
        return exitString;
    }

    public String getLongDescription(){
        return("You are " + description + ".\n" + getExitString());
    }

    public void printItemInfo(){
        if(items.size() > 0){
            for(int i = 0; i < items.size(); i++){
                System.out.println("Item: " + items.get(i).getName() + "   Weight: " + items.get(i).getWeight());
            }
        }else{
            System.out.println("There are no items here.");
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(){
        items.add(new Item());
    }    

    public void addFood(){
        items.add(new Food());
    }

    public void addArmor(){
        items.add(new Armor());
    }

    public void addWeapon(){
        items.add(new Weapon());
    }

    public void droppedItem(Item item){
        items.add(item);
    }

    public void removeItem(String item){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(item.equals(i.getName())){
                it.remove();
                return;
            }
        }
    }

    public boolean isDark(){
        return isDark;
    }

    public boolean hasEnemy(){
        return hasEnemy;
    }

    public Enemy getEnemy(){
        return enemy;
    }
}
