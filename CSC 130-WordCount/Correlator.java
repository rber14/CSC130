import java.io.IOException;
public class Correlator extends WordCount{
   public static void main(String args[]){
      String dataType = "-b";
      String [] file = new String[2]; 
      for(String i : args){
         if(i.charAt(0) == ('-')){
            dataType = i;
         }
         else{
         
            if(file[0] == null)
               file[0] = i;
         
            else
               file[1] = i;
         }
      }
      if (file[0] == null || file[1] == null) {
         System.err.println("Usage: filename of document to analyze");
         System.exit(1);
      }
      compare(dataType, file);
   }
   private static void compare(String dataType, String[] file){
      DataCounter<String>[] counter = new DataCounter[2];
      
      DataCount<String>[][] counts;
      for(int i = 0; i < 2; i++){
         if(dataType.equals("-a")){
            counter[i] = new AVLTree<String>();
         }
         else if(dataType.equals("-h")){
            counter[i] = new HashTable();
         }
         else{
            counter[i] = new BinarySearchTree<String>();
         }
         try {
            FileWordReader reader = new FileWordReader(file[i]);
            String word = reader.nextWord();
            while (word != null) {
                counter[i].incCount(word);
                word = reader.nextWord();
             }
         } catch (IOException e) {
            System.err.println("Error processing " + file[i] + e);
            System.exit(1);
         }
         counts = new DataCount[2][];
         //DataCount<String>[] table = counter[i].getCounts();
         WordCount.sortByDescendingCount(table);
         for(DataCount<String> c : table){
            double frequency = (double) c.count/counter[i].getSize();
            
            if (frequency < 0.01 && frequency > 0.0001)
            
               System.out.printf("%.4f%% \t %s\n", frequency*100 ,c.data);
         }
         
         System.out.println("End of File****************************************************************.");
      }
   }
}