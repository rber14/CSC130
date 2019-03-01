import java.util.Stack;

public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> implements
        DataCounter<E>{
   /**
   * The root of the AVLtree. root is null if and only if the tree
   * is empty.
   */
   protected AVLNode overallRoot;
   
   protected class AVLNode extends BinarySearchTree<E>.BSTNode{
      /**
      * The left child of this node.
      */
      public AVLNode left;
      /**
      * The right child of this node.
      */
      public AVLNode right;
     
      //The height of the node
      protected int height;
      
      //Construct the Node
      public AVLNode(E data){
         super(data);        
         height = 1;
      }
   }
   //created an empty AVL Tree
   public AVLTree(){
      super();
   }
   //get the height of the tree
   public int height(AVLNode node){
      return node == null ? 0 : node.height;
   }
   
   public void incCount(E data){
      Stack<AVLNode> AVLStack = new Stack<AVLNode>();
      if (overallRoot == null) {
         overallRoot = new AVLNode(data);
      } else {
      // traverse the tree
         AVLNode currentNode = overallRoot;
         while (true) {
         
            // compare the data to be inserted with the data at the current
            // node
            int cmp = data.compareTo(currentNode.data);

            if (cmp == 0) {
              // current node is a match
              currentNode.count++;
              return;
            } else {
               AVLStack.push(currentNode);
               if (cmp < 0) {
                  // new data goes to the left of the current node
                  if (currentNode.left == null) {
                     currentNode.left = new AVLNode(data);
                     break;
                  }
                  else {
                     currentNode = currentNode.left;
                  }
               } else {
                  // new data goes to the right of the current node
                  if (currentNode.right == null) {
                     currentNode.right = new AVLNode(data);
                     break;
                  }
                  else{
                     currentNode = currentNode.right;
                  }
               }
            }
         }
         while(!AVLStack.empty()){
            AVLNode i = AVLStack.pop();
            if(i.right != null){
               i.right = balance(i.right);
            }
            if(i.left != null){
               i.left = balance(i.left);
            }
            i.height = Math.max(height(i.left), height(i.right)) + 1;
         }
         overallRoot = balance(overallRoot);
      }
   }
    /*
    * balance the tree
    */
   private AVLNode balance(AVLNode node){
      if(height(node.left) - height(node.right) > 1)
         {
         if(height(node.left.left) >= height(node.left.right))
            {
            node = singleRightRotation(node);
            }
         else
            {
            node = doubleLeftRightRotation(node);
            }
         }
      else if(height(node.right) - height(node.left) > 1)
         {
         if(height(node.right.right) >= height(node.right.left))
            {
            node = singleLeftRotation(node);
            }
         else
            {
            node = doubleRightLeftRotation(node);
            }
         }
         return node;
      }
   /*
    * Single right rotation
    */
   private AVLNode singleRightRotation(AVLNode node)
   {
      AVLNode result = node.left;
      node.left = result.right;
      result.right = node;
      node.height = Math.max(height(node.left), height(node.right)) + 1;
      result.height = Math.max(height(result.left), height(node)) + 1;
      return result;
   }
   /*
    * Single left rotation
    */
   private AVLNode singleLeftRotation(AVLNode node)
   {
      AVLNode result = node.right;
      node.right = result.left;
      result.left = node;
      node.height = Math.max(height(node.left), height(node.right)) + 1;
      result.height = Math.max(height(result.right), height(node)) + 1;
      return result;
   }
   /*
    * Double left right rotation
    */
   private AVLNode doubleLeftRightRotation(AVLNode node)
   {
      node.left = singleLeftRotation(node.left);
      return singleRightRotation(node);
   }
   /*
    * Double right left rotation
    */
   private AVLNode doubleRightLeftRotation(AVLNode node)
   {
      node.right = singleRightRotation(node.right);
      return singleLeftRotation(node);
   }
   /** {@inheritDoc} */
    public DataCount<E>[] getCounts() {
    	@SuppressWarnings("unchecked")
        DataCount<E>[] counts = new DataCount[size];
        if (overallRoot != null)
            traverse(overallRoot, counts, 0);
        return counts;
     }

    /**
     * Do an inorder traversal of the tree, filling in an array of DataCount
     * objects with the count of each element. Doing an inorder traversal
     * guarantees that the result will be sorted by element. We fill in some
     * contiguous block of array elements, starting at index, and return the
     * next available index in the array.
     *
     * @param counts The array to populate.
     */
    protected int traverse(AVLNode root, DataCount<E>[] counts, int idx) {
        if(root != null) {
            idx = traverse(root.left, counts, idx);
            counts[idx] = new DataCount<E>(root.data, root.count);
            idx = traverse(root.right, counts, idx + 1);
        }
        return idx;
    }
}