package edu.grinnell.csc207.util;

import java.io.EOFException;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Assorted utilities for searching structures.
 *
 * @author Kevin Tang
 * @author Khanh Do
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchUtils {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int iterativeBinarySearch(int[] vals, int val) throws Exception {
    int start = 0;
    int end = vals.length - 1;

    while (start <= end) {
      int midIndex = (start + end) / 2;
      int mid = vals[midIndex];
      if (mid == val) {
        return midIndex;
      } else if (mid > val) {
        end = midIndex - 1;
      } else {
        start = midIndex + 1;
      } // if/else if/ else
    } // while

    throw new Exception("No match!");
  } // iterativeBinarySearch

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int recursiveBinarySearch(int[] vals, int val) throws Exception {
    int start = 0;
    int end = vals.length - 1;
    return rbsHelper(vals, start, end, val);
  } // recursiveBinarySearch

  /**
   * Search for val in a subarray of values, return the index of an 
   * instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param lb
   *   The lower bound of the area of interest (inclusive)
   * @param ub
   *   The upper bound of the area of interest (exclusive)
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i between lb and ub s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int rbsHelper(int[] vals, int lb, int ub, int val) throws Exception {
    int midIndex = (lb + ub) / 2;
    int mid = vals[midIndex];
    if (ub < lb) {
      throw new Exception("No match!");
    }
    if (mid == val) {
      return midIndex;
    } else if (mid > val) {
      ub = midIndex - 1;
    } else {
      lb = midIndex + 1;
    } // if/else if/ else
    return rbsHelper(vals, lb, ub, val);
  } // rbsHelper

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Search values for the first value for which pred holds.
   *
   * @param <T> 
   *   The type of values we're examining
   * @param values
   *   The iterable we're searching
   * @param pred
   *   The predicate used to determine whether or not the value is
   *   acceptable
   * 
   * @return the first mathcing element.
   *
   * @throws Exception
   *   If no matching value is found.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) 
      throws Exception {
        for (T value : values) {
          if (pred.test(value)) {
            return value;
          }
        } // for
     throw new Exception("No match!");
  } // search(Iterable<T>, Predicate<? super T>)

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  public static int binarySearch(int[] vals, int val) throws Exception {
    //return interativeBinarySearch(vals, val);
    return recursiveBinarySearch(vals, val);
  } // binarySearch
} // class SearchUtils
