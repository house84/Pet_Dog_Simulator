//Nick House CMPSCI-2261 Project 2

import java.util.*;

public class Dog {

    //Declare Variables for Dog
    private String name;
    private int loyalty;
    private int hunger;
    private int fun;
    private int cleanliness;

    //Default Constructor
    Dog(String name) {
        this.name = name;
        hunger = 1 + (int)(Math.random()*100);
        fun = 1 + (int)(Math.random()*100);
        cleanliness = 1 + (int)(Math.random()*100);
        setLoyalty(fun, (100-hunger));
    }

    //Setter for Dog Loyalty
    private void setLoyalty(int fun, int hunger)
    { loyalty = Math.max(fun, 100-hunger); }

    //Getter for Loyalty
    public int getLoyalty()
    { return loyalty; }

    //Setter for Hunger
    public void setHunger(int hunger) {
        this.hunger += hunger;
        //Set Hunger, maintain within range, update loyalty
        if(this.hunger > 100) {this.hunger = 100;
        System.out.println(name+ " is HUNGRY!!");}
        if(this.hunger<1){this.hunger = 1;}
        setLoyalty(this.fun, (100-this.hunger));
    }

    //Getter for Name
    public String getName() { return name; }

    //Getter for Hunger
    public int getHunger() { return hunger; }

    //Setter for Fun
    public void setFun(int fun) {
        //Set Fun, Maintain Range, Update loyalty
        this.fun += fun;
        if(this.fun > 100){this.fun = 100;}
        if(this.fun<1){this.fun = 1;}
        setLoyalty(this.fun, (100-this.hunger));
    }

    //Getter for Fun
    public int getFun() { return fun; }

    //Setter Cleanliness
    public void setCleanliness(int cleanliness) {
        //Set Cleanliness, maintain range, display message when dirty
        this.cleanliness += cleanliness;
        if(this.cleanliness > 100) { this.cleanliness = 100;}
        if(this.cleanliness<1){this.cleanliness = 1;
        System.out.println(name+ " needs a bath! "); }
    }

    //Getter for Cleanliness
    public int getCleanliness() { return cleanliness; }

    //Getter toString
    public String toString()
    {
        return name + " has the following attributes: "
        + "\nCurrent Hunger Level (1-100): " + hunger+ "\nCurrent Cleanliness (1-100): " +cleanliness
        + "\nFun Level (1-100): " +fun+ "\nLoyalty (1-100): " +loyalty;
    }
}
