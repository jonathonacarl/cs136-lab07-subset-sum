# CS136 Lab: The Two Towers

 * The goal in this project is to solve a difficult problem using Iterators. In fact, the problem is so difficult that there is no known efficient solution, so we will use "brute force". We will build an iterator to examine all possible configurations of objects from a set, keeping track of the best configuration that our iteration encounters. If we truly considered every possibility, then we must have found the best configuration! 
 * Suppose that we are given n uniquely-sized cubic blocks and that each block has a distinct face area between 1 and n. If we build two towers by stacking these blocks, how close can we make their heights?
 * If we consider all the subsets of the n blocks, we can think of each subset as representing the set of blocks that make up, say, the left tower (the "missing" blocks would then make up the right tower). We need only keep track of the subset that comes closest to h/2 without exceeding it (where h is the total height of all n blocks).
 * In this lab, we will represent a set of n distinct objects with a Vector<Double>, and we will construct an Iterator that returns each of the 2^n subsets, one at a time.
