import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("eat", CommandWord.EAT);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("status", CommandWord.STATUS);
        validCommands.put("inventory", CommandWord.INVENTORY);
        validCommands.put("equiparmor", CommandWord.EQUIPARMOR);
        validCommands.put("equipweapon", CommandWord.EQUIPWEAPON);
        validCommands.put("takenote", CommandWord.TAKENOTE);
        validCommands.put("readnotes", CommandWord.READNOTES);
        validCommands.put("sealexit", CommandWord.SEALEXIT);
        validCommands.put("unsealexit", CommandWord.UNSEALEXIT);
        validCommands.put("uselight", CommandWord.USELIGHT);
        validCommands.put("attack", CommandWord.ATTACK);
        validCommands.put("escape", CommandWord.ESCAPE);
    }

    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    public void showAll(){
        for(String command : validCommands.keySet()) {
            System.out.println(command);
        }
        System.out.println();
    }
}
