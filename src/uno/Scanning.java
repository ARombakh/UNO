/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.Scanner;

/**
 *
 * @author artyom
 */
public class Scanning {
    private Scanner sc;
    private int output;
    
    public Scanning() {
        sc = new Scanner(System.in);
    }
    
    public int promptUser() {
        boolean running = true;
        while (running) {            
            try {
                System.out.println("Enter number:");
                output = Integer.parseInt(sc.nextLine());
                running = false;
            } catch (Exception e) {
                System.out.println("Wrong input! Input number, please");
            }
        }

        return output;
    }
}