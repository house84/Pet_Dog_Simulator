//Nick House CMPSCI-2261 Project 2

import java.util.Scanner;

public class HumanDogSIm {
    public static void main(String[] args) {
        //Welcome intro
        System.out.println("Hello, Welcome to the Human/Dog simulator. ");

        //Create new scanner
        Scanner input = new Scanner(System.in);

        //Prompt User for the number of humans, validate - value > 0
        int humans = 0;
        do {
            System.out.println("\nEnter the number of humans there are (at least 1): ");
            while (!input.hasNextInt()) {
                System.out.println("You have entered an invalid number, try again. ");
                String tryagain = input.next();
            }
            humans = input.nextInt();
        } while (humans < 1);

        //Create and array size of the number of humans.
        Human[] humanArray = new Human[humans];

        //Populate Human Array with newHuman objects and give attributes
        for (int i = 0; i < humanArray.length; i++) {
            //Prompt user for Human Names
            System.out.println("\nWhat is human " + (i + 1) + "'s name? ");
            String name = input.next();

            //Prompt User for Number of dogs and Validate
            int dogs = 0;
            do {
                System.out.println("\nEnter the number of dogs " + name + " has (at least 1): ");
                while (!input.hasNextInt()) {
                    System.out.println("You have entered an invalid number, try again. ");
                    String tryAgain = input.next();
                }
                dogs = input.nextInt();
            } while (dogs < 1);

            //Create new Humans and with name and dog arguments
            Human newHuman = new Human(name, dogs);
            humanArray[i] = newHuman;
            //Call DogArray Method for each human to populate Dog Array
            newHuman.dogArray(dogs);
        }

        //Set Condition to continue Simulation
        int play = 1;
        while (play == 1) {
            //Call UserInterface for simulation.
            for (int i = 0; i < humanArray.length; i++) {
                System.out.println(humanArray[i]);
                humanArray[i].UserInterface();
            }
        }
    }
}


