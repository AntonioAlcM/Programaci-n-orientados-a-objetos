/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author antonio
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Monster> monstruos= new ArrayList();
        
        System.out.println("\nMonstruos con nivel de combate superior a 10");
        System.out.println("==============================================");
        for(Monster monster:monstruos){
            int level=0;
            level=monster.getCombatlevel();
            if(level>10)
                System.out.println(monster);
        }
        
         
        System.out.println("\n\nMonstruos que solo te quitan niveles");
        System.out.println("======================================");
        for(Monster monster:monstruos){
            int perdidaNiveles=0, TesorosVisibles=0 , TesorosOcultos=0;
            perdidaNiveles=monster.getBadConsecuence().getLevels();
            TesorosVisibles=monster.getBadConsecuence().getNVisibleTreasures();
            TesorosOcultos=monster.getBadConsecuence().getNHiddenTreasures();
            if(perdidaNiveles>0 && TesorosVisibles==0 & TesorosOcultos==0)
                System.out.println(monster);
       
        }
        
         System.out.println("\n\nMonstruos que te hacen ganar mas de un nivel");
         System.out.println("==============================================");
         for(Monster monster:monstruos){
            int Niveles=0;   
            Niveles=monster.getLevelsGained();
            if(Niveles > 1 )
                System.out.println(monster);
       
        }
         
         System.out.println("\n\nMonstruos que te hacen perder un tipo de  tesoro");
         System.out.println("==================================================");
         for(Monster monster:monstruos){
            int TesorosVisibles=0 , TesorosOcultos=0; 
            TesorosVisibles=monster.getBadConsecuence().getSpecificVisibleTreasures().size();
            TesorosOcultos=monster.getBadConsecuence().getSpecificHiddenTreasures().size();
            if(TesorosVisibles > 0  || TesorosOcultos > 0 )
                System.out.println(monster);
       
        }
        System.out.println("\n_____________________________________________\n");
        
        
        
        
}
}    