//import java.util.Arrays;
/*@author Abigail Payne
* @author Elaine Schutte
* */
import edu.princeton.cs.algs4.MergeX;

public class Autocomplete {
    private final Term[] terms;
    
    // Initializes the data structure from the given array of terms.
//@param terms list of terms to be considered for autocomplete
    public Autocomplete(Term[] terms){
        if (terms == null) throw new IllegalArgumentException();
        this.terms = new Term[terms.length];
        for(int i = 0; i < terms.length; i++){
            if(terms[i] == null) throw new IllegalArgumentException();
            this.terms[i] = terms[i];
        }
        //Arrays.sort(this.terms);
        MergeX.sort(this.terms);
        
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
//@param prefix letters used to find list of words that start with that
    public Term[] allMatches(String prefix){
        if (prefix == null) throw new IllegalArgumentException();
        int firstOccurance = BinarySearchDeluxe.firstIndexOf(this.terms, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));
        //if not found
        //if (firstOccurance == -1) firstOccurance = 0;
        int lastOccurance  = BinarySearchDeluxe.lastIndexOf(this.terms, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));
        //if not found
        if (lastOccurance == -1) lastOccurance = -2;//this.terms.length;
        
        Term [] matches = new Term[(lastOccurance - firstOccurance)+1];
       // copy matches
        for (int i = 0; i< matches.length; i++){
            matches[i] = terms[firstOccurance + i];
        }
        MergeX.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }
    
    // Returns the number of terms that start with the given prefix.
//@param prefix letters used to find list of words that start with that
    public int numberOfMatches(String prefix){
        if (prefix == null) throw new IllegalArgumentException();
        return (allMatches(prefix)).length;
    }

    // unit testing (required)
    public static void main(String[] args){
     Term[] terms = {new Term("Alabama", 174), new Term("Abba", 4857), new Term("Abc", 2), 
         new Term("Alaska", 16), new Term("Arizona", 789),
         new Term("Boston", 45), new Term("Bollywood", 18), new Term("Balitimore", 666),
         new Term("Colorado", 007), new Term("Conneticut", 613), new Term("California", 90210),
         new Term("Disney", 9836), new Term("District of Columbia", 72), new Term("Diddly", 874),
         new Term("Eenie Meanine Miney Moe", 16), new Term("Elephant", 12), new Term("Grey's Antatomy", 15)};
     Autocomplete autocomplete = new Autocomplete(terms);
     System.out.println(autocomplete.numberOfMatches("E"));
     
     Term[] stuff = autocomplete.allMatches("A");
     
     for (Term term : stuff) System.out.println(term);
    }
}
