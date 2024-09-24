/**
 * @Placed demo
 */
package demo;

import java.util.Scanner;

/**
 * @author mrangasamy
 *
 * @date 22-Jan-2024
 */
public class CalculatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
        int n1 = ip.nextInt();
        System.out.println("Enter Number 2");
        int n2 = ip.nextInt();
        System.out.println("Addition: " + (n1 + n2));


	}

}
