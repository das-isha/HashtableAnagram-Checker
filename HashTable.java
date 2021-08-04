public class HashTable {

	// This private Entry class is used to implement hash table using seperate
	// chaining through linked-lists
	private class Entry {
		private char key;
		private int value;
		private Entry next; // Pointer to next node in the list & null marks the end of the list

		public Entry(char key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private Entry[] table; // The hash table, represented as Entry
	private int numItems; // The number of (key,value) pairs in the hash table.
	int capacity;

	// Build a hash table with a specfic initial size
	public HashTable(int initialSize) {
		numItems = 0;
		capacity = initialSize;
		table = new Entry[capacity];
	}

	// This method inserts a entry element of key and value pair & check that the key is not null
	public void insert(char key, int value) {
		int i = hash(key);
		Entry newEntry = table[i];
		while (newEntry != null) {
			if (newEntry.key == key) {
				newEntry.value = value;
				return;
			}
			newEntry = newEntry.next;
		}

		// Increase the table size before adding the new node if table is becoming full & rehash
		if (numItems >= 0.75 * table.length) {
			reHash();
			i = hash(key);
		}
		Entry enty = new Entry(key, value);
		enty.next = table[i];
		table[i] = enty;
		numItems++;
	}

	// The methods gets the value linked with the specfic key in the table
	public int get(char key) {
		int i = hash(key);
		Entry newEntry = table[i];
		while (newEntry != null) {
			if (newEntry.key == key)
				return newEntry.value;
			newEntry = newEntry.next;
		}
		return -1;
	}

	// This method removes the key and its linked value from the table
	public void remove(char key) {
		int i = hash(key);
		if (table[i] == null) {
			return;
		}
		if (table[i].key == key) {
			table[i] = table[i].next;
			numItems--;
			return;
		}
		Entry previous = table[i];
		Entry current = previous.next;
		while (current != null && current.key != key) {
			current = current.next;
			previous = current;
		}

		if (current != null) {
			previous.next = current.next;
			numItems--;
		}
	}

	// This method returns true when the specific key has the associated value in
	// the table
	public boolean containsKey(char key) {
		int i = hash(key);
		Entry newEntry = table[i];
		while (newEntry != null) {
			if (newEntry.key == key)
				return true;
			newEntry = newEntry.next;
		}
		return false;
	}

	// This method returns the number of key and value pairs in the table
	public int size() {

		return numItems;
	}

	// This method returns true if the hashTable contains no elements
	public boolean isEmpty() {

		return numItems == 0;
	}

	// This method returns the hash value of the key
	private int hash(char key) {

		return Math.abs(Character.valueOf(key)) % table.length;
	}

	// This method rehashes the table
	private void reHash() {
		Entry[] newtable = new Entry[nextPrime(table.length * 2)];
		for (int i = 0; i < table.length; i++) {
			Entry node = table[i];
			while (node != null) {
				Entry next = node.next;
				int newHash = (Math.abs(Character.valueOf(node.key))) % newtable.length;
				node.next = newtable[newHash];
				newtable[newHash] = node;
				node = next;
			}
		}
		table = newtable;
	}

	// This method gets the next prime number
	public int nextPrime(int num) {
		num++;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				num++;
				i = 2;
			} else {
				continue;
			}
		}
		return num;
	}

}