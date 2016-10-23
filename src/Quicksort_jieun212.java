/* TCSS 343, Summer 2016
 * HW3 - 2.3 Programming - Quicksort
 * 
 * Jieun Lee (jieun212@uw.edu)
 */

import java.util.Random;

public class Quicksort_jieun212 {

	public static void main(String[] args) {
		
		// executes
		excuete();

		
		// tests pivot1st() and pivotMid()
//		testQuicksort();
	}
	
	
	/**
	 * Execute Quicksortxxx() and SafeQuicksortxxx()
	 */
	public static void excuete() {
		// #3. Execute Quicksort1st and QuicksortMid for successive posers of 10;
		
		for(int i = 0; i < 85; i++) { System.out.print("="); }
		System.out.printf("\n\t\t%s\t\t|\t%s\n", "Quicksort1st", "QuicksortMid");
		System.out.printf("\t\t%s\t%s\t|\t%s\t%s\n", "Unsorted", "Sorted", "Unsorted", "Sorted");
		
		for(int i = 0; i < 85; i++) { System.out.print("-"); }
		System.out.println();
		
		for (int i = 10000; i <= 10000000; i *= 10) {
			System.out.printf("%s%,d", "n=", i);
			
			// executes Quicksort1st() and  QUicksortMid()
			// with input size, n = 10,000 / 100,000 /1,000,000 / 10,000,000 
			executeQuicksort(i);
		}
		
		for(int i = 0; i < 85; i++) { System.out.print("="); }
		System.out.printf("\n\n");
		
		
		
		// #4.(Bonus) Execute SafeQuicksort1st and SafeQuicksortMid.
		
		for(int i = 0; i < 85; i++) { System.out.print("=");}
		System.out.printf("\n\t\t%s\t\t|\t%s\n", "SafeQuicksort1st", "SafeQuicksortMid");
		System.out.printf("\t\t%s\t%s\t\t|\t%s\t%s\n", "Unsorted", "Sorted", "Unsorted", "Sorted");
		
		for(int i = 0; i < 85; i++) {System.out.print("-");}
		System.out.println();
		
		for (int i = 10000; i <= 10000000; i *= 10) {
			System.out.printf("%s%,d", "n=", i);
			
			// executes SafeQuicksort1st() and  SafeQUicksortMid()
			// with input size, n = 10,000 / 100,000 /1,000,000 / 10,000,000 
			executeSafeQuicksort(i);
		}
		
		for(int i = 0; i < 85; i++) {System.out.print("=");}
	}
	
	
	


	
	/*
	 * #1. Two version of the Pivot procedure for the Quicksort algorithm.
	 */

	/**
	 * Version 1. takes 1st element a[1] of the input array as pivot. 
	 * It returns index of pivot on array a[].
	 */
	public static int Pivot1st(Comparable[] a, int l, int r) {
		
		// takes 1st element of a[] as a pivot
		Comparable p = a[l];

		// swaps index of l element with index of j element.
		swap(a, l, r);

		int i = l - 1;
		int j = r;

		// repeats until index i is less than the last element.
		while (i < j) {
			// increases the position i until i-th element is less than pivot.
			do {
				i++;
			} while (i < r && a[i].compareTo(p) <= 0 );

			// decreases the position j until j-th element is less than pivot.
			do {
				j--;
			} while (j > l && a[j].compareTo(p) >= 0);
	
			if (i >= j) break;
			
			// swaps i-th element with j-th element.
			swap(a, i, j);
		}

		// swaps the last element and the i-th element.
		swap(a, i, r);
		
		// returns the index of the pivot
		return i;
	}
	

	/**
	 * Version 2. It takes the middle element a[(l+r)/2] as pivot. It returns
	 * index p on array a[].
	 */
	public static int PivotMid(Comparable[] a, int l, int r) {	
		// takes the middle element of a[] as a pivot
		int m = (l+r)/2;
		Comparable p = a[m];

		// swaps index of the middle element with index of j element.
		swap(a, m, r);

		int i = l - 1;
		int j = r;

		// repeats until index i is less than j.
		while (i < r) {
			// increases the position i until i-th element is less than pivot.
			do {
				i++;
			} while (i < r && a[i].compareTo(p) <= 0 );

			// decreases the position j until j-th element is less than pivot.
			do {
				j--;
			} while (j > l && a[j].compareTo(p) >= 0);
	
			if (i >= j) break;
			
			// swaps i-th element with j-th element.
			swap(a, i, j);
		}

		// swaps the last element and the i-th element.
		swap(a, i, r);
		
		// returns the index of the pivot
		return i;
	}
	
	/**
	 * Helper method for swapping two elements of the given array.
	 * @param a The array.
	 * @param x The element.
	 * @param y The other element.
	 */
	private static void swap(Comparable[] a, int x, int y) {
		Comparable temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * Given method for question 1 - Recursive Quicksort1st().
	 */
	public static void Quicksort1st(Comparable[] a, int l, int r) {
		if (r > l) {
			int p = Pivot1st(a, l, r);
			Quicksort1st(a, l, p - 1);
			Quicksort1st(a, p + 1, r);
		}
	}

	/**
	 * Given method for question 1 - Recursive Quicksort1st().
	 */
	public static void Quicksort1st(Comparable[] a) {
		Quicksort1st(a, 0, a.length - 1);
	}
	
	

	/**
	 * Given method for question 1 - Recursive QuicksortMid().
	 */
	public static void QuicksortMid(Comparable[] a, int l, int r) {
		if (r > l) {
			int p = PivotMid(a, l, r);
			QuicksortMid(a, l, p - 1);
			QuicksortMid(a, p + 1, r);
		}
	}

	/**
	 * Given method for question 1 - Recursive QuicksortMid().
	 */
	public static void QuicksortMid(Comparable[] a) {
		QuicksortMid(a, 0, a.length - 1);
	}

	
	
	
	
	
	/* #2. Write execution programs for Quicksort1st() and QuicksortMid(): 
	 * a) create 2 copies a1st[] and amid[] of random array of n integers 
	 * b) sorts them by invoking respectively the Quicksort1st & QuicksortMid 
	 * c) outputs the time needed for each of these 2 calls 
	 * d) calls the same methods again on the sorted arrays 
	 * e) outputs the time needed for each of these 2 calls.
	 * 
	 * #3. Execute Quicksort1st() and QuicksortMid().
	 */
	/**
	 * Executes Quicksort1st() and QuicksortMid() with given n element of the list.
	 * @param n The number of element of the list to be sorted.
	 */
	public static void executeQuicksort(int n) {

		// creates 2 copies a1st[] and amid[] of random array of n integers
		Random r = new Random();
		Comparable[] a1st = new Comparable[n];
		Comparable[] aMid = new Comparable[n];
		
		for (int i = 0; i < n; i++) {
			a1st[i] = r.nextInt(n);
		}
		aMid = a1st;			

		// calls excuteQuicksort1st() to execute Quicksort1st()
		if (n <= 10000) {
			executeQuicksort1st(a1st);
		} else {
			System.out.printf("\t%s  |","--StackOverFlowError--");
		}
		
		// calls excuteQuicksortMid()  to execute QuicksortMid()
		if (n <= 10000000) {
			executeQuicksortMid(aMid);
		} else {
			System.out.printf("\t%s", "OutOfMemoryError: Java heap space");
		}
		System.out.println();
	}
	
	
	/**
	 * Helper method to execute Quicksort1st() with given list.
	 * @param a1st The list.
	 * @param n The number of elements of the list.
	 */
	private static void executeQuicksort1st(Comparable[] a1st) {
		
		// records execution time for Quicksort1st - Unsorted list
		long unsorted1stStart = System.currentTimeMillis();
		Quicksort1st(a1st);
		long unsorted1stEnd = System.currentTimeMillis();
		
		// records execution time for Quicksort1st - Sorted list
		long sorted1stStart = System.currentTimeMillis();
		Quicksort1st(a1st);
		long sorted1stEnd = System.currentTimeMillis();
		
		// Prints the execution times - Quicksort1st
		System.out.printf("\t%d %s\t\t%d %s\t|",
							(unsorted1stEnd - unsorted1stStart), "ms",
							(sorted1stEnd - sorted1stStart), "ms");
	}
	
	/**
	 * Helper method to execute QuicksortMid() with given list.
	 * @param a1st The list.
	 * @param n The number of elements of the list.
	 */
	private static void executeQuicksortMid(Comparable[] aMid) {

		// records execution time for QuicksortMid - Unsorted list
		long unsortedMidStart = System.currentTimeMillis();
		QuicksortMid(aMid);
		long unsortedMidEnd = System.currentTimeMillis();
		
		// records execution time for QuicksortMid - Sorted list
		long sortedMidStart = System.currentTimeMillis();
		QuicksortMid(aMid);
		long sortedMidEnd = System.currentTimeMillis();

		// Prints the execution times - QuicksortMid
		System.out.printf("\t%d %s\t\t%d %s",
							(unsortedMidEnd - unsortedMidStart), "ms",
							(sortedMidEnd - sortedMidStart), "ms");
	}
	
	
	
	
	
	
	/*
	 * #4. Execute SafeQuicksort1st() and SafeQuicksortMid().
	 */
	
	/**
	 * Executes SafeQuicksort1st() and SafeQuicksortMid() with given n element of the list.
	 * @param n The number of element of the list to be sorted.
	 */
	public static void executeSafeQuicksort(int n) {

		// creates 2 copies a1st[] and amid[] of random array of n integers
		Random r = new Random();
		Comparable[] a1st = new Comparable[n];
		Comparable[] aMid = new Comparable[n];
		
		for (int i = 0; i < n; i++) {
			a1st[i] = r.nextInt(n);
		}
		aMid = a1st;			
		
		// calls excuteQuicksort1st() to execute SafeQuicksort1st()
		if (n <= 100000) {
			executeSafeQuicksort1st(a1st);
		} else {
			System.out.printf("\t%s  \t|","--takes too long time--");
		}
		
		// calls excuteQuicksortMid() to execute SafeQuicksort1st()
		executeSafeQuicksortMid(aMid);
	}
	
	/**
	 * Helper method to execute SafeQuicksort1st with given list.
	 * @param a1st The list.
	 * @param n The number of elements of the list.
	 */
	private static void executeSafeQuicksort1st(Comparable[] a1st) {
		
		// records execution time for SafeQuicksort1st - Unsorted list
		long unsorted1stStart = System.currentTimeMillis();
		SafeQuicksort1st(a1st);
		long unsorted1stEnd = System.currentTimeMillis();
		
		// records execution time for SafeQuicksort1st - Sorted list
		long sorted1stStart = System.currentTimeMillis();
		SafeQuicksort1st(a1st);
		long sorted1stEnd = System.currentTimeMillis();
		
		// Prints the execution times - SafeQuicksort1st
		System.out.printf("\t%d %s\t\t%d %s   \t|",
							(unsorted1stEnd - unsorted1stStart), "ms",
							(sorted1stEnd - sorted1stStart), "ms");
	}
	
	/**
	 * Helper method to execute SafeQuicksortMid with given list.
	 * @param a1st The list.
	 * @param n The number of elements of the list.
	 */
	private static void executeSafeQuicksortMid(Comparable[] aMid) {

		// records execution time for SafeQuicksortMid - Unsorted list
		long unsortedMidStart = System.currentTimeMillis();
		SafeQuicksortMid(aMid);
		long unsortedMidEnd = System.currentTimeMillis();
		
		// records execution time for SafeQuicksortMid - Sorted list
		long sortedMidStart = System.currentTimeMillis();
		SafeQuicksortMid(aMid);
		long sortedMidEnd = System.currentTimeMillis();

		// Prints the execution times - SafeQuicksortMid
		System.out.printf("\t%d %s\t\t%d %s\n",
							(unsortedMidEnd - unsortedMidStart), "ms",
							(sortedMidEnd-sortedMidStart), "ms");

	}

	
	/**
	 * Given method for question 4 - Recursive SafeQuicksort1st().
	 */
	public static void SafeQuicksort1st(Comparable[] a, int l, int r) {
		while (r > l) {
			int p = Pivot1st(a, l, r);
			if (p - l <= r - p) {
				SafeQuicksort1st(a, l, p - 1);;
				l = p + 1;
			} else {
				SafeQuicksort1st(a, p + 1, r);
				r = p - 1;
			}
		}
	}
	
	/**
	 * Given method for question 4 - Recursive SafeQuicksort1st().
	 */
	public static void SafeQuicksort1st(Comparable[] a) {
		SafeQuicksort1st(a, 0, a.length - 1);
	}
	
	/**
	 * Given method for question 4 - Recursive SafeQuicksortMid().
	 */
	public static void SafeQuicksortMid(Comparable[] a, int l, int r) {
		while (r > l) {
			int p = PivotMid(a, l, r);
			if (p - l <= r - p) {
				SafeQuicksortMid(a, l, p - 1);;
				l = p + 1;
			} else {
				SafeQuicksortMid(a, p + 1, r);
				r = p - 1;
			}
		}
	}
	
	/**
	 * Given method for question 4 - Recursive SafeQuicksort1st().
	 */
	public static void SafeQuicksortMid(Comparable[] a) {
		SafeQuicksortMid(a, 0, a.length - 1);
	}
	
	
	
	
	
	/* Helper methods*/
	
	/**
	 * Prints all the elements of the given list.
	 * @param a The list.
	 */
	private static void toString(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString() + " ");
		}
		System.out.println();
	}
	

	/**
	 * Helper method to check if the given list is sorted.
	 * @param a The list.
	 * @return True if the given list is sorted.
	 */
	private static boolean isSorted(Comparable[] a) {
		boolean result = false;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1].compareTo(a[i]) <= 0) {
				result = true;
			} else { 
				result = false;
			}
		} 
		return result;
	}
	

	/**
	 * Helper method to check both Quicksortxxx() are working properly.
	 */
	private static void testQuicksort() {
		int n = 30;
		Random r = new Random();
		
		System.out.println("Quicksort1st()");
		Comparable[] a = new Comparable[30];
		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(n);
		}
		System.out.print("Before sorting: ");
		toString(a);
		Quicksort1st(a);
		System.out.print("After sorting: ");
		toString(a);
		System.out.print("Check if the list is sorted: ");
		System.out.println(isSorted(a));
		
		System.out.println("QuicksortMid()");
		Comparable[] b = new Comparable[30];
		for (int i = 0; i < n; i++) {
			b[i] = r.nextInt(n);
		}
		System.out.print("Before sorting: ");
		toString(b);
		QuicksortMid(b);
		System.out.print("After sorting: ");
		toString(b);
		System.out.print("Check if the list is sorted: ");
		System.out.println(isSorted(b));
	}

}
