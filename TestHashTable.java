public class TestHashTable {
	// This hashtable checks if two inputted strings are anagrams of eachtoher or
	// not
	public static boolean isAnagram(String X, String Y) {

		// Remove all spaces in both the string and convert both inputted string to lower case
		X = X.replaceAll("\\s", "").toLowerCase();
		Y = Y.replaceAll("\\s", "").toLowerCase();

		// Check the lengths of the two inputted strings
		if (X.length() != Y.length()) {
			return false;
		}

		// create an empty hashtable 'table' of size 1
		HashTable table = new HashTable(1);

		// iterate through each the character of first inputted string(X) and value
		// (i.e frquency starts with 1) and if the character is already there, it increments by 1
		for (char c : X.toCharArray()) {
			table.insert(c, table.get(c) == -1 ? 1 : table.get(c) + 1);
		}

		// iterate through each character of the second inputted string(Y) and if the
		// character is present in the the table, it decrements the value(frequency) by 1
		// if the character is not there, it returns false
		for (char c : Y.toCharArray()) {
			if (!table.containsKey(c)) {
				return false;
			}
			table.insert(c, table.get(c) - 1);

			// if the value(frequency) is 0, it is removed from the table
			if (table.get(c) == 0) {
				table.remove(c);
			}
		}

		return table.isEmpty();
	}

	// Main hashtable that tests the isAngram hashtable
	public static void main(String[] args) {
		try {
			// IS ANAGRAM TESTING (PASS CONDITION)...
			/*
			 * Checking that upper and lower case does not matter & able to identify if 2
			 * given strings is a anagram
			 */
			String X = "ball";
			String Y = "Albl";

			/*
			 * Checking to see if the hashtable works on a very long string & able to
			 * identify if 2 given strings is a anagram
			 */
			// String X = "appleappleappleappleappleappleappleappleappleappleapple";
			// String Y = "leappleappleappleappleappleappleappleappleappleappleapp";

			/*
			 * Checking that spaces & upper and lower case do not matter & able to identify
			 * if 2 given strings is a anagram
			 */
			// String X = "data";
			// String Y = "a D a T";

			/*
			 * Checking to see if the hashtable works on a very long string with spaces and
			 * upper case & able to identify if 2 given strings is a anagram
			 */
			// String X = "appleappleappleappleappleappleappleappleappleappleapple";
			// String Y = "leappleaPpleappleappleappl eapplEappleappleappleapp leapp";
			// --------------------------------------------------------------------------------------------------------------------
			// IS NOT ANAGRAM TESTING (FAIL CONDITION)...
			/*
			 * Checking that upper and lower case does not matter & able to identify if 2
			 * given strings is NOT a anagram
			 */
			// String X = "balLB";
			// String Y = "Albl";

			/*
			 * Checking to see if the hashtable works on a very long string & able to
			 * identify if 2 given strings is NOT a anagram
			 */
			// String X = "appleappleappleappleappleappleappleappleappleappleappleapple";
			// String Y = "leappleappleappleappleappleappleappleappleappleappleapppel";

			/*
			 * Checking that spaces & upper and lower case do not matter & able to identify
			 * if 2 given strings is NOT a anagram
			 */
			// String X = "data";
			// String Y = "a D a T A";

			/*
			 * Checking to see if the hashtable works on a very long string with spaces and
			 * upper case & able to identify if 2 given strings is NOT a anagram
			 */
			// String X = "appleappleappleappleappleappleappleappleappleappleapple";
			// String Y = "leappleaPpleappleappleappl eapplEappleappleappleapp leapp P";
			// ---------------------------------------------------------------------------------------------------------------------
			// BAD INPUT TESTING...
			/*
			 * Checking to see that error conditions are handeled such as passing two null
			 * strings is caught by the try-catch
			 */
			// String X = null;
			// String Y = "null";

			if (isAnagram(X, Y)) {
				System.out.print(X + " and " + Y + " is a anagram :) ");
			} else {
				System.out.print(X + " and " + Y + " is NOT a Anagram :( ");
			}
		} catch (Exception ex) {
			System.out.print("Please handle the error: " + ex.getMessage());
		}

	}

}
