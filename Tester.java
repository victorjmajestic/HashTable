package project4package;

public class Tester {

	public static void main(String[] args) {
		Tester test = new Tester();
		System.out.println("Below are a series of tests. I wanted to test the Bee Movie script but it would make the tests too difficult to navigate."
				+ " I can prove it to you with some fun facts.");
		System.out.println("For example the word 'bee' appears 272 times. 'The' appears 863 times, while 'BEEEEEEEEEEEEEE' and 'tobacco' appear 1 time each.");
		System.out.println("Wait, I forgot that CTRL+F exists. Trust me please :0");
		System.out.println("");
		System.out.println("Anyway, this is the test done with a series of simple Strings.");
		System.out.println("");
		test.wordCount("dog");
		test.wordCount("Woah. Very pog pog. Pogpogpogpogpogpogpog!!!!! Pog!");
		test.wordCount("1234567890 do re me pog so la ti do ?'a;][$@#%^*!?', do do dodo do do do do d od odo do");
	}
	
	public void wordCount(String text) {
		HashTable hashTable = new HashTable();
		if (text != null) {
			String[] textList = text.toUpperCase().split("\\P{Alpha}+");
			for (int i = 0; i < textList.length; i++) {
				if (textList[i] != null && textList[i] != "") {
					hashTable.insert(textList[i], 1);
				}
			}
		}
		System.out.println("The values of the table are:");
		System.out.println(hashTable);
	}

}
