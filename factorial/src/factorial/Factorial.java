/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;
import java.util.Scanner;   
/**
 *
 * @author edanP
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner buffer = new Scanner(System.in);
        System.out.println("Calcular el factorial de: ");
        int num = Integer.parseInt(buffer.nextLine());
        int fact = factorial(num);
        System.out.println(fact);                
    }
    
    static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
