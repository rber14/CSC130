public class HashTable implements DataCounter<String> {
    public static final int SIZE = 4851;
    
    //The hash Table
    private DataCount<String>[] table;
    
    /**
     * Number of element in the hash table.
     */
    protected int size;

    //construct a new hash table
    public HashTable(){
        table = new DataCount[SIZE];
        size = 0;
    }
    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        DataCount<String>[] result = new DataCount[size];
        int s = 0;
        for(int i = 0; i < SIZE; i++){
           if(table[i] != null){
              result[s] = table[i];
              s++;
           }
        }
        return result;
    }

    /** {@inheritDoc} */
    public int getSize() {
        return size;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        int hash = 0;
        for(int i = 0; i < data.length(); i++){
           hash += (data.charAt(i)*31^(data.length() - i - 1));
        }
        hash %= SIZE;
        DataCount<String> node = table[hash];
        while(node != null && !data.equals(node.data)){
           hash = (hash+1)%SIZE;
           node = table[hash];
        }
        if(node != null){
           node.count++;
        }
        else {
           table[hash] = new DataCount<String>(data,1);
           size++;
        }
    }
}