/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author donas11
 */
public class Treasure {
    private String name;
    private int goldCoins=0;
    private int minBonus=0;
    private int maxBonus=0;
    private TreasureKind type;
    Treasure(String n,int g,int min,int max,TreasureKind t){
        this.name=n;
        this.goldCoins=g;
        this.minBonus=min;
        this.maxBonus=max;
        this.type=t;
    }
    
    
    public String getName(){
        return this.name;
    
    }
    
    public int getGoldCoins(){
        return this.goldCoins;
    
    }
    
    public int getMinBonus(){
        return this.minBonus;
    
    }
    
    public int getMaxBonus(){
        return this.maxBonus;
    
    }
    
    public TreasureKind getType(){
        return this.type;
    
    }
    public String toString() {
        return "\nTesoro:" 
        + "\nNombre = " + name
        + "\nMonedas de Oro = " + Integer.toString(goldCoins)
        + "\nBonus Minimo = " + Integer.toString(minBonus)
        + "\nBonus Maximo = " + Integer.toString(maxBonus)
        + "\nTipo de Tesoro = " + type;
    }
    
    
    
}
