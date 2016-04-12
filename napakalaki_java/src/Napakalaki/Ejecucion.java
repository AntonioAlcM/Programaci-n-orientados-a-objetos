/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Napakalaki;

import Test.GameTester;
import GUI.*;
import java.util.ArrayList;
public class Ejecucion {
       
    public static void main(String[] args) {
      
      Napakalaki napakalakiModel = Napakalaki.getInstance();
      ArrayList<String> names=new ArrayList();
      NapakalakiView napakalakiView = new NapakalakiView();
      Dice.createInstance(napakalakiView);
      PlayerNamesCapture namesCapture=new PlayerNamesCapture(napakalakiView , true );
      names = namesCapture.getNames();
      napakalakiModel.initGame(names);
     
      napakalakiView.showView();
      napakalakiView.setNapakalaki(napakalakiModel);
      Napakalaki game = Napakalaki.getInstance();
      GameTester test = GameTester.getInstance();
    
      
      // Poner el numero de jugadores con el que se quiera probar
      
              
    }
}

