/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author donas11
 */
public class Prize {
    private int treasures=0; 
    private int level=0;
    
    public Prize(int treasures, int level){
        this.treasures=treasures;
        this.level=level;
    }
    
    public int getTreasures(){
        return treasures;
    } 
    
    public int getLevels(){
        return level;
    }
    
    public String toString(){
        return "     - Treasures = " + Integer.toString(treasures) + "\n     - levels = " + Integer.toString(level);
    }
}