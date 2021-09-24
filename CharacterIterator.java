import structure5.*;

/**
 * An iterator that yields the consecutive characters of a String, in order
 */
public class CharacterIterator extends AbstractIterator<Character> {

	private int pos = 0;
	private String str;

	/**
   * Constructs a CharacterIterator for a string
   *
   * @pre string is not empty
	 * @param a String
   */
	public CharacterIterator(String str) {
		this.str = str;
	}

	/**
   * Checks if the iterator has a next item
   * @return a boolean
   */
	public boolean hasNext() {
		return pos < str.length();
	}

	/**
   * Gets the char at the current position in the iterator and advances to the next char.
   * @return a char
   */
	public Character next() {
		return str.charAt(pos++);
	}

	/**
   * Resets the iterator
   */
	public void reset() {
		pos = 0;
	}

	/**
	 * Gets the item at the current position in the iterator
	 * @return a char
	 */
	public Character get() {
		return str.charAt(pos);
	}

	/**
	 * General testing
	 */
	public static void main(String[] args) {
    CharacterIterator ci = new CharacterIterator("Hello world!");
   	for (char c : ci) {
      System.out.println(c);
    }
	}
}
