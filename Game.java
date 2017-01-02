/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all.  You simply walk around a
 *  college campus for eternity.
 *  
 *  Then, Hell decides that it likes the campus and moves in.  Now there
 *  are items everywhere.  Now you have to try to turn the campus back into
 *  it's old boring self again.  Don't die.
 *  
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player player;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        System.out.println("Please create a new player.");
        player = new Player();
        createRooms(player);
        parser = new Parser();
        play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(Player player)
    {
        Room clock, square1, square2, plaza1, plaza2, plaza3, path, quad1, quad2, gymfield, volleyball, cafelobby, cafe, kitchen, freezer, pub, theater, theaterbalcony, cafehall1, cafehall2, store, book, study1, study2, study3, study4, cafebath, cafestorage, adminreception, adminbath, adminhall1, adminhall2, adminhall3, admission, finance, gymentrance, locker, pool, gym, gymstorage, gymhall, maledormlobby, malebath, femaledormlobby, femalebath, academicentrance, lecture, academichall1, academichall2, academichall3, academichall4, academichall5, academichall6, classroom1, classroom2, classroom3, classroom4, classroom5, prep, computerlab, weight, racket, library, maledorm1, maledorm2, maledorm3, femaledorm1, femaledorm2, femaledorm3, malelounge, femalelounge, game, dormbridge, balcony, president, academics, conference, bar, lowerlobby;

        // create the rooms
        clock = new Room("outside at the clock in the center of campus", player);
        theater = new Room("in a movie theater", player);
        pub = new Room("in the campus pub", player);
        computerlab = new Room("in a computer lab", player);
        admission = new Room("in the admissions office", player);
        academics = new Room("in the academics office", player);
        finance = new Room("in the financial aid office", player);
        president = new Room("in the president's office", player);
        academicentrance = new Room("in the entrance of the academic building", player);
        cafe = new Room("in the university cafe", player);
        cafelobby = new Room("in the entrance of the cafe building", player);
        pool = new Room("in the university pool", player);
        store = new Room("in the university store", player);
        cafestorage = new Room("in the bookstore storage room", player);
        study1 = new Room("in a study hall", player);
        study2 = new Room("in a study hall", player);
        study3 = new Room("in a study hall", player);
        study4 = new Room("in a study hall", player);
        square1 = new Room("outside in the center of campus", player);
        square2 = new Room("outside in the center of campus", player);
        plaza1 = new Room("outside of the cafe", player);
        plaza2 = new Room("outside of the cafe", player);
        plaza3 = new Room("outside of the administration building", player);
        path = new Room("outside in the center of campus", player);
        quad1 = new Room("outside in the dorm quad", player);
        quad2 = new Room("outside in the dorm quad", player);
        femaledormlobby = new Room("in the lobby of the female dorm", player);
        maledormlobby = new Room("in the lobby of the male dorm", player);
        femalelounge = new Room("in the lounge of the female dorm", player);
        malelounge = new Room("in the lounge of the male dorm", player);
        femaledorm1 = new Room("in a female dorm", player);
        femaledorm2 = new Room("in a female dorm", player);
        femaledorm3 = new Room("in a female dorm", player);
        maledorm1 = new Room("in a male dorm", player);
        maledorm2 = new Room("in a male dorm", player);
        maledorm3 = new Room("in a male dorm", player);
        dormbridge = new Room("in the sky bridge between the dorms", player);
        gym = new Room("in the basketball court", player);
        bar = new Room("in the bar", player);
        balcony = new Room("on the balcony over the academic entrance", player);
        theaterbalcony = new Room("on the balcony over the theater", player);
        classroom1 = new Room("in a classroom", player);
        classroom2 = new Room("in a classroom", player);
        classroom3 = new Room("in a classroom", player);
        classroom4 = new Room("in a classroom", player);
        classroom5 = new Room("in a classroom", player);
        lowerlobby = new Room("in the lobby below the cafe entrance", player);
        prep = new Room("in the prep room beneath the lecture hall", player);
        lecture = new Room("in the lecture hall", player);
        locker = new Room("in the locker room", player);
        gymhall = new Room("in a hallway", player);
        academichall1 = new Room("in a hallway", player);
        academichall2 = new Room("in a hallway", player);
        academichall3 = new Room("in a hallway", player);
        academichall4 = new Room("in a hallway", player);
        academichall5 = new Room("in a hallway", player);
        academichall6 = new Room("in a hallway", player);
        adminhall1 = new Room("in a hallway", player);
        adminhall2 = new Room("in a hallway", player);
        adminhall3 = new Room("in a hallway", player);
        cafehall1 = new Room("in a hallway", player);
        cafehall2 = new Room("in a hallway", player);
        weight = new Room("in the weight room", player);
        racket = new Room("in the racketball court", player);
        volleyball = new Room("outside on the volleytball court", player);
        gymfield = new Room("outside on the athletic field", player);
        malebath = new Room("in the male dorm bathroom", player);
        femalebath = new Room("in the female dorm bathroom", player);
        adminbath = new Room("in the administration restroom", player);
        cafebath = new Room("in the cafe restroom", player);
        kitchen = new Room("in the cafe kitchen", player);
        freezer = new Room("in the cafe freezer", player);
        game = new Room("in the dorm game room", player);
        prep = new Room("in the prep room under the lecture hall", player);
        gymentrance = new Room("in the gym entrance", player);
        gymstorage = new Room("in the gym storage room", player);
        library = new Room("in the library", player);
        adminreception = new Room("in the entrance of the administration building", player);
        book = new Room("in the bookstore", player);
        conference = new Room("in the conference room", player);

        // initialise room exits
        clock.setExits(square1, plaza1, square2, quad2, null, null);
        theater.setExits(null, null, cafehall2, null, theaterbalcony, null);
        pub.setExits(null, null, cafehall1, cafe, bar, null);
        computerlab.setExits(null, library, null, null, null, null);
        admission.setExits(null, adminhall1, null, null, null, null);
        academics.setExits(null, adminhall2, null, null, null, null);
        finance.setExits(null, adminreception, null, null, null, null);
        president.setExits(null, adminhall3, null, null, null, null);
        academicentrance.setExits(null, path, academichall1, lecture, balcony, academichall4);
        cafe.setExits(kitchen, pub, cafelobby, plaza1, null, null);
        cafelobby.setExits(cafe, cafehall1, store, plaza2, null, lowerlobby);
        pool.setExits(null, gymhall, locker, null, null, null);
        store.setExits(cafelobby, null, cafestorage, plaza3, book, null);
        cafestorage.setExits(store, null, null, null, null, null);
        study1.setExits(cafehall1, null, null, null, null, null);
        study2.setExits(null, null, lowerlobby, null, null, null);
        study3.setExits(null, null, null, lowerlobby, null, null);
        study4.setExits(lowerlobby, null, null, null, null, null);
        square1.setExits(gymentrance, gymfield, clock, null, null, null);
        square2.setExits(clock, plaza2, path, null, null, null);
        plaza1.setExits(gymfield, cafe, plaza2, clock, null, null);
        plaza2.setExits(plaza1, cafelobby, plaza3, square2, null, null);
        plaza3.setExits(plaza2, store, adminreception, path, null, null);
        path.setExits(square2, plaza3, null, academicentrance, null, null);
        quad1.setExits(null, quad2, null, null, null, null);
        quad2.setExits(maledormlobby, clock, femaledormlobby, quad1, null, null);
        femaledormlobby.setExits(quad2, null, null, femalebath, femaledorm1, femaledorm3);
        maledormlobby.setExits(null, null, quad2, malebath, maledorm1, maledorm3);
        femalelounge.setExits(game, femaledorm3, null, null, null, null);
        malelounge.setExits(null, maledorm3, game, null, null, null);
        femaledorm1.setExits(null, null, null, femaledorm2, null, femaledormlobby);
        femaledorm2.setExits(dormbridge, femaledorm1, null, null, null, null);
        femaledorm3.setExits(null, null, null, femalelounge, femaledormlobby, null);
        maledorm1.setExits(null, null, null, maledorm2, null, maledormlobby);
        maledorm2.setExits(null, maledorm1, dormbridge, null, null, null);
        maledorm3.setExits(null, null, null, malelounge, maledormlobby, null);
        dormbridge.setExits(maledorm2, null, femaledorm2, null, null, null);
        gym.setExits(gymstorage, null, volleyball, gymhall, null, null);
        bar.setExits(null, null, null, null, null, pub);
        balcony.setExits(null, null, academichall2, null, null, academicentrance);
        theaterbalcony.setExits(null, null, null, null, null, theater);
        classroom1.setExits(null, academichall1, null, null, null, null);
        classroom2.setExits(null, academichall2, null, null, null, null);
        classroom3.setExits(null, academichall3, null, null, null, null);
        classroom4.setExits(null, academichall5, null, null, null, null);
        classroom5.setExits(null, academichall6, null, null, null, null);
        lowerlobby.setExits(study2, study3, study4, null, cafelobby, null);
        prep.setExits(null, academichall4, null, null, lecture, null);
        lecture.setExits(null, academicentrance, null, null, null, prep);
        locker.setExits(pool, gymentrance, null, null, null, null);
        gymhall.setExits(null, gym, gymentrance, pool, null, null);
        academichall1.setExits(academicentrance, null, library, classroom1, null, null);
        academichall2.setExits(balcony, null, academichall3, classroom2, null, null);;
        academichall3.setExits(academichall2, null, null, classroom3, null, null);
        academichall4.setExits(null, null, academichall5, prep, academicentrance, null);
        academichall5.setExits(academichall4, null, academichall6, classroom4, null, null);
        academichall6.setExits(academichall5, null, null, classroom5, null, null);
        adminhall1.setExits(adminreception, adminbath, null, admission, adminhall2, null);
        adminhall2.setExits(adminhall3, conference, null, academics, null, adminhall1);
        adminhall3.setExits(null, null, adminhall2, president, null, null);
        cafehall1.setExits(pub, cafehall2, study1, cafelobby, null, null);
        cafehall2.setExits(theater, null, cafebath, cafehall1, null, null);
        weight.setExits(racket, null, null, null, null, gymentrance);
        racket.setExits(null, null, weight, null, null, null);
        volleyball.setExits(gym , null, gymfield, gymentrance, null, null);
        gymfield.setExits(volleyball, null, plaza1, square1, null, null);
        malebath.setExits(null, maledormlobby, null, null, null, null);
        femalebath.setExits(null, femaledormlobby, null, null, null, null);
        adminbath.setExits(null, null, null, adminhall1, null, null);
        cafebath.setExits(cafehall2, null, null, null, null, null);
        kitchen.setExits(null, freezer, cafe, null, null, null);
        freezer.setExits(null, null, null, kitchen, null, null);
        game.setExits(malelounge, null, femalelounge, null, null, null);
        prep.setExits(null, academichall4, null, null, lecture, null);
        gymentrance.setExits(gymhall, volleyball, square1, locker, weight, null);
        gymstorage.setExits(null, null, gym, null, null, null);
        library.setExits(academichall1, null, null, computerlab, null, null);
        adminreception.setExits(plaza3, null, adminhall1, finance, null, null);
        book.setExits(null, null, null, null, null, store);
        conference.setExits(null, null, null, adminhall2, null, null);

        player.setRoom(clock);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        player.look();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul has been invaded by hell.  Try not to die.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();

    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch(commandWord){
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;

            case GO:
            goRoom(command);
            break;

            case LOOK:
            look();
            break;

            case EAT:
            eat(command);
            break;

            case TAKE:
            take(command);
            break;

            case DROP:
            drop(command);
            break;

            case BACK:
            back();
            break;

            case STATUS:
            status();
            break;

            case INVENTORY:
            inventory();
            break;

            case EQUIPARMOR:
            equipArmor(command);
            break;

            case EQUIPWEAPON:
            equipWeapon(command);
            break;

            case TAKENOTE:
            takeNote();
            break;

            case READNOTES:
            readNotes();
            break;

            case SEALEXIT:
            sealExit(command);
            break;

            case UNSEALEXIT:
            unSealExit(command);
            break;

            case USELIGHT:
            useLight();
            break;

            case ATTACK:
            wantToQuit = attack();
            break;

            case ESCAPE:
            wantToQuit = escape();
            break;

            case QUIT:
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are scared. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println("You fight. You survive.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command){
        if(player.getRoom().hasEnemy() && player.dodge() == false){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        player.go(command.getSecondWord());

        // Try to leave current room.
        player.look();
        System.out.println();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command){
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void look(){
        player.look();
        System.out.println();
    }

    private void eat(Command command){
        if(player.getRoom().hasEnemy() && player.dodge() == false){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Eat what?");
            return;
        }
        String food = command.getSecondWord();
        player.eat(food);
    }

    private void take(Command command){
        if(player.getRoom().hasEnemy() && player.dodge() == false){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        String item = command.getSecondWord();
        player.take(item);
    }

    private void drop(Command command){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        String item = command.getSecondWord();
        player.drop(item);
    }

    private void back(){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        player.back();
        player.look();
        System.out.println();
    }

    public void status(){
        System.out.println("Player Status:");
        player.getStatus();
    }

    public void inventory(){
        System.out.println("Player Inventory:");
        player.getInventory();
    }

    public void equipArmor(Command command){
        if(player.getRoom().hasEnemy() && player.dodge() == false){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Equip what?");
            return;
        }
        String armor = command.getSecondWord();
        player.equipArmor(armor);
    }

    public void equipWeapon(Command command){
        if(player.getRoom().hasEnemy() && player.dodge() == false){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Equip what?");
            return;
        }
        String weapon = command.getSecondWord();
        player.equipWeapon(weapon);
    }

    public void takeNote(){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        System.out.println("New Note:");
        player.takeNote();
    }

    public void readNotes(){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        player.getNotes();
    }

    private void sealExit(Command command){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Seal where?");
            return;
        }
        String direction = command.getSecondWord();
        player.sealExit(direction);
    }

    private void unSealExit(Command command){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        if(!command.hasSecondWord()) {
            System.out.println("Unseal where?");
            return;
        }
        String direction = command.getSecondWord();
        player.unSealExit(direction);
    }

    public void useLight(){
        if(player.getRoom().hasEnemy()){
            System.out.println("This room contains a " + player.getRoom().getEnemy().getName() + ". It stops you.");
            return;
        }
        player.useLight();
    }

    public boolean attack(){
        player.getRoom().getEnemy().takeDamage(player.attack());
        player.takeDamage(player.getRoom().getEnemy().attack());
        System.out.println(player.getName() + "'s Energy: " + player.getEnergy());
        System.out.println(player.getRoom().getEnemy().getName() + "'s Energy: " + player.getRoom().getEnemy().getEnergy());
        if(player.getRoom().getEnemy().getEnergy() <= 0){
            System.out.println(player.getRoom().getEnemy().getName() + " has been defeated by " + player.getName());
            player.getRoom().hasEnemy = false;
        }
        if(player.getEnergy() <= 0){
            System.out.println(player.getName() + " has died. Have a good day.");
            return true;
        }
        return false;
    }

    public boolean escape(){
        player.escape();
        System.out.println(player.getName() + "'s Energy: " + player.getEnergy());
        if(player.getEnergy() <= 0){
            System.out.println(player.getName() + " has died. Have a good day.");
            return true;
        }
        return false;
    }
}
