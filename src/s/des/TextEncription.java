/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s.des;

/**
 *
 * @author dell
 */
public class TextEncription {
keygeneration q=new keygeneration();
                String   ptleft=""; 
                String   ptri8="";    
                int[] p8={2,6,3,1,4,8,5,7};
                int[] pInv={4,1,3,5,7,2,8,6};
                int[] p8for4bit={4,1,2,3,2,3,4,1};
                int[] p4={2,4,3,1};
                String[][] so={
                    {"01","00","11","10"},
                    {"11","10","01","00"},
                    {"00","10","01","11"},
                    {"11","01","11","10"}

                };
                String[][] s1={
                    {"00","01","10","11"},
                    {"10","00","01","11"},
                    {"11","00","01","00"},
                    {"10","01","00","11"}

                };
    TextEncription(String PT,String key1,String key2) {
        run1(PT,key1,key2);


    }

    public  String convertP10(String key1,int[] p8){
       String p8key ="";
    for (int i = 0; i < p8.length; i++) {
     p8key =p8key + "" + Character.toString(key1.charAt(p8[i]-1));
            }
    return p8key;
     
}
    String  Xor(String key,String pt){
            String XorString="";
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)=='0' && pt.charAt(i)=='0' ){
                XorString+="0";
        }else if(key.charAt(i)=='1' && pt.charAt(i)=='1'){
                               XorString+="0";
 
                }else{
                                           XorString+="1";

        }
        }
        return XorString;
        
    }
     void run1(String PT,String key1,String key2) {
          String passedtop8=convertP10(PT, p8);
          
          for (int i = 0; i < 4; i++) {
                        ptleft+=passedtop8.charAt(i);
                        ptri8+=passedtop8.charAt(i+4);
         }
            passedtop8=convertP10(ptri8, p8for4bit);
          String Xorstring= Xor(key1,passedtop8);
          String p4=stable(Xorstring);
          String Xorp4=convertP10(p4, this.p4);
          String outputstringof1Sthalf= Xor(Xorp4, ptleft);
            run2(outputstringof1Sthalf,ptri8,key2);

     }

   public String stable(String Xorstring) {
       int a=0;
       int b=0;
   String p4="";
       String lrow="";
   String lcol="";

   String rrow="";
    String rcol="";

   lrow+=Xorstring.charAt(0)+""+Xorstring.charAt(3);
   lcol+=Xorstring.charAt(1)+""+Xorstring.charAt(2);

   rrow+=Xorstring.charAt(4)+""+Xorstring.charAt(7);
   rcol+=Xorstring.charAt(5)+""+Xorstring.charAt(6);
   
    switch (lrow) {
        case "00":
            a=0;
            break;
        case "01":
            a=1;
            break;
        case "10":
            a=2;
            break;
        case "11":
            a=3;
            break;
        default:
            break;
    }

    switch (lcol) {
        case "00":
            b=0;
            break;
        case "01":
            b=1;
            break;
        case "10":
            b=2;
            break;
        case "11":
            b=3;
            break;
        default:
            break;
    }
     p4+=so[a][b];

    switch (rrow) {
        case "00":
            a=0;
            break;
        case "01":
            a=1;
            break;
        case "10":
            a=2;
            break;
        case "11":
            a=3;
            break;
        default:
            break;
    }

    switch (rcol) {
        case "00":
            b=0;
            break;
        case "01":
            b=1;
            break;
        case "10":
            b=2;
            break;
        case "11":
            b=3;
            break;
        default:
            break;
    }
     p4+=s1[a][b];



     //  System.out.println(p4);
return p4;
   }

     

     void run2(String outputstringof1Sthalf, String ptri8,String key2) {
                        ptleft=ptri8;
                        this.ptri8=outputstringof1Sthalf;
          String  passedtop8=convertP10(this.ptri8, p8for4bit);
          String Xorstring= Xor(key2,passedtop8);
          String p4=stable(Xorstring);
          String Xorp4=convertP10(p4, this.p4);
          String outputstringof2ndhalf= Xor(Xorp4, ptleft);
          
         String totaloutputofbothhalf=outputstringof2ndhalf+""+outputstringof1Sthalf;
        String incriptedtext= convertP10(totaloutputofbothhalf, pInv);
         System.out.println("Encripted TExt="+incriptedtext);
     }
    
}
