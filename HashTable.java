package project4package;

public class HashTable {
	
	private class Entry {
		private String key;                            //the element in the entry
		private int occurrences;                       //the number of times this element appears
		private Entry next;                            //a reference to the next entry
		
		private Entry(String key, int occurrences) {   //a constructor for the entry
			this.key = key;
			this.occurrences = occurrences;
			next = null;
		}
		
		public String toString() {
			return key + ": " + occurrences;
		}
		
	}
	
	private Entry[] tableOfEntries;                    //a table of entries
	private int size;                                  //the size of the the table
	private int filledEntries;                         //the number of entries that are filled
	private final double maxLoadFactor = 0.75;
	
	public HashTable() {                               //a constructor for the hash table
		int tableSize = 10;
		tableOfEntries = new Entry[tableSize];
		size = tableSize;
	}
	
	public void insert(String key, int occurrences) {
        int hash = Math.abs(key.hashCode() % size);    //finding the proper index to insert the item
        Entry head = tableOfEntries[hash];             //a traversal variable of the table of entries
        while (head != null) {
            if (head.key.equals(key)) {               //loops through the array and adds to the number of occurrences
                head.occurrences += occurrences;
                return;
            }
            head = head.next;
        }
        Entry newElementNode = new Entry(key, occurrences);  //a temporary element
        head = tableOfEntries[hash];                   //the head node at the index
        newElementNode.next = head;                    //inserts the new node by shifting the head
        tableOfEntries[hash] = newElementNode;
        filledEntries++;
        double loadFactor = (1.0 * filledEntries) / size;  //determines the load factor
        if (loadFactor > maxLoadFactor) {                //rehash if the loading factor is greater than 0.75
            rehash();
        }
	}
	
	public void rehash() {
        Entry[] originalTable = tableOfEntries;           //copies the current table onto a variable
        int originalSize = size;
        size = size * 2;                                 //adjusts the size of the current table
        tableOfEntries = new Entry[size];
        for (int i = 0; i < originalSize; i++) {         //loops through the table and adjusts values
            Entry trav = originalTable[i];
            while (trav != null) {
                insert(trav.key, trav.occurrences);
                trav = trav.next;
            }
        }
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < tableOfEntries.length; i++) {  //prints out all elements
			Entry head = tableOfEntries[i];
			while (head != null) {
				str += head + "\n";
				head = head.next;
			}
		}
		return str;
	}
}