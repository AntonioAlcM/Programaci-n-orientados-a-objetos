/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author antonio
 */
public class Monster {
    private String name;
    private int combatlevel=0;
    private Prize price;
    private BadConsequence bc;
    
    public Monster(String name, int level, BadConsequence bc, Prize price){
        this.name=name;
        this.combatlevel=level;
        this.bc=bc;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public int getCombatlevel(){
        return combatlevel;
    }
    
    public BadConsequence getBadConsecuence(){
        return bc;
    }
    public int getLevelsGained(){
        return price.getLevels();
    }
    public int getTreasuresGained(){
        return price.getTreasures();
    }
    
    public boolean kills(){
        return bc.myBadConsequeseIsDeath();
    }
    
    
      
   
    public String toString(){
      return "\nNombre del Monstruo: "+ name + " \nlevel= "+Integer.toString(combatlevel) + "\n"
              +" \n   Buen rollo:\n" + price +"\n" 
              + " \n   Mal rollo:\n" +bc + "\n__________________________________";
  }
    
}