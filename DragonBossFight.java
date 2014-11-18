// *************************************************************
// DragonBossFight
// File name: DragonBossFight.java
// Written by: Jennifer Sunahara
// For Fun! /Fall 2014
//
// This program's purpose:
// to take the user's name and offer some adventure choices,
// if the right conditions are met, the user may win the game!
// *************************************************************
import java.util.Scanner;

public class DragonBossFight {
    public static void main(String[] args){

        Scanner keyIn= new Scanner(System.in);
        System.out.println("There was once a brave, brave adventurer. Who went on a brave, brave adventure...");
        System.out.print("What is your NAME, brave adventurer?: ");

        // Obtain username
        String userName= keyIn.next();
        userName= userName.toLowerCase();
        char first= Character.toUpperCase(userName.charAt(0));
        userName= first + userName.substring(1);

        System.out.println();
        System.out.println("Welcome to the story of your adventure, brave " + userName + "!");

        // User chooses to go to the ocean or to the castle
        System.out.println(userName + ", you are on a walk through a nice forest. You come across a fork in the road.");
        System.out.println("The left path will bring you to a tall castle that rises above the forest canopy. The right will bring you down towards the ocean shoreline.");
        System.out.print("You are faced with a decision: do you wish to go towards the OCEAN or the CASTLE?: ");
        String userPlace= keyIn.next();
        userPlace= userPlace.toLowerCase();
        System.out.println();

        // Verify that the user's choice of place is valid
        while (userPlace.equals("castle")== false && userPlace.equals("ocean")== false)
        {
            System.out.println("You can't seem to decide so you linger for a while at the fork.");
            System.out.print("You consider the choices that have brought you up to this point, then decide: OCEAN or CASTLE?: ");
            userPlace= keyIn.next();
            userPlace= userPlace.toLowerCase();
        }

        // Moving on with the story with customized location!
        if (userPlace.equals("castle"))
            System.out.println("You decide to take the left path towards the great castle. On the way there, you come across a dragon in the middle of the road!");
        if (userPlace.equals("ocean"))
            System.out.println("You decide to take the right path towards the beautiful ocean. On the way there, you come across a dragon in the middle of the road!");

        // User chooses to run or fight
        System.out.println("It has noticed you and looks hungry! So, brave " + userName + ", do you RUN or do you you draw your weapon and FIGHT?");
        String userChoice1= keyIn.next();
        userChoice1= userChoice1.toLowerCase();

        // User gets 4 warnings
        boolean userDead= false;
        final int WARNING= 4;
        if (userChoice1.equals("run")== false && userChoice1.equals("fight") == false)
            for (int i = 0; i<WARNING; i++ )
            {
                System.out.println("The dragon is coming closer!");
                switch (i)
                {
                    case 1: System.out.println("Oh boy, it looks mean with all those teeth and all that slobber drooling out of its mouth.");
                        break;
                    case 2: System.out.println("The dragon is so close that you can smell its breath!");
                        break;
                    case 3: System.out.println("You know this is your last chance, as you see the dragon open its mouth...");
                        userDead= true;
                        break;
                }
                System.out.println(userName + "! Snap out of it! Do you RUN or do you FIGHT?");
                userChoice1= keyIn.next();
                userChoice1= userChoice1.toLowerCase();
                if (userChoice1.equals("run") || userChoice1.equals("fight") == true)
                    break;
            }
        if (userDead== true)
        {
            System.out.println("You are dead. Way to go.");
            System.exit(0);
        }
        // Moving on with the story with customized action choices!
        // Running
        int DRAGONSPEED = 2; //this is how fast the dragon is (how many times you have to decide to run to get away)
        if (userChoice1.equals("run"))
        {
            System.out.println("You decide to run!");
            int count=0;
            do
            {
                System.out.println("The dragon is catching up! Do you continue to RUN or do you FIGHT?");
                userChoice1 = keyIn.next();
                userChoice1 = userChoice1.toLowerCase();
                if (!userChoice1.equals("fight") &&!userChoice1.equals("run"))
                {
                    System.out.println("The Dragon caught up and ate you. You are dead.");
                    System.exit(0);
                }
                if (userChoice1.equals("fight"))
                    break;
                count++;
            }while (userChoice1.equals("run") && count < DRAGONSPEED);
            if(userChoice1.equals("run"))
            {
                System.out.println("Phew! You got away safely!");
                System.exit(0);
            }
        }
        // Fighting
        int DRAGONHEALTH = 3; //this is how strong the dragon is (how many times you have to decide to fight to win)
        double USERACCURACY= 0.75; // how likely it is for the user to hit
        boolean hit;
        if (userChoice1.equals("fight"))
        {
            System.out.println("You decide to fight! You turn to face the dragon bravely.");
            int count = 1;
            do
            {
                System.out.println("The dragon looks a little confused by your bravery. You see your chance! Do you try to hit it? (YES/NO)");
                userChoice1 = keyIn.next();
                userChoice1 = userChoice1.toLowerCase();
                if (!userChoice1.equals("yes"))
                {
                    System.out.println("The Dragon sees you hesitate and gobbles you up. You are dead.");
                    System.exit(0);
                }
                hit= (Math.random()< USERACCURACY);
                if (!hit)
                {
                    System.out.println("Oh no! You miss and the dragon gobbles you up. You are dead.");
                    System.exit(0);
                }
                if ( hit && (DRAGONHEALTH-count!=0) )
                    System.out.println("Good shot! Looks like it can only take " + (DRAGONHEALTH-count) + " more " + ((DRAGONHEALTH-count==1)? "hit.": "hits."));
                count++;
            } while (count <= DRAGONHEALTH);
            System.out.println("Phew, you beat the dragon. Time to rest. Well done, " + userName + "!");
        }


    }
}
