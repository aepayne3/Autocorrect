//need to implement the comparator to be able to use it
/*@author Abigail Payne
* @author Elaine Schutte
* */
import java.util.Comparator;
import java.util.Arrays;

public class Term implements Comparable<Term> {

  //immutable data type: objects should be final
  private final long weight;
  private final String query;
  
//reference txtbook pg 340 for use of comparator and immutable objects
//@param query string that is being looked at
//@param weight is how much weight that query has
  public Term(String query, long weight) {
    if (query == null) throw new IllegalArgumentException();
    if (weight < 0) throw new IllegalArgumentException();
    this.weight=weight; //more conventional to use this than a
    this.query=query;
  }
  
  //I think this is a function signature that would need to call a class?
  //I changed all of them to work like this, if it's not right LMK
  public static Comparator<Term> byReverseWeightOrder() {
      return new CompareByReverseWeightOrder();
  }
  
  public static class CompareByReverseWeightOrder implements Comparator<Term>{
//@param v string being compared to w by subtracting w-v 
//@param w comparing to v by subtracting w-c
      public int compare(Term v, Term w) {
          if (v.weight<w.weight) return 1; //removed redundant +
          if (v.weight>w.weight) return -1;
          return 0;  
      }
  }
    
//@param number of characters in a word that is being looked at
  public static Comparator<Term> byPrefixOrder(int r) {
      if (r < 0) throw new IllegalArgumentException();
      return new CompareByPrefixOrder(r);
  }
  
  public static class CompareByPrefixOrder implements Comparator<Term>{
      //can't use default constructor because you need the r term
      private int r;
      private CompareByPrefixOrder(int r){
          this.r = r;
      }
      public int compare(Term v, Term w) {
          String vStr=v.query;
          String wStr=w.query;
          if (vStr.length()>r) {vStr=v.query.substring(0,r);} // reference pg 80 for substring
          if (wStr.length()>r) {wStr=w.query.substring(0,r);} //length is a function so it needs ending ()
          return vStr.compareTo(wStr);
      }   
  }

  //compares two terms in the lexicographic order by query
//@param that term being compared to current term
  public int compareTo(Term that) {return this.query.compareTo(that.query);}//another part where it's convention to use this. not a.

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
  public String toString() {return this.weight + "\t" + this.query;}

    // unit testing (required)
  public static void main(String[] args) {
      Term tempTerm = new Term("abcdefg", 100);
      Term otherTerm = new Term("qwerty", 13);
      
      System.out.println(tempTerm);
      System.out.println(otherTerm);
      
      Term[] terms = {new Term("stress", 12), new Term("Lusth", 89), new Term("Cat", 134)};
      for (Term term : terms){
          System.out.println(term);
      }
      Arrays.sort(terms, Term.byReverseWeightOrder());
      for (Term term : terms){
          System.out.println(term);
      }      
      Arrays.sort(terms, Term.byPrefixOrder(3));
      for (Term term : terms){
          System.out.println(term);
      }      
      
  }
}