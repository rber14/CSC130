public class MyTest{
   public static void main(String[] args)
   {
      MyStack test = new MyStack();
      MyQueue test2= new MyQueue(); 
       
      test.push("a");
      test.push("b");
      test.push("c");
      String s = test.toString();
      String s2 = "c b a "; //need space for second string
      System.out.println("Testing Push");
      outcome(s2,s);
      System.out.println("\n");
      
      test.pop();
      s2="c b ";
      s= test.toString();
      System.out.println("Testing Pop");
      outcome(s2,s);
      System.out.println("\n");
      
      test.pop();
      test.pop();
      System.out.println("Testing printStack");
      System.out.println("Expecting: Empty");
      System.out.println("Outcome: ");
      test.printStack();
      
      System.out.println("\nTesting isEmpty");
      System.out.println("Expecting true");
      System.out.println("Outcome: "+test.isEmpty());
      
      System.out.println("\n******************************");
      
      test2.enqueue("a");
      test2.enqueue("b");
      test2.enqueue("c");
      String p=test2.toString();
      String o="a b c ";
      System.out.println("Testing enqueue");
      outcome(o, p);
      
      test2.dequeue();
      p= test2.toString();
      o="b c ";
      System.out.println("\nTesting dequeue");
      outcome(o,p);
      
      test2.dequeue();
      test2.dequeue();
      System.out.println("\nTesting printStack");
      System.out.println("Expecting: Empty");
      System.out.println("Outcome: ");
      test2.printQueue();
      
      System.out.println("\nTesting isEmpty");
      System.out.println("Expecting: true");
      System.out.println("Outcome: "+test2.isEmpty());
      
      System.out.println("\n******************************");
      
      System.out.println("Testing for empty printStack right away");
      MyStack test3 = new MyStack();
      test3.printStack();
      System.out.println("Testing for Stack isEmpty() right away");
      System.out.println(test3.isEmpty());
      System.out.println("Testing for stack isEmpty() with input first");
      test3.push("a");
      System.out.println(test3.isEmpty());
      System.out.println("Testing for pop() twice with no input");
      test3.pop();
      test3.pop();
      test.printStack();
      System.out.println("Testing for pushing long string");
      test3.push("HELLLLLLLLLLLOOOOO");
      test3.printStack();
      System.out.println("\n******************************");
      MyQueue test4 =new MyQueue();
      System.out.println("Testing for empty printQueue() right away");
      test4.printQueue();
      System.out.println("Testing for isEmpty() right away");
      System.out.println(test4.isEmpty());
      System.out.println("Testing for isEmpty() with input first");
      test4.enqueue("a");
      System.out.println(test4.isEmpty());
      test4.dequeue();
      System.out.println("Testing for enqueue long string");
      test4.enqueue("HELLLLLLLLOOOO");
      test4.printQueue();
      
      
      
      
           
   }
   public static void outcome(String ex, String out)
   {
      System.out.println("Expecting: "+ex);
      System.out.println("Outcome: "+out);
      if(ex.equals(out)==true){
         System.out.println("Pass/Failed: Pass");
      }else{
         System.out.println("Pass/Failed: Failed");
      }
      
   
   } 
}