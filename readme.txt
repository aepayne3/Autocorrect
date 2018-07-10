/******************************************************************************
 *  Name: Elaine Schutte
 *  LU ID:
 *
 *  Partner Name:       
 *  Partner LU ID:      
 *  
 *
 *  Hours to complete assignment (optional): 
 * Abigail - 9
 ******************************************************************************/


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
It uses binary search to find a key in the list that equals the search key and compares the key with an index directly before that key. If they are equal (the one before is a match) until it finds a key where the one before is not a match. 
/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms N and the
 *  number of matching terms M?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower order terms, e.g., M^2 + M log N.
 *****************************************************************************/
constructor:  
Copy over N terms into an array = N
+MergeX-mergesort=NlogN
=NlogN+N

allMatches(): 
N=total # of terms, M=# of matches
(assuming terms array already constructed, otherwise add about answer)
+ binary search (finds middle and goes up or down list) – 2logN+M = logn+M 
+ copying terms to new array = M
+ MergeX-mergesort (worst case) = mlogm
=log(N)+MlogM+2M   = log(N)+MlogM+M

numberOfMatches():
N=total # of terms, M=# of matches
Calls allMatches= log(N)+MlogM+M
+call array.length = O(1)
= log(N)+M^2+M

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/ 
No known bugs/limitations

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings and lectures, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you 
 *  may have used in creating your design.
 *****************************************************************************/
1. https://www.javatpoint.com/java-string-length
2. https://stackoverflow.com/questions/22571586/will-arrays-sort-increase-time-complexity-and-space-time-complexity
3. https://www.geeksforgeeks.org/collections-sort-java-examples/
4. https://rosettacode.org/wiki/Binary_search
5. https://stackoverflow.com/questions/6000810/printing-with-t-tabs-does-not-result-in-aligned-columns
6. https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(java.lang.Object[]) 
7. https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/MergeX.html

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
No serious problems were encountered

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
Elaine: Integration testing, rough code at beginning, javadocs, general documentation
Abigail: Unit testing, researched non built-in methods for sorting, finished and refined project code


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
  When working on the project we noticed that the project checklist encouraged us to use Array.sort so we originally wrote our project like so, and then realized that the blackboard instructions contradicted that so we had to go back and change our code.
