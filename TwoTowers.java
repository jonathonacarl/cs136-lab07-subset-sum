import structure5.*;
import static java.lang.Math.*;

/**
 * A class implemented to complete the TwoTowers question from lab07.
 */
public class TwoTowers {

  /**
   * Initializes the block numbers from 1 until given k
   *
   * @param an integer
   * @pre k is non-negative
   * @return vec, a vector of doubles which represent the block numbers
   */
  protected static Vector<Double> vectorHelper(int k) {
    Assert.pre(k >= 0, "k must be non-negative");
    Vector<Double> vec = new Vector<Double>();
    for (Double i = 1.0; i <= k; i++) {
      vec.add(i);
    }
    return vec;
  }

  /**
   * Returns the block number of each block in a subset. A complement to sqrtHeights.
   *
   * @param vector of Double
   * @pre vec is not null
   * @return a vector of integers, which represent the block numbers
   */
  protected static Vector<Integer> squareHeights(Vector<Double> vec) {
    Assert.pre(vec != null, "Vector must be non-empty");
    Vector<Integer> temp = new Vector<Integer>();
    for (int i = 0; i < vec.size(); i++) {
      temp.add((int)Math.round(vec.get(i) * vec.get(i)));
    }
    return temp;
  }

  /**
   * Returns the square-rooted heights of each block in a subset. A complement to squareHeights.
   *
   * @param vector of Double
   * @pre vec is not null
   *
   */
  protected static Vector<Double> sqrtHeights(Vector<Double> vec) {
    Assert.pre(vec != null, "Vector must be non-empty");
    Vector<Double> temp = new Vector<Double>();
    for (int i = 0; i < vec.size(); i++) {
      temp.add(sqrt(vec.get(i)));
    }
    return temp;
  }

  /**
   * Sums the doubles in a vector
   *
   * @param vector of Double
   * @pre vec is not null
   * @return a double, the sum of doubles in vec
   */
  protected static Double vecSum(Vector<Double> vec) {
    Assert.pre(vec != null, "Vector must be non-empty");
    Double sum = 0.0;
    for (int i = 0; i < vec.size(); i++) {
      sum += (vec.get(i));
    }
    return sum;
  }

  /**
   * Finds the two towers with heights closest to a given goal
   *
   * @param subsets, a SubsetIterator of Doubles
   * @param goal, a Double
   * @pre subsets is not null, goal is non-negative
   * @return topTwo, a vector containing two vectors of doubles
   */
  protected static Vector<Vector<Double>> findTowers(SubsetIterator<Double> subsets, Double goal) {
    Assert.pre(subsets != null, "Vector must be non-empty");
    Assert.pre(goal >= 0, "goal must be non-negative");
    Double maxSum = 0.0;
    int count = 0;
    Vector<Double> best = new Vector<Double>();
    Vector<Double> nextBest = new Vector<Double>();
    //iterate through each subset
    for (Vector<Double> tower : subsets) {
      //vector containing heights of each block
      Vector<Double> blocks = sqrtHeights(tower);
      //sum of heights in blocks vector
      Double current = vecSum(blocks);
      //ensure we have correct best
      if ((current >= maxSum) && (current <= goal)) {
        //store the nextBest tower as the old best tower
        nextBest = best;
        //update best tower
        best = blocks;
        //update maxSum
        maxSum = current;
      //ensures we have correct nextBest
      } else if ((current <= goal) && current >= vecSum(nextBest)) {
        //update nextBest
        nextBest = blocks;
      }
    }
    //retrieve top two subsets
    Vector<Vector<Double>> topTwo = new Vector<Vector<Double>>();
    topTwo.add(best);
    topTwo.add(nextBest);
    return topTwo;
  }

  /**
   * Prints the two best tower solutions to the terminal for any given k
   *
   * @param an integer
   * @pre k is non-negative
   *
   */
  public static void answers(int k) {
    Assert.pre(k >= 0, "k must be non-negative");
    //find subsets for k blocks
    SubsetIterator<Double> test = new SubsetIterator<Double>(vectorHelper(k));
    //find answer using findTowers method
    Vector<Vector<Double>> answer = findTowers(test, (vecSum(sqrtHeights(vectorHelper(k))) / 2));
    //a set of print statements for aesthetics
    System.out.println("There are " + k + " total blocks. \n");
    System.out.println("The half height (h/2) is: " + (vecSum(sqrtHeights(vectorHelper(k))) / 2) + "\n");
    System.out.println("The best subset (left stack) is: " + squareHeights(answer.getFirst()) + " = " + vecSum(answer.getFirst()) + "\n");
    System.out.println("The second best subset (left stack) is: " + squareHeights(answer.getLast()) + " = " + vecSum(answer.getLast()));
  }

  /**
   * General testing
   */
  public static void main(String[] args) {
    //number of blocks
    int k = Integer.parseInt(args[0]);
    answers(k);
  }
}
