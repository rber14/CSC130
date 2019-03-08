public class MyQueue{
   public MyStack queue;
   
   public MyQueue(){
      queue = new MyStack();
   }
  
   public boolean isEmpty(){
      return queue.front==null;
   }
   public Node dequeue(){
      Node current = queue.front;
      queue.front=current.getNext();
      return current;
   }
   public void enqueue(String data)
   {
      Node newNode = new Node(data, null);
      Node current = queue.front;
      if(current==null)
      {
         queue.setFront(data);
        
      }else{
         while(current.getNext()!=null)
         {
            current=current.getNext();
         }
        current.setNext(newNode);
      }
      
     
   }
   public void printQueue()
   {
      Node theNode=queue.front;
      if(theNode==null){
         System.out.println("Empty");
      }else{
      
         while(theNode!=null)
         {
           System.out.print(theNode.toString());
           theNode=theNode.getNext();
           //System.out.println();
         }  
     }
      
   }
   
   public String toString()
   {
      String s="";
      Node current = queue.front;
      while(current!=null){
         s+=current.toString();
         current=current.getNext();
      }
      return s;
   }
   

}
