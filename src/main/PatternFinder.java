// NAME: JADONMICHAEL DE JESUS
// Every single miner method in the main class works and will find the specified pattern

package main;

import util.*;

import java.util.*;

public class PatternFinder {
    private static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase letters.
	Random random = new Random(System.nanoTime());
	char[] array = new char[length];
	for (int i = 0; i < length; i++)
	    array[i] = (char) ('a' + random.nextInt(26));
	return new String(array);
    }

    private static void singletonMiner(String mine, int length) throws SingletonException{
	for (int start = 0; start <= mine.length() - length; start++) {
		int i;
	    for (i = start + 1; i < start + length; i++)
			if (mine.charAt(i) != mine.charAt(i - 1))
				break;
			if (i == start + length)
				throw new SingletonException(mine.substring(start, start + length), start);
		}
    }

	private static void firstArithmeticMiner(String mine, int length) throws FirstArithmeticException{
		for(int start = 0; start <= mine.length() - length; start++){
			char sorted[] = new char [length];

			for(int i = start; i < start + length; i++){
				sorted[i - start] = mine.charAt(i);
			}

			Arrays.sort(sorted);

			for(int i = start; i < start + length; i++){
				if(sorted[i - start] != mine.charAt(i)){
					break;
				}

				if(i == start + length - 1){
					for(int j = 0; j < sorted.length - 1; j++){
						if((int)sorted[j] + 1 != (int) sorted[j + 1]){
							break;
						}

						if(j == sorted.length - 2){
							throw new FirstArithmeticException(mine.substring(start, start + length), start);
						}
					}
				}
			}
		}
	}

	private static void secondArithmeticMiner(String mine, int length) throws SecondArithmeticException{
		for(int start = 0; start <= mine.length() - length; start++){
			char sorted[] = new char [length];

			for(int i = start; i < start + length; i++){
				sorted[i - start] = mine.charAt(i);
			}

			Arrays.sort(sorted);

			for(int i = start; i < start + length; i++){
				if(sorted[length - (i-start) - 1] != mine.charAt(i)){
					break;
				}

				if(i == start + length - 1){
					for(int j = 0; j < sorted.length - 1; j++){
						if((int)sorted[j] + 1 != (int) sorted[j + 1]){
							break;
						}

						if(j == sorted.length - 2){
							throw new SecondArithmeticException(mine.substring(start, start + length), start);
						}
					}
				}
			}
		}
	}

	private static void tripartiteMiner(String mine, int length) throws TripartiteException{
		for(int start = 0; start <= mine.length() - (3 * length); start++){
			for(int i = start; i < start + (3 * length); i++){
				if(!mine.substring(start, start + length).equals(mine.substring(start + length, start + length + length))){
					break;

				}

				if(i == start + (3 * length - 1)){
					if(mine.substring(start, start + length).equals(mine.substring(start + (2 * length), start + (3 * length)))){
						throw new TripartiteException(mine.substring(start, start + (3 * length)), start);
					}
				}
			}
		}

	}

	private static void bipartiteMiner(String mine, int length) throws BipartiteException{
		for(int start = 0; start <= mine.length() - (2 * length); start++){
			for(int i = start; i < start + length; i++){
				if(!mine.substring(start, start + length).equals(mine.substring(start + length, start + length + length))){
					break;
				}

				if(i == start + length - 1){
					throw new BipartiteException(mine.substring(start, start + length + length), start);
				}
			}
		}

	}

	private static void palindromeMiner(String mine, int length) throws PalindromeException{
		if(length % 2 == 0) {
			for (int start = 0; start <= mine.length() - (2 * length); start++) {
				int x = start;
				int y = start + length + length - 1;
				while (x < y) {
					if (mine.charAt(x) != mine.charAt(y)) {
						break;
					}
					x++;
					y--;
				}
				if (!(x < y)) {
					throw new PalindromeException(mine.substring(start, start + length + length), start);
				}
			}
		} else {
			for (int start = 0; start <= mine.length() - (2 * length) - 1; start++) {
				int x = start;
				int y = start + length + length;
				while (x < y) {
					if (mine.charAt(x) != mine.charAt(y)) {
						break;
					}
					x++;
					y--;
				}
				if (!(x < y)) {
					throw new PalindromeException(mine.substring(start, start + length + length + 1), start);
				}
			}
		}
	}

    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);


	//Step 1: handling input...

	System.out.println("Enter the length of the maximum pattern: ");
	int patternMaxLength = 0; 		//you need to update this part so that the value is given by the user via keyboard!

		while(true){
			patternMaxLength = keyboard.nextInt();
			if (patternMaxLength >= 3 && patternMaxLength <= 15)
					break;
			else {
				System.out.println("Please enter a number between 3 and 15");
				continue;
			}
			}

	System.out.println("Enter the length of random string: ");
	int randomStringLength = 0;
	while (true) {
		randomStringLength = keyboard.nextInt();
		try {
			if (randomStringLength < 100000 || randomStringLength > 1000000000)
				throw new NumberFormatException();
	    } catch (InputMismatchException e) {
			System.out.println("A non-integer value entered! Try again!");
			continue;

	    } catch(NumberFormatException e){
			System.out.println("Out of range! Try again!");
			continue;
		}
		break;
	}
	//Step 2: generating random string...
	String randomString = randomStringGenerator(randomStringLength);
	//Step 3: finding the interesting patterns
    	try {
    	    for (int length = patternMaxLength; length > 0; length--)
				singletonMiner(randomString, length);
			for (int length = patternMaxLength; length > 0; length--)
				firstArithmeticMiner(randomString, length);
			for (int length = patternMaxLength; length > 0; length--)
				secondArithmeticMiner(randomString, length);
			for (int length = patternMaxLength; length > 0; length--)
				tripartiteMiner(randomString, length);
			for (int length = patternMaxLength; length > 0; length--)
				bipartiteMiner(randomString, length);
			for (int length = patternMaxLength; length > 0; length--)
				palindromeMiner(randomString, length);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
		}
    }
}
