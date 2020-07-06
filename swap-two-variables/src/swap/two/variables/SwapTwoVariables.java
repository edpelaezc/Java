/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap.two.variables;

/**
 *
 * @author edanP
 */
public class SwapTwoVariables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1 = 10, num2 = 20;
        System.out.println("Before swap: " + num1 + ", " + num2);
        
        int temp = num1; 
        num1= num2;
        num2 = temp;
        
        System.out.println("After swap: " + num1 + ", " + num2);
    }
    
    static void swap(int num1, int num2) {

    }
    
}
