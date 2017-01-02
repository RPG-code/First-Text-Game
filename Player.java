import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private Room currentRoom;
    private Room previousRoom;
    private ArrayList<Item> items;
    private String name;
    private int weightLimit;
    private int currentWeight;
    private int hunger;
    private int full;
    private Item armor;
    private Item weapon;
    private ArrayList<String> notes;
    /**
     * Constructor for objects of class Player
     */
    public Player(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        items = new ArrayList<>();
        weightLimit = 30;
        currentWeight = 0;
        hunger = 10;
        full = 25;
        armor = null;
        weapon = null;
        notes = new ArrayList<>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void go(String direction){
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
            return;
        } else if(currentRoom.getDummyExit(direction) == null){
            System.out.println("This exit is sealed.");
            return;
        } else if(hunger == 1){
            System.out.println(name + " is too hungry. " + name + " must eat.");
            return;
        }  else{
            previousRoom = currentRoom;
            currentRoom = nextRoom;
            hunger--;
        }
    }

    public void setRoom(Room firstRoom){
        currentRoom = firstRoom;
    }

    public void eat(String food){
        if(food.equals("Cookie") || food.equals("Sweetroll") || food.equals("Cheese") || food.equals("Steak") || food.equals("Apple") || food.equals("Water") || food.equals("Pizza") || food.equals("Bread")){
            Iterator<Item> it = items.iterator();
            while(it.hasNext()){
                Item i = it.next();
                if(food.equals(i.getName()) && food.equals("Cookie")){
                    Random rgen = new Random();
                    if(rgen.nextInt(10) > 7){
                        System.out.println("This is a magic cookie. " + name + "'s weight limit increases.");
                        weightLimit += 10;
                        hunger += i.getEnergy();
                        if(hunger > full){
                            hunger = full;
                        }
                        currentWeight -= i.getWeight();
                        it.remove();
                        return;
                    }else{
                        hunger += i.getEnergy();
                        if(hunger > full){
                            hunger = full;
                        }
                        currentWeight -= i.getWeight();
                        it.remove();
                        return;
                    }
                }else if(food.equals(i.getName()) && food.equals("Sweetroll")){
                    Random rgen = new Random();
                    if(rgen.nextInt(10) > 7){
                        System.out.println("This is a magic sweetroll. " + name + "'s energy limit increases.");
                        full += 10;
                        hunger += i.getEnergy();
                        if(hunger > full){
                            hunger = full;
                        }
                        currentWeight -= i.getWeight();
                        it.remove();
                        return;
                    }else{
                        hunger += i.getEnergy();
                        if(hunger > full){
                            hunger = full;
                        }
                        currentWeight -= i.getWeight();
                        it.remove();
                        return;
                    }
                }else if(food.equals(i.getName())){
                    hunger += i.getEnergy();
                    if(hunger > full){
                        hunger = full;
                    }
                    currentWeight -= i.getWeight();
                    it.remove();
                    return;
                }
            }
            System.out.println(name + " does not have any " + food);
        }else{
            System.out.println("That is not food!");
            return;
        }
    }

    public void take(String item){
        Iterator<Item> it = currentRoom.items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(item.equals(i.getName())){
                if(weightLimit - currentWeight >= i.getWeight()){
                    items.add(i);
                    currentWeight += i.getWeight();
                    currentRoom.removeItem(item);
                    return;
                }else{
                    System.out.println("This " + item + " is too heavy for " + name + " to carry.");
                }
            }
        }
        System.out.println("This room does not have any " + item + "s.");
    }

    public void drop(String item){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(item.equals(i.getName())){
                currentRoom.droppedItem(i);
                it.remove();
                return;
            }
        }
        System.out.println(name + " does not have any " + item + "s.");
    }

    public void back(){
        if(hunger == 1){
            System.out.println(name + " is too hungry. They must eat.");
            return;
        } 
        else{
            Room holdRoom = previousRoom;
            previousRoom = currentRoom;
            currentRoom = holdRoom;
            hunger--;
        }
    }

    public Room getRoom(){
        return currentRoom;
    }

    public void look(){
        if(currentRoom.isDark()){
            System.out.println("It is too dark to see.");
            return;
        }else{
            System.out.println(currentRoom.getLongDescription());
            System.out.println();
            System.out.println("Room Items:");
            currentRoom.printItemInfo();
            if(currentRoom.hasEnemy()){
                System.out.println("");
                System.out.println("This room contains a " + currentRoom.getEnemy().getName() + ".");
                System.out.println("");
            }
        }
    }

    public void getStatus(){
        System.out.println("Player: " + name);
        System.out.println("Energy: " + hunger);
        System.out.println("Current Weight: " + currentWeight + "   Weight Limit: " + weightLimit);
        if(weapon != null){
            System.out.println("Weapon: " + weapon.getName());
            if(weapon.getSlashAttack() != 0){
                System.out.print("   Slash Attack: " + weapon.getSlashAttack());
            }
            if(weapon.getPierceAttack() != 0){
                System.out.print("   Pierce Attack: " + weapon.getPierceAttack());
            }
        }
        System.out.println();
        if(armor != null){
            System.out.println("Armor: " + armor.getName());
            System.out.print("   Slash Defense: " + armor.getSlashDefense() + "   Pierce Defense: " + armor.getPierceDefense());
        }
        System.out.println();
    }

    public void getInventory(){
        if(items.size() > 0){
            for(int i = 0; i < items.size(); i++){
                System.out.println("Item: " + items.get(i).getName() + "   Weight: " + items.get(i).getWeight());
                if(items.get(i).getEnergy() != 0){
                    System.out.println("Energy: " + items.get(i).getEnergy());
                }
                if(items.get(i).getSlashAttack() != 0){
                    System.out.println("Slash Attack: " + items.get(i).getSlashAttack());
                }
                if(items.get(i).getPierceAttack() != 0){
                    System.out.println("Pierce Attack: " + items.get(i).getPierceAttack());
                }
                if(items.get(i).getSlashDefense() != 0 || items.get(i).getPierceDefense() != 0){
                    System.out.println("Slash Defense: " + items.get(i).getSlashDefense() + "   Pierce Defense: " + items.get(i).getPierceDefense());
                }
                System.out.println(items.get(i).getDescription());
                System.out.println("");
            }
        }else{
            System.out.println(name + " does not have any items.");
        }
    }

    public Item getWeapon(){
        return weapon;
    }

    public void equipWeapon(String newWeapon){
        if(newWeapon.equals("Dagger") || newWeapon.equals("Sword") || newWeapon.equals("Axe") || newWeapon.equals("Pistol") || newWeapon.equals("Shotgun")){
            Item equip;
            Item unequip;
            Iterator<Item> it = items.iterator();
            while(it.hasNext()){
                Item i = it.next();
                if(newWeapon.equals(i.getName())){
                    equip = i;
                    unequip = weapon;
                    weapon = equip;
                    it.remove();
                    if(unequip != null){
                        items.add(unequip);
                    }
                    return;
                }
            }
            System.out.println(name + " does not have any " + newWeapon + "s.");
            return;
        }else{
            System.out.println("That is not a weapon!");
            return;
        }
    }

    public Item getArmor(){
        return armor;
    }

    public void equipArmor(String newArmor){
        if(newArmor.equals("LeatherArmor") || newArmor.equals("Chainmail") || newArmor.equals("PlateArmor") || newArmor.equals("Kevlar")){
            Item equip;
            Item unequip;
            Iterator<Item> it = items.iterator();
            while(it.hasNext()){
                Item i = it.next();
                if(newArmor.equals(i.getName())){
                    equip = i;
                    unequip = armor;
                    armor = equip;
                    it.remove();
                    if(unequip != null){
                        items.add(unequip);
                    }
                    return;
                }
            }
            System.out.println(name + " does not have any " + newArmor + "s.");
            return;
        }else{
            System.out.println("That is not armor!");
            return;
        }
    }

    public void takeNote(){
        Iterator<Item> it1 = items.iterator();
        while(it1.hasNext()){
            Item i = it1.next();
            if(i.getName().equals("Notebook")){
                Iterator<Item> it2 = items.iterator();
                while(it2.hasNext()){
                    Item j = it2.next();
                    if(j.getName().equals("Pen")){
                        Scanner sc = new Scanner(System.in);
                        String note = sc.nextLine();
                        notes.add(note);
                        return;
                    }
                }
                System.out.println(name + " does not have any pens.");
                return;
            }
        }
        System.out.println(name + " does not have any notebooks.");
    }

    public void getNotes(){
        for(int i = 0; i < notes.size(); i++){
            System.out.println(notes.get(i));
            System.out.println("");
        }
    }

    public void sealExit(String direction){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equals("Tape")){
                if(direction.equals(direction)){
                    if(currentRoom.getExit(direction) != null){
                        if(currentRoom.getDummyExit(direction) == null){
                            System.out.println("This exit is already sealed.");
                            return;
                        }else{
                            currentRoom.dummyExits.remove(direction);
                            it.remove();
                            return;
                        }
                    }
                }
                System.out.println("There is no door!");
                return;
            }
        }
        System.out.println(name + " does not have any tape.");
        return;
    }

    public void unSealExit(String direction){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equals("Dagger") || i.getName().equals("Axe")){
                if(direction.equals(direction)){
                    if(currentRoom.getExit(direction) != null){
                        if(currentRoom.getDummyExit(direction) != null){
                            System.out.println("This exit is already unsealed.");
                            return;
                        }else{
                            currentRoom.dummyExits.put(direction, currentRoom.getExit(direction));
                            return;
                        }
                    }
                }
                System.out.println("There is no door!");
                return;
            }
        }
        System.out.println(name + " does not have any daggers or axes.");
        return;
    }

    public void useLight(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equals("Flashlight")){
                currentRoom.isDark = false;
                return;
            }
        }
        System.out.println(name + " does not have a flashlight");
    }

    public int attack(){
        if(weapon == null){
            return 0;
        }
        if(weapon.getPierceAttack() == 0){
            return weapon.getSlashAttack();
        }
        if(weapon.getSlashAttack() == 0){
            return weapon.getPierceAttack();
        }
        return 0;
    }

    public void takeDamage(int damage){
        if(dodge()){
            System.out.println(name + " has dodged the " + currentRoom.getEnemy().getName() + "'s attack.");
            return;
        }
        if(armor == null){
            hunger -= damage;
            return;
        }
        if(currentRoom.getEnemy().getPierceAttack() == 0){
            if(damage - armor.getSlashDefense() <= 0){
                return;
            }else{
                hunger -= (damage - armor.getSlashDefense());
                return;
            }
        }
        if(currentRoom.getEnemy().getSlashAttack() == 0){
            if(damage - armor.getPierceDefense() <= 0){
                return;
            }else{
                hunger -= (damage - armor.getPierceDefense());
                return;
            }
        }
    }

    public boolean dodge(){
        Random rgen = new Random();
        int speed;
        if(getWeapon() == null && getArmor() == null){
            speed = 21 + rgen.nextInt(11);
        }else if(getWeapon() == null){
            speed = 21 - armor.getWeight() + rgen.nextInt(11 + armor.getWeight());
        }else if(getArmor() == null){
            speed = 21 - weapon.getWeight() + rgen.nextInt(11 + weapon.getWeight());
        }else{
            speed = 21 - weapon.getWeight() - armor.getWeight() + rgen.nextInt(11 + weapon.getWeight() + armor.getWeight());
        }
        if(speed > currentRoom.getEnemy().getSpeed() + rgen.nextInt(31 - currentRoom.getEnemy().getSpeed())){
            return true;
        }
        return false;
    }

    public void escape(){
        if(dodge()){
            back();
            look();
            return;
        }else{
            takeDamage(currentRoom.getEnemy().attack());
        }
    }

    public String getName(){
        return name;
    }

    public int getEnergy(){
        return hunger;
    }
}

