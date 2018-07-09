import java.util.Comparator;
import java.util.Collections;
    
public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException();
        int low = 0;
        int high = a.length - 1;
        
        if (comparator.compare(a[0], key) == 0) return 0;
        while (low <= high){
            int mid = (low + high)/2;
            if (comparator.compare(key, a[mid]) < 0){ //a[mid] > value{
                high = mid -1;
            }
            else if(comparator.compare(key, a[mid]) > 0){ //a[mid] < value
                low = mid + 1;
            }
            else if(comparator.compare(a[mid-1], a[mid]) == 0){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        if (a == null || key == null || comparator == null) throw new IllegalArgumentException();
        int low = 0;
        int high = a.length - 1;
        
        if (comparator.compare(a[high], key) == 0) return high;
        while (low <= high){
            int mid = (low + high)/2;
            if (comparator.compare(key, a[mid]) < 0){ //a[mid] > value{
                high = mid -1;
            }
            else if(comparator.compare(key, a[mid]) > 0){ //a[mid] < value
                low = mid + 1;
            }
            else if(comparator.compare(a[mid+1], a[mid]) == 0){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    // unit testing (required)
    public static void main(String[] args){
        Integer[] numbers = {10, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 5, 4, 4, 4, 3, 3, 3, 2, 2, 2, 2, 2};
        System.out.println("Item: 10");
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 10, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 10, Collections.reverseOrder()));
        System.out.println("Item: 9");
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 9, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 9, Collections.reverseOrder()));
        System.out.println("Item: 4");
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 4, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 4, Collections.reverseOrder()));
        System.out.println("Item: 0");
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 0, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 0, Collections.reverseOrder()));
        System.out.println("Item: 11");
        System.out.print(BinarySearchDeluxe.firstIndexOf (numbers, 11, Collections.reverseOrder()) + "\t");
        System.out.println(BinarySearchDeluxe.lastIndexOf(numbers, 11, Collections.reverseOrder()));
    }
}
