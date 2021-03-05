//Nick House CMPSCI-2261 Project 2

import java.util.*;

import static java.lang.System.exit;

public class Human {

    //Declare Class Variables for Human
    private String name;
    private int money;
    private int dogfood;
    private int dogs;
    private Dog[] dogArray;
    private String dog_name;
    Scanner input = new Scanner(System.in);

    //Constructor Method
    Human(String name, int num_of_dogs){
        this.name = name;
        this.dogs = num_of_dogs;
        money = 50 + (int)(Math.random()*451.00);
        this.dogfood = (int)(Math.random()*25);
        this.dogArray = new Dog[num_of_dogs];
    }

    //Create Array of Dogs
    public void dogArray(int dogs){

        //For Loop to create an object for each new dog
        for(int i=0; i < dogArray.length; i++) {
            //Prompt user for Dog Names
            System.out.println("\nWhat is dog " +(i+1)+ "'s name? ");
            String dog_name = input.next();
            //Assign new instance of a Dog with Name argument
            Dog newDog = new Dog(dog_name);
            dogArray[i] = newDog;
        }

    }

    //Setter For Money
    private void setMoney(int money){
        this.money += money;
        //Send message when money is low, set balance to 0
        if(this.money <= 0){
            this.money = 0;
            System.out.println("You are out of money.");
        }
    }

    //Setter for Dogfood
    private void setDogFood(int food){
        this.dogfood += food;
        //Send Message when dogfood low set minimum value
        if(this.dogfood < 1){
            this.dogfood = 0;
            System.out.println("You need to buy dogfood. ");
        }
    }

    //Buy Dogfood
    private void BuyDogfood(){
        //Ensure enough money to buy food, send message
        if(money<25){
            System.out.println(name+ " does not have enough money for dogfood.");
        }
        else {
            dogfood += 25;
            setMoney(-25);
            System.out.println("Buying Dogfood...");
        }
    }

    //Setter for Feeds
    private void setFeeds(Dog newDog){
        //Feed dog remaining food if not enough for normal feeding, send message
        if(this.dogfood<5){
            int hold = 5 - dogfood;
            this.dogfood = 0;
            System.out.println(name+ " is out of Dogfood!");
            newDog.setHunger(- 7*hold);
        }
        else {
            setDogFood(-5);
            newDog.setHunger(-35);
        }
    }

    //Setter for Walks
    private void Walks(Dog newDog){
        newDog.setHunger(5);
        newDog.setFun(10);
        newDog.setCleanliness(-10);
        System.out.println("Walking dog...");
    }

    //Setter for Bath
    private void Bathes(Dog newDog){
        //Make sure enough money to wash dogs, send message
        if(money<15){
            System.out.println("Not enough money to bathe dog.");
        }
        else {
            setMoney(-15);
            newDog.setFun(-10);
            newDog.setCleanliness(80);
            newDog.setHunger(5);
            System.out.println("Washing dog...");
        }
    }

    //Pass the time Getter
    private void passTheTime(){
        //Add money and set dogs hunger and fun
        setMoney(10);
        for(int i =0; i < dogArray.length; i++){
            dogArray[i].setFun(-5);
            dogArray[i].setHunger(5);
        }
        System.out.println("Passing Time...");
    }

    private void play(Dog newDog){
        //Adjust dog traits and display message
        newDog.setFun(30);
        newDog.setHunger(15);
        newDog.setCleanliness(-15);
        System.out.println("Playing....");
    }

    //Go to work
    private void goToWork(Dog newDog){
        //Make money adjust dog traits send message
        setMoney(200);
        newDog.setFun(-10);
        newDog.setHunger(50);
        System.out.println("Putting in work...");
    }

    //Human toString
    public String toString(){
        String tmp = "\n********************************************\nName: "
                +name+ "\nAmount of Money: " + money+ "\nPounds of Dogfood Available: " +dogfood
                + "\nNumber of dogs: " +dogs+ "\n";

        //Concatenate Human string with its array of dogs toStrings
        for(int i = 0; i< dogArray.length; i++)
        {
            tmp += "\nDog " +(i+1)+ ": " +dogArray[i]+ "\n";
        }
        tmp+= "********************************************";
        return tmp;
    }

    //User Interface Method - Simulation interaction of human choices
    public int UserInterface(){
        //Display User Choices
        System.out.println("\nPlease select the number for what you would like " +name
                + " to do. \n1) Walk Dog \n2) Clean Dog \n3) Feed Dog \n4) Buy Food " +
                "\n5) Go to work \n6) Play with Dog \n7) Do Nothing \n8) Exit Game");

        //Validate User Input for proper integer
        int choice = 0;
        do {
            System.out.println("\nEnter option 1-8...");
            while (!input.hasNextInt()) {
                System.out.println("You have entered an invalid number, try again. ");
                String tryAgain = input.next();
            }
            choice = input.nextInt();
        } while (choice < 1 || choice > 8);

        //Switch Statement to Perform User Selection for Each Dog
        for(int i = 0; i< dogArray.length ; i++){

            switch(choice){
                case 1: Walks(dogArray[i]);     //Walk the dog
                        break;
                case 2: Bathes(dogArray[i]);    //Bathe Dog/s
                        break;
                case 3: setFeeds(dogArray[i]);  //Feed dog/s
                        break;
                case 4: BuyDogfood();           //Buy dog food for each dog
                        break;
                case 5: goToWork(dogArray[i]);  //Work Selection
                        break;
                case 6: play(dogArray[i]);      //Play with the dog
                        break;
                case 7: break;                  //Do Nothing
                default: exit(0);        //Exit Game.
            }
        }
        //Call PassTime Method
        passTheTime();

        return 1;
    }
}

