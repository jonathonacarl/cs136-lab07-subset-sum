import structure5.*;

/*
 * Class using bitwise operations to calculate all possible subsets for a given k
 */
public class SubsetIterator<E> extends AbstractIterator<Vector<E>> {

  private long subsets = 0;
  private long current = 0;
  private Vector<E> vec;

  /**
   * Constructs a vector of subsets
   *
   * @pre vec is not null
   * @param a vector of the generic type
   */
  public SubsetIterator(Vector<E> vec) {
    this.vec = vec;
    subsets = 1L << vec.size();
    //uses bitwise number to keep track of max subsets
  }

  /**
   * Resets the iterator
   */
  public void reset() {
    current = 0;
  }

  /**
   * Checks if the iterator has a next item
   * @return a boolean
   */
  public boolean hasNext() {
    return current < subsets;
  }

  /**
   * Gets the item at the current position in the iterator
   * @return a vector
   */
  public Vector<E> get() {
    Vector<E> temp = new Vector<E>();
    for (int i = 0; i < vec.size(); i++) {
      //add 1 to i position
      int whichBit = 1 << i;
      //checks that there is a 1 in this position
      if ((current & whichBit) == whichBit) {
        //adds the item at position i to temp
        temp.add(vec.get(i));
      }
    }
    return temp;
  }

  /**
   * Gets the item at the current position in the iterator and advances to the next item.
   * @
   * @return a vector
   */
  public Vector<E> next() {
    Vector<E> temp = get();
    current++;
    //go to next item in iterator
    return temp;
  }

  /**
   * General testing
   */
  public static void main(String[] args) {

    Vector<Integer> vec = new Vector<Integer>();
    for (int i = 1; i <= 16; i++) {
      vec.add(i);
    }

    SubsetIterator<Integer> test = new SubsetIterator<Integer>(vec);
    int count = 0;
    for (int i = 0; i < (1 << vec.size()); i++) {
      if (test.hasNext()) {
        System.out.println(test.next());
        count++;
      }
    }
    System.out.println(count);
  }
}
