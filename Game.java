import java.util.*;
public class Game {
    Scanner sc = new Scanner(System.in);
    Scanner entScanner = new Scanner(System.in);
    int playerHP;
    String playerName;
    String playerWeapon;
    int choice;
    int monsterHP;
    int silverRing;

    public static void main(String[]args) {
        Game dublin;
        dublin = new Game();
        dublin.playerSetUP();
        dublin.townGate();
        dublin.attack();
        dublin.fight();
        dublin.win();
        dublin.dead();
        dublin.east();
        dublin.west();
        dublin.north();
        dublin.crossRoad();
        
    }
    
    public void playerSetUP(){
        playerHP= 10;
        monsterHP = 15;
        
        playerWeapon = "Knife";
        
        System.out.println("Your HP: "+playerHP);
        System.out.println("Your Weapon: "+playerWeapon);
        
        
        System.out.println();
        System.out.print("Please enter your name: ");
        playerName = sc.nextLine();
        
        System.out.println("Hello "+playerName+ ",let's satrt the game!");  
    }
    
    public void townGate(){
    System.out.println();
    System.out.println("--------------------------------------------------");
    System.out.println();
    System.out.println("You are at the Town Gate");
    System.out.println("A guard is standing in front of you.");
    System.out.println();
    System.out.println("What do you want to do?.");
    System.out.println("1: Talk to the guard.");
    System.out.println("2: Attack the guard do?");
    System.out.println("3: Leave");
    System.out.println();
    
    choice=sc.nextInt();
        
    if (choice==1) {
        if (silverRing==1) {
            ending();
            
        }
        else {
            System.out.println("Guard: Hello there stranger. So your name is " +playerName+ "? Sorry but we cannot let stranger enter our town");
            entScanner.nextLine();
            townGate();
        }

        
    }
    else if (choice==2) {
        playerHP=playerHP-1;
        System.out.println("Guard: Hey don't be stupid.\nThe guard hit you so hard and you gave up.\n(You recieve 1 damage)");
        System.out.println("Your HP: "+playerHP);
        entScanner.nextLine();
        townGate();
    }
    else if (choice==3) {
        crossRoad();
    }
    else {
        townGate();
    }
    }
    public void crossRoad(){
        System.out.println("----------------------------------------");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("----------------------------------------");

        choice = sc.nextInt();

        if(choice==1){
            north();
        }
        if (choice==2) {
            east();
        }
        if (choice==3) {
            townGate();
        }
        if (choice==4) {
            west();
        }
    }
    public void north(){
        System.out.println("----------------------------------------");
        System.out.println("There is a river. You drink the water and rest at the riverside");
        playerHP = playerHP+1;
        System.out.println("Your HP is recovered");
        System.out.println("PlayerHP: "+playerHP);
        System.out.println();
        System.out.println("\n\n 1: Go back to the crossroad");
        System.out.println("----------------------------------------");
        choice = sc.nextInt();
        if (choice==1) {
            crossRoad();
            
        }
        else{
            north();
        }
    }
    public void east(){
        System.out.println("----------------------------------------");
        System.out.println("You walked into a forest and found a long sword!");
        playerWeapon = "Long Sword";
        System.out.println("Your Weapon: "+playerWeapon);
        System.out.println("\n\n 1: Go back to the crossroad");
        System.out.println("----------------------------------------");
        choice = sc.nextInt();
        if (choice==1) {
            crossRoad();
            
        }
        else{
            east();
        }

    }
    public void west(){
        System.out.println("----------------------------------------");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("----------------------------------------");

        choice = sc.nextInt();

        if (choice==1) {
            fight();
        }
        if (choice==2){
            crossRoad();
        }
        else{
            west();
        }
    }

    public void fight(){
        System.out.println("----------------------------------------");
        System.out.println("Your Hp: "+playerHP );
        System.out.println("Monster HP "+monsterHP);
        System.out.println("1: Attack");
        System.out.println("2: Run");
        System.out.println("----------------------------------------");

        choice = sc.nextInt();
        if (choice==1) {
            attack();
        }
        if (choice==2) {
            crossRoad();
        }
        else{
            fight();
        }
    }
    public void attack(){
        int playerDamage = 0;
        
        if (playerWeapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(5);

        }
        if (playerWeapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(8);
        }

        System.out.println("You attacked the monster and gave "+playerDamage+ " damage!");

        monsterHP = monsterHP-playerDamage;
        System.out.println("Monster HP: "+monsterHP);
        if (monsterHP<1) {
            win();
        }
        if (monsterHP>0) {
            int monsterDamage = 0;
            monsterDamage = new java.util.Random().nextInt(4);
            System.out.println("The monster attacked you and gave "
            +monsterDamage+" damage!");
            playerHP=playerHP - monsterDamage;
            System.out.println("Player HP: "+playerHP);
            if (playerHP<1) {
                dead();
            }
           else if (playerHP>0) {
                fight();
            }
        }
    }
    public void dead(){
        System.out.println("----------------------------------------");
        System.out.println("You are dead!!!");
        System.out.println("\n\n---------GAME OVER----------");
        System.out.println("----------------------------------------");
    
    }
    public void win(){
        System.out.println("----------------------------------------");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtained a silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("----------------------------------------");

        silverRing = 1;
        choice = sc.nextInt();
        if (choice==1) {
            crossRoad();
        }
        else{
            win();
        }
    }
    public void ending(){
        System.out.println("----------------------------------------");
        System.out.println("Guard: Ohhh you killed that monster!?? Great!!");
        System.out.println("Seems you are trustworthy guy. Welcome to our town!");
        System.out.println("--------------THE END---------------------");
        System.out.println("----------------------------------------");

    }
}

 