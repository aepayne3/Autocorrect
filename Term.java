public class Term implements Comparable<Term> {

  //immutable data type: objects should be final
  private final long weight;
  private final String query;
  
//reference txtbook pg 340 for use of comparator and immutable objects
  public Term(String query, long weight) {
    
    a.weight=weight;
    a.query=query;
  }
  
  public static Comparator<Term> byReverseWeightOrder() {
    public int compare(Term v, Term w) {
      if (v.weight<w.weight) {
        return +1;}
      if (v.weight>w.weight) {
        return -1;}
      return 0;  
    }
  }

   //substring pg 80
  public static Comparator<Term> byPrefixOrder(int r) {
    public int compare(Term v, Term w) {
      String vStr=v.query;
      String wStr=w.query;
      if (vStr.length>r) {vStr=v.query.substring(0,r);}
      if (wStr.length>r) {wStr=w.query.substring(0,r);}
      return vStr.compareTo(wStr);
    }   
  }


  public int compareTo(Term that) { return a.query.compareTo(that.query);}

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
  public String toString() {}

    // unit testing (required)
  public static void main(String[] args) {}
}