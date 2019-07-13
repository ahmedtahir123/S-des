/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.des;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class SDes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
         
        
            System.out.println("Enter 10 bit key");
            
            Scanner s=new Scanner(System.in);
            String key=s.nextLine();
            
            keygeneration p=new keygeneration(key);
            
           
    }





}
