import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

    private static void countWords(String dataSet, String file, boolean frequency, boolean numUnique) {
        DataCounter<String> counter;
        if(dataSet.equals("-a")){
           counter = new AVLTree<String>();
        }
        else if(dataSet.equals("-h")){
           counter = new HashTable();
        }
        else counter = new BinarySearchTree<String>();

        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }
        //print all word in frequency and alphabetical order
        if(frequency){
           DataCount<String>[] counts = counter.getCounts();
           sortByDescendingCount(counts);
           for (DataCount<String> c : counts)
              System.out.println(c.count + " \t" + c.data);
           
        }
        if(numUnique){
           System.out.println(counter.getSize());
        }
    }

    /**
     * TODO Replace this comment with your own.
     * 
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a heap sort
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    public static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }

    public static void main(String[] args) {
        String filename = null;
        String dataType = "-b";
        boolean frequency = false;
        boolean numUnique = false;
        for(String i : args){
           if(i.contains("-")){
              if(i.length() == 2){
                 dataType = i;
              }
              else if(i.equals("-frequency")){
                 frequency = true;
              }
              else if(i.equals("-num_unique")){
                 numUnique = true;
              }
           }
           else filename = i;
        }
        if (filename == null) {
            System.err.println("Usage: filename of document to analyze");
            System.exit(1);
        }
        if(!frequency && !numUnique){
           frequency = true;
        }
        countWords(dataType, filename, frequency, numUnique);
        
        //System.out.println("HI IT's ME!");
    }
}
