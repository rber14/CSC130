import java.util.*;
public class Node{
   private String data; //String
   private Node next;
   public Node()
   {
      next=null;
      data=""; //set 0 to ""
   }
   public Node(String d, Node n) //set it to String
   {
      data=d;
      next=n;
   }
   
   
   public void setNext(Node next)
   {  
     this.next=next; 
   }
 
    public Node getNext()
   {
      return next;
   }
   public void setData(String d) //sets data to current node 
   {
      data=d;
   }
   public String getData() //String
   {
      return data;
   }
   public String toString() //toUse equals 
   {
      return this.data+" ";
   }
}


