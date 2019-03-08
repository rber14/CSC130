public class MyStack
{
  
       protected Node front;
       protected int size; //string
   
       public MyStack()
       {
         front = null;
         size = 0;
       }
   
      public boolean isEmpty()
      {
          return front == null;
      }
   
  
   
   public void push(String data)
   {
      Node nptr = new Node(data, null);
      if(front==null)
      {
         front=nptr;
      }else{
         nptr.setNext(front);
         front=nptr;
      }
      size++;
   }
   
   public Node pop()
   {
      Node current=front;
      if(front==null)
      {
         return null;
      }else{
        if(current.getNext()!=null)
        {
        
            while(current.getNext().getNext()!=null) 
            {   
                current=current.getNext();
            }
                Node tmp = current.getNext();
                current.setNext(null);
            return tmp;
        }else{
               front=null;
               return current;
        }
        //return tmp;
      }
   }
    
   public void printStack()
   {
      Node current = front;
    //  System.out.print("Stack= ");
      if(front==null)
      {
         System.out.print("Empty\n");
           return;
      }
      while(current != null)
      {
         System.out.print(current.getData()+" ");
         current = current.getNext();
      }
      System.out.println();
         
   }
   public void setFront(String data){
      Node newNode = new Node(data, null);
      this.front=newNode;
   }
   public Node getFront()
   {
      return this.front;
   }
  
   public String toString()
   {
      String s="";
      Node current = front;
      while(current!=null)
      {
         s+=current.toString();
         current=current.getNext();
      }
      
      return s;
   } 
   
  
}   


