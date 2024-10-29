package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.function.Predicate;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Assorted experiments for searching structures.
 *
 * @author Kevin Tang
 * @author Khanh Do
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    Predicate<String> pred = new Predicate<String>() {
      @Override
      public boolean test(String arg0) {
        return (arg0.length() < 5);
      } // test(String)
    };
    try {
      String ex1c = SearchUtils.search(strings, pred);
      pen.println("The first string of fewer than five letters is " + ex1c);
    } catch (Exception e) {
      pen.println("There are no strings of fewer than five letters.");
    } // try/catch

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.contains("u"));
      pen.println("The first string that contains a u is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings that contains a u.");
    } // try/catch

    int[] large = new int[1000];
    for (int i = 0; i < 1000; i++) {
      large[i] = i;
    }  // for
    SearchUtils.binarySearch(large, 999);
    SearchUtils.printSteps();
    pen.close();
  } // main(String[])
} // class SearchUtils
