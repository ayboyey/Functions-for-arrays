package lab04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPack {
	
	public static Random rand = new Random();
	
	public static void main(String[] args) {
		
		ArrayPack ArrayPack = new ArrayPack();
		
		
		/*
		 * Scanner input, show array, and Appending testing
		 */
		System.out.print("# TEST 1 - Scanner and show array#\n");
		Scanner sc = new Scanner(System.in);
		int[] testArr = readArray(sc);
		showArray(testArr);
		
		
		/*
		 * Array Properties Testing
		 */
		// appendArrays();
		int[] arrPropTest1 = {-50, -12, 0, 9, 12, 15};
		int[] arrPropTest2 = {22, 45, 90, 125, 155, 200};
		int[] arrMerged = appendArrays(arrPropTest1, arrPropTest2);
		
		// getMaximalElement(); & getMinimalElement();
		int arrMergedMaxVal = ArrayPack.getMaximalElement(arrMerged);
		int arrMergedMinVal = ArrayPack.getMinimalElement(arrMerged);
		
		// getGreaterThan(); & getLessThan();
		int greaterThanVal = 20;
		int lesserThanVal = 10;
		int[] arrMergeGreatThan = ArrayPack.getGreaterThan(arrMerged, greaterThanVal);
		int[] arrMergeLessThan = ArrayPack.getLessThan(arrMerged, lesserThanVal);
		
		// getRange();
		int rangeMaxTest = 20;
		int rangeMinTest = 10;
		int[] arrMergedRange = ArrayPack.getRange(arrMerged, rangeMinTest,rangeMaxTest);
		
		// isAnElement();
		int[] elementsTestArr = {-10, -10, 5, 5, 15, 15, 25, 35, 45, 45};
		int testForElement1 = 12;
		int testForElement2 = 15;
		boolean testResult1 = ArrayPack.isAnElement(elementsTestArr, testForElement1);
		boolean testResult2 = ArrayPack.isAnElement(elementsTestArr, testForElement2);
		
		// uniqueElements(); & commonElements();
		int[] recArray1 = {2, 5, 14, 14, 87};
		int[] recArray2 = {9, 6, 7, 5, 87};
		int[] uniqueElemArray = uniqueElements(recArray1, recArray2);
		int[] commonElemArray = commonElements(recArray1, recArray2);
		
		
		/*
		 * Print output
		 */
		System.out.print("\n\n# TEST 2 - Array methods #\n");
		System.out.print("\tArray 1: ");
		showArray(arrPropTest1);
		System.out.print("\tArray 2: ");
		showArray(arrPropTest2);
		System.out.print("\t* Merged Arrays: ");
		showArray(arrMerged);
		System.out.println("\n\tUsing the Merged Array to test: ");
		System.out.println("\t* Max value: " + arrMergedMaxVal);
		System.out.println("\t* Min value: " + arrMergedMinVal);
		System.out.println("\t* Greater than (" + greaterThanVal + "): " + Arrays.toString(arrMergeGreatThan));
		System.out.println("\t* Lesser than (" + lesserThanVal + "): " + Arrays.toString(arrMergeLessThan));
		System.out.println("\t* Range from (" + rangeMinTest + ") to (" + rangeMaxTest + "): " + Arrays.toString(arrMergedRange));
		
		System.out.print("\n\n# Test 3 - Array elements Exist #\n");
		System.out.println("\tTesting array: " + Arrays.toString(elementsTestArr));
		System.out.println("\t* Does number (" + testForElement1 + ") exist? : " + testResult1);
		System.out.println("\t* Does number (" + testForElement2 + ") exist? : " + testResult2);
		
		System.out.print("\n\n# Test 4 - Array element recurrence #\n");
		System.out.println("\tArray 1: " + Arrays.toString(recArray1));
		System.out.println("\tArray 2: " + Arrays.toString(recArray2));
		System.out.println("\t* Unique Elements: " + Arrays.toString(uniqueElemArray));
		System.out.println("\t* Common Elements: " + Arrays.toString(commonElemArray));
		
	}
	
	public static int[] readArray(Scanner sc) {
		
		int arrayLength = 0;
		int currentInt = 0;
		int counter = 0;
		
		System.out.print("Input array Length: ");
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				// Input array size
				arrayLength = sc.nextInt();
				System.out.println("Length set to [ " + arrayLength + " ]");
				break;
			} else {
				// Skip non integers
				sc.nextLine();
			}
		}
		
		System.out.println("Input [ " + arrayLength + " ] integers for array. - Type \"random\" to fill randomly: ");
		int[] tempArray = new int[arrayLength];
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				// Insert integer
				currentInt = sc.nextInt();
				tempArray[counter] = currentInt;
				counter++;
				if (counter == arrayLength) {
					break;
				}
			} else if (sc.hasNext("random")) {
				// Random array fill
				for (int i = counter; i < arrayLength; i++) {
					tempArray[i] = randomInt(0,100);
				}
				break;
			} else {
				// Skip non integers
				sc.nextLine();
			}
		}
		
		return tempArray;
		
	}
	
	public static int[] appendArrays(int[] a1, int[] a2) {
		int newArrayLength = a1.length + a2.length;
		int[] newArray = new int[newArrayLength];
		// Join first array
		for (int i = 0; i < a1.length; i++) {
			newArray[i] = a1[i];
		}
		// Join second array
		int secondCounter = 0;
		for (int i = a1.length; i < a1.length + a2.length; i++) {
			newArray[i] = a2[secondCounter];
			secondCounter++;
		}
		// Return the result
		return newArray;
	}
	
	public int getMaximalElement(int[] inputArray) {
		int maxInt = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > maxInt) {
				maxInt = inputArray[i];
			}
		}
		System.out.println("max element" +  maxInt);
		return maxInt;
	}
	
	public int getMinimalElement(int[] inputArray) {
		int minInt = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < minInt) {
				minInt = inputArray[i];
			}
		}
	System.out.println("min element "  +   minInt);
		return minInt;
	}
	
	public int[] getGreaterThan(int[] inputArray, int limit) {
		// Find greater integers amount for array size
		int greaterArrLength = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > limit) {
				greaterArrLength++;
			}
		}
		// Create array and fill those values
		int[] greaterArr = new int[greaterArrLength];
		int greaterCounter = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > limit) {
				greaterArr[greaterCounter] = inputArray[i];
				greaterCounter++;
			}
		}
		return greaterArr;
	}
	
	public int[] getLessThan(int[] inputArray, int limit) {
		// Find integer amount for array size
		int lesserArrLength = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < limit) {
				lesserArrLength++;
			}
		}
		// Create array and fill those values
		int[] lesserArr = new int[lesserArrLength];
		int lesserCounter = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < limit) {
				lesserArr[lesserCounter] = inputArray[i];
				lesserCounter++;
			}
		}
		return lesserArr;
	}
	
	public int[] getRange(int[] inputArray, int lowerLimit, int upperLimit) {
		// Find integer amount for array size
		int rangeArrLength = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > lowerLimit && inputArray[i] < upperLimit) {
				rangeArrLength++;
			}
		}
		// Create array and fill those values
		int[] rangeArr = new int[rangeArrLength];
		int rangeCounter = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > lowerLimit && inputArray[i] < upperLimit) {
				rangeArr[rangeCounter] = inputArray[i];
				rangeCounter++;
			}
		}
		return rangeArr;
	}
	
	public boolean isAnElement(int[] inputArray, int lookFor) {
		boolean found = false;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == lookFor) {
				found = true;
			}
		}
		return found;
	}
	
	public static int[] uniqueElements(int[] a1, int[] a2) {
		ArrayList<Integer> uniqueElements = new ArrayList<Integer>();
		// Compare first array
		boolean isUnique = true;
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				// Duplicate found
				if (a1[i] == a2[j]) {
					isUnique = false;
				}
				// If no duplicate found at end
				if (j == a2.length - 1 && isUnique == true) {
					// Check for duplicates within self
					boolean duplicateWithin = false;
					for (int k = 0; k < a1.length - 1; k++) {
						for (int z = 1; z < a1.length; z++) {
							if (a1[k] == a1[z]) {
								duplicateWithin = true;
							}
						}
					}
					if (duplicateWithin == false) {
						uniqueElements.add(a1[i]);
					}
					// reset
					duplicateWithin = false;
					isUnique = true;
				}
			}
			// reset
			isUnique = true;
		}
		// Compare second array
		isUnique = true;
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a1.length; j++) {
				// Duplicate found
				if (a2[i] == a1[j]) {
					isUnique = false;
				}
				// If no duplicate found at end
				if (j == a1.length - 1 && isUnique == true) {
					uniqueElements.add(a2[i]);
					// reset
					isUnique = true;
				}
			}
			// reset
			isUnique = true;
		}
		// Convert to primitive
		int[] uniquePrim = new int[uniqueElements.size()];
		for (int i = 0; i < uniquePrim.length; i++) {
			uniquePrim[i] = uniqueElements.get(i);
		}
		return uniquePrim;
	}
	
	public static int[] commonElements(int[] a1, int[] a2) {
		ArrayList<Integer> commonElements = new ArrayList<Integer>();
		// Compare arrays
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				// Duplicate found
				if (a1[i] == a2[j]) {
					commonElements.add(a1[i]);
				}
			}
		}
		// Convert to primitive
		int[] uniquePrim = new int[commonElements.size()];
		for (int i = 0; i < uniquePrim.length; i++) {
			uniquePrim[i] = commonElements.get(i);
		}
		return uniquePrim;
	}
	
	public static void showArray(int[] inputArray) {
		if (inputArray.length != 0) {
			System.out.print("[ ");
			for ( int i = 0; i < inputArray.length; i++) {
				if ( i != inputArray.length - 1) {
					System.out.print(inputArray[i] + " , ");
				} else {
					System.out.print(inputArray[i]);
				}
			}
			System.out.println(" ]");
		} else {
			System.out.println("[ Empty array ]");
		}
	}
	
	public static int randomInt(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	
}