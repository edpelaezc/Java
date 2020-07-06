/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;
import java.util.Scanner;        

/**
 *
 * @author edanP
 */
public class Fibonacci {

    static int fibonacci(int n) {
        return (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner buffer = new Scanner(System.in);
        System.out.println("Ingrese el número: ");
        int input = Integer.parseInt(buffer.nextLine());
        int response = fibonacci(input);
        System.out.println("Secuencia de finbonacci: " + response);
    }       
}
