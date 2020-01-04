import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @Author: Kevin Chung
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Factorial Calculator!\n");

		int numInput = 0;
		long calculatedFactorial = 1;
		String toContinue = "";
		boolean validInteger = false;

		do {
			while (!validInteger) {
				// 20 is the highest integer that returns accurate factorial calculation, before
				// the calculation displays as a negative number
				System.out.println("Enter an integer that's greater than 0 but less than 21:");

				try {
					numInput = scan.nextInt();
					if (numInput < 0 || numInput > 20) {
						System.out.println("Integer must be greater than 0 but less than 21:\n");
					} else {
						validInteger = true;
					}
				} catch (InputMismatchException e) {
					System.out.println(
							"Please enter an integer that is greater than 0 but less than 21, and does not include decimals or letters.\n");
					scan.nextLine();
				}
			}

			System.out.println("The factorial of " + numInput + " is " + calcFactorial(numInput) + ".\n");

			// This will calculate the factorial if we don't use the recursive method
//			for (int i = 1; i <= numInput; i++) {
//				calculatedFactorial *= i;
//			}
//			System.out.println("The factorial of " + numInput + " is " + calculatedFactorial + ".\n");

			scan.nextLine();

			System.out.println("Would you like to continue? (y/n):");

			toContinue = scan.nextLine().toLowerCase();

			// Resets the calculated number if user wants to continue the calculations without using the recursive method
			// calculatedFactorial = 1;

			// Resets the loop condition
			validInteger = false;

		} while (!toContinue.startsWith("n"));

		System.out.println("Have a nice day!");
		
		scan.close();
	}

	public static long calcFactorial(int numInput) {
		if (numInput == 1) {
			return 1;
		}

		return calcFactorial(numInput - 1) * numInput;
	}

}
