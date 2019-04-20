/**
 * This is a number converter from Decimal to Binary
 *
 *@author James Rasekoala
 *@date 17/02/2019 
 */

import java.util.Scanner;
import java.lang.Math;


public class Converter{
    public static void main(String[] args) {
    int smalln[];
    int intVal=0;
    double D=0; // D to hold value from log
    double d=0; // D to store rounded up D
    String stringVal="defualt";  
    
    //Taking Input
    Scanner in = new Scanner(System. in);
    System. out. println("Enter a number");
    intVal = in.nextInt();
    System.out.println("You entered number "+intVal);
    System.out.println("Printing numbrt of bits Method "+bits(intVal));
    
    
    //initialising array. Each array is a row in the table
    //I use the index inside the loop to print in the correct row 
    int[] smallN = new int[bits(intVal)+1];
    int[] bigN = new int[bits(intVal)+1];
    int[] p = new int[bits(intVal)+1];
    boolean[] eq = new boolean[bits(intVal)+1];
    int[] binaryStorage = new int[bits(intVal)+1];
    int[] newN = new int[bits(intVal)+1];
    
    // calling binary method to fill up arrays for printing
    String binaryValue = binary(intVal,smallN ,bigN ,p , eq , binaryStorage ,newN );
    System.out.println("binary from method "+binaryValue); 
    System.out.print("____________ ");
    
    
    for(int j=0 ; bits(intVal)>=j;j++){
         System.out.print("____________");
    }
    System.out.println();  //print on newline after loop
    
    
    System.out.print("|     n     |"); //First Lable for Table 
    for (int i = bits(intVal); i >= 0; i--) {
         System.out.print(String.format("%1$10s", smallN[i])+" |");
    }
    System.out.println();


    System.out.print("|     N     |");
    for (int i = bits(intVal); i >= 0; i--) {
              System.out.print(String.format("%1$10s", bigN[i])+" |");
    }
    System.out.println();
   
   
   System.out.print("|    2^n    |");
   for (int i = bits(intVal); i >= 0; i--) {
             System.out.print(String.format("%1$10s", p[i])+" |");
   } 
   System.out.println();
 
 
   System.out.print("|  N >= 2^n |");
   for (int i = bits(intVal); i >= 0; i--) {
             System.out.print(String.format("%1$10s", eq[i])+" |");
   } 
   System.out.println();
 
 
   System.out.print("|     Bn    |");
   for (int i = bits(intVal); i >= 0; i--) {
           System.out.print(String.format("%1$10s", binaryStorage[i])+" |");
   } 
   System.out.println();
 
 
   System.out.print("|    n-1    |");
   for (int i = bits(intVal); i > 0; i--) {
         System.out.print(String.format("%1$10s", newN[i])+" |");
   } 
   System.out.print(String.format("%1$10s", "Negative")+" |");
   System.out.println();
 
 
   System.out.print("------------ ");
   for(int j=0 ; bits(intVal)>=j;j++){
         System.out.print("------------");
   }
   System.out.println();
   
   
   System.out.print("Binary conversion of the decimal "+intVal+" is : "+binaryValue);
      
   }
    
    
    public static String binary(int intVal, int[] smallN ,int[] bigN ,int[] p ,boolean[] eq ,int[] binaryStorage ,int[] newN ){
            /**
             *
             * This method does the calculation for filling up the 
             * Table with the correct values
             * 
             * This section of code is made as a method to allow the all information
             * to be available before printing of the table
             *
             * Method return a binary value
             * it sets the arrays used to fill up the table for each row
             *
             **/
    
           int N = intVal;
           int n = bits(intVal);
           int Bn=2;
           String binaryString="";
      
           while(n>=0){
                  if(N>=(int)Math.pow(2,n)){        
                         Bn=1;
                         smallN[n]=n;
                         bigN[n] = N;
                         p[n] = (int)Math.pow(2,n);
                         eq[n] = true;
                         binaryStorage[n] = Bn;
                         newN[n] = n-1;  
                         N=N-(int)Math.pow(2,n);
 
                   }else{
                         Bn=0;
                         N=N;
                         smallN[n]=n;
                         bigN[n] = N;
                         p[n] = (int)Math.pow(2,n);
                         eq[n] = false;
                         binaryStorage[n] = Bn;
                         newN[n] = n-1;
                   }
            n-=1;
            binaryString+=""+Bn;
         }
  return binaryString;
 }
    
    
 public static int bits(int intValm) {
        /**
        * This method does the calculates yhe number of bits needed 
        * which is can be used to determine my table length
        * but I determine table lenth ina different way 
        * 
        **/
        
        double Dm = Math.log(intValm)/Math.log(2);
        // round up D
        Dm = Math.ceil(Dm);
        Dm-=1;
        //Making sure am always return Dm int the form of int
        return((int)Dm);
   }
    

}