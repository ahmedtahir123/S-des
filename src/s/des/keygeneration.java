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
public class keygeneration {

            String key1 ="";
            String key2 ="";
            String alpha="";
            int[] p10={3,5,2,7,4,10,1,9,8,6};
            int[] p8={6,3,7,4,8,5,10,9};
            
           // convertP10toP8(convertP10(key,p10,p8),p10,p8,key);
 public keygeneration() {
    
    }
            
    public keygeneration(String key) {
run(key);
    
    }
           
      void run(String key){
          String passedtop10=convertP10(key, p10, p8);
              String ls1=(rotate(passedtop10));
               key1=convertP10toP8(ls1, p8, p10);

              String ls2=(rotate(ls1));
              ls2=(rotate(ls2));
              key2=convertP10toP8(ls2, p8, p10);
                          // System.out.println("key1="+key1);
                
              //  System.out.println("key2="+key2);

       System.out.println("Enter 8 bit key");
            
       Scanner  s=new Scanner(System.in);
             key=s.nextLine();
             
             TextEncription PT=new TextEncription(key,key1,key2);
        
      
      
      }      
      
            
            
public  String convertP10(String key1,int[] p10,int[] p8){
       String p8key ="";
    for (int i = 0; i < 10; i++) {
     p8key =p8key + "" + Character.toString(key1.charAt(p10[i]-1));
            }
    return p8key;
     
}
        
    public   String convertP10toP8(String key,int[] p8,int[] p10){
    alpha="";
        for (int i = 0; i < 8; i++) {
     alpha   =alpha + "" + key.charAt(p8[i]-1);
            }
                return alpha;
}

public String rotate(String p8key){
    String temp=Character.toString(p8key.charAt(0));    
    String temp1=Character.toString(p8key.charAt(5));

    String[] c=p8key.split("");

    for (int i = 0; i < 10; i++) {
        if(i==4){
            c[i]=temp;
        }else if(i==9){
            c[i]=temp1;
        }else
        c[i]=c[i+1];

    }
     String ls1=""; 
    for (int i = 0; i < c.length; i++) {
  ls1 =ls1 + c[i];
}
    
    System.out.println("");
    
      return ls1;
}

}