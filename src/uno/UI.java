/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.ArrayList;

/**
 *
 * @author artyom
 */
public class UI {   
    public Action askAction(ArrayList<MenuItem> menu) {
        int option;
        Scanning sca = new Scanning();
        
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i));
        }
        
        System.out.println("Select menu item:");
        option = sca.promptUser();
        
        return menu.get(option).getAction();
    }
}