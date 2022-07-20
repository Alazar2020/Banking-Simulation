package com.alazarbank.utility;

import java.util.Scanner;

public class InputUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int getIntChoice(int max) {
		int inputValue;
		

		do {
			while(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("         Please enter a whole number.");
			}
			

			inputValue = scanner.nextInt();
			scanner.nextLine();
			

			if(inputValue <= 0 || inputValue > max) {
				System.out.println("         Please enter a number between 1 and " + max);
			}
			
		} while(inputValue < 0 || inputValue > max);


		return inputValue;
	}
	
	public static double getDoubleInput(int max) {
		double inputValue;
		

		do {
			while(!scanner.hasNextDouble()) {
				scanner.nextLine();
				System.out.println("         Please enter a number.");
			}
			

			inputValue = scanner.nextDouble();
			scanner.nextLine();
			

			if(inputValue <= 0 || inputValue > max) {
				System.out.println("          Please enter a number between 1 and " + max);
			}
			
		} while(inputValue < 0 || inputValue > max);

		return inputValue;
	}
	
	public static String getStringInput(int max) {
		String input;
		
		while(true) {
			input = scanner.nextLine();
			
			input = input.trim();
			if(input.length() == 0){
				System.out.println("         String has no content");
				continue;
			}
			
			if(input.length() > max){
				System.out.println("         Enter string less than" + max);
				continue;
			}
			
			return input;
		}
	}
}
