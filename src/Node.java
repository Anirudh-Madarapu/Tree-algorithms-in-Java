public class Node<T> {
   private T value;
   private Node<T> right;//Node that is right child of parent node
   private Node<T> left;//Node that is left child of parent node
   public boolean occupied; //this boolean value turns true once left and right nodes are filled
   private int numChildren;//keeps track of number of children
   private boolean visited; //this variable tells if this node has been visited or not
   public Node<T> location;//keeps track of the location that we are supposed to have
   private boolean siblingVisit;
   private boolean finals;
   public Node(T value){
      //everytime a Node is insantiated we will add value into it
         add(value);
      //bydefault every node is univisted. The boolean visited has an important role in pathToRoot() method
      //therefore, we will refer more details in that method
         this.visited = false;
   }
   public T getValue(){//when value is private we need a getter method
      //therfore for testing purposes we are going to fetch value from this method
      return this.value;
   }

   public Node<T> getRight(){ //gives the Node on right
      return this.right;
   }

   public static boolean isSumTree(Node<Integer> n){

      Integer sum = 0;
      sum = treesum(sum,n);
      //the sum consists of sum of entire tree
      if(sum - n.getValue() ==  n.getValue()){
      //therefore we want to subtract the head's value and compare head's value to sum
         return true;
      }

     //if the above statement has not been executed then we will reutn false
      return false;


   }
   public static Integer treesum(Integer sum, Node<Integer> newnode){

      if (newnode != null) {
         sum += newnode.getValue();
         // System.out.println("Test 1");
         sum = treesum(sum,newnode.getLeft());
         // System.out.println("Test 2");
         sum = treesum(sum,newnode.getRight());

         // System.out.println("Test 3");
         // System.out.println("Test 4");

     }
     return sum;


   }
   public int rightsum(int right, Node<Integer> rightnode){
      while(rightnode.getRight()!=null || rightnode.getLeft()!=null){
         if(rightnode.getRight()!=null && rightnode.getLeft()!=null){
            //given an integer we have to add numbers of left sum and right sum
            right += rightnode.getRight().getValue();
            right +=rightnode.getLeft().getValue();
         }
         //if right is null and left is null we only want to add thisvalue
         if(rightnode.getRight()==null && rightnode.getLeft()!=null){
            right +=rightnode.getLeft().getValue();

         }
         if(rightnode.getRight()!=null && rightnode.getLeft()==null){
            right +=rightnode.getRight().getValue();

         }

      }
      return right;

   }

   public Node<T> getLeft(){ //gives the Node on left
      return this.left;
   }

   public void add(T value){
      //this method takes a value
      //modifies the attribute 'value' to the the given value
      this.value = value;
   }

   //lets assign node to right
   public void assignRight(Node<T> rightChild){
      this.numChildren++;
      this.right = rightChild;
   }

   //lets assign node to left
   public void assignLeft(Node<T> leftChild){
      this.numChildren++;
      this.left = leftChild;
   }

   public void beenVisited(){
        //this method is not really needed. However, for debugging purposes, we will employ this method

        this.visited = true;
   }

   public boolean isVisited(){
      //will mark as visited
      return this.visited;
   }

   public void incnumChild(){
      //will increment the number of children
      this.numChildren++;
   }
   public void decnumChild(){
      //this will decrement the number of children
      this.numChildren--;
   }
   public int childCount(){
      //returns total number of children
      return this.numChildren;
   }

   //let us compute the maximum depth of the tree from this node

   public int depth(){
      //we will get to know the depth of the tree
      Node<T> tempNode = this;
      int depth = 0;

      while(tempNode != null){
         //iterates through the tree
         if(tempNode.getRight()==null || tempNode.getLeft()==null){
            if(tempNode.getLeft()==null){
                depth++;
                //if left is null then we will beak
                break;
            }
            tempNode = tempNode.getLeft();

         }
         else if(tempNode.getRight().childCount()>tempNode.getLeft().childCount()){
            depth++;
            tempNode = tempNode.getRight();
         }
         else if(this.right.childCount()==this.left.childCount()){
            depth++;
            tempNode = tempNode.getRight();
         }
         else{
            depth++;
            tempNode = tempNode.getLeft();
             //each statement will increment the depth as if we get to any statment that means we have something
         }

      }
      return depth;

   }
   public void traverse(LinkedList<T> l){//this method helps us in traversing to a specific node in our tree
     //this method will traverse throught the linkedlist and prints all the values that have been added into the linkedlist
      Node<T> traversal = this;
      while(traversal!=null){
         //if right is not null we will check if it is visited
         if(traversal.getRight()!=null){
            if(traversal.getRight().isVisited()){
               traversal = traversal.getRight();
               //if visited them mark it as visited
               l.addFront(traversal);
            }
         }
         if(traversal.getLeft()!=null){
            //same goes for left
            if(traversal.getLeft().isVisited()){
               traversal = traversal.getLeft();
               l.addFront(traversal);

            }
         }
         else{
            //if left is not null and right is not null then we want to exit out of the loop
            break;
         }

      }

   }

   public boolean isfinals(){
      //returns if this is final node
      return this.finals;
   }

   public boolean sibvisit(){
      //tells if the sibling has been visited
      return this.siblingVisit;
   }

   public Node<T> finder(){
      Node<T> temp = this;
      //this will find path to the sibling whose final is false
      System.out.println(temp.getLeft().isfinals());
      while(temp.getRight().isfinals()==false && temp.getLeft().isfinals()==false){

          if(temp.getRight().sibvisit()){
              temp = temp.getRight();
              return temp;
          }

          if(temp.getLeft().sibvisit()){
              temp = temp.getLeft();
          }

      }
      return temp;

  }


   public T siblings(T value){
      //siblings will call siblings tour
      siblingstour(value);//the siblings tour method will mark all
      Node<T> tempfinder =  finder();
      //find empty spot of the tree

      if(tempfinder.getRight()!=null){
      
         if(tempfinder.getRight().isfinals()){
            return tempfinder.getLeft().getValue();
         }
         else if(tempfinder.getLeft().isfinals()){
            return tempfinder.getRight().getValue();
         }

      }
      if(tempfinder.getLeft()!=null){
         if(tempfinder.getLeft().isfinals()){
            return tempfinder.getRight().getValue();
         }
         else if(tempfinder.getRight().isfinals()){
            return tempfinder.getLeft().getValue();
         }

      }
      return tempfinder.getValue();

   }


   public void siblingstour(T value){
      unvisit();
      if(this.getValue().equals(value)){//we want to stop if we found our desired value
         this.siblingVisit = true;
         this.finals = true;
         return;

      }
      //want to stop if right and left are null
      if(this.getRight()==null && this.getLeft()==null){
         return;
      }
      else if(this.getRight()==null){
         //if right node is null then we will explore entire left tree
         this.getLeft().siblingstour(value);
         if(this.getLeft().sibvisit()){
            this.siblingVisit = true;
         }
         return;
      }
      //same goes here if left is null, we will marks this sibling as visited
      else if(this.getLeft()==null){
         this.getRight().siblingstour(value);
         if(this.getRight().sibvisit()){
            this.siblingVisit = true;
         }
         return;
      }
      else{
         this.getRight().siblingstour(value);
         this.getLeft().siblingstour(value);
      }

      if(this.getRight().sibvisit() || this.getLeft().sibvisit()){
         this.siblingVisit = true;
      }


   }
   public void inOrderC(){//this inorder takes constant space and linear time
      Node<T> temp  = this;//we will initiate temp node to this node
      Node<T> temp2  = new Node<T>(this.getValue());//we can put any value it doesn't matter
      //basically we will have two pointers

      while(temp!=null){//change temp until it is null
         if(temp.getLeft()==null){
            System.out.print(temp.getValue() + ", ");
            temp = temp.getRight();
         }
         else{
            temp2 = temp.getLeft();
            while(temp2.getRight()!=null && temp2.getRight()!=temp){
               temp2 = temp2.getRight();
            }
            if(temp2.getRight()==null){
                     temp2.assignRight(temp);
                     temp = temp.getLeft();
            }
            else{
                  temp2.assignRight(null);
                  System.out.print(temp.getValue() + ", ");
                  temp = temp.getRight();


            }

         }
      }

   }
   public void unvisit(){
      if(this.sibvisit()){//we want to stop if we found our desired value
         this.siblingVisit = false;
         this.finals = false;
         return;
      }
      if(this.getRight()==null && this.getLeft()==null){
         return;
      }
      else if(this.getRight()==null){
         this.getLeft().unvisit();
         return;
      }
      else if(this.getLeft()==null){
         this.getRight().unvisit();

         return;

      }
      else{
         this.getRight().unvisit();
         this.getLeft().unvisit();
      }

      if(this.getRight().isVisited() || this.getLeft().isVisited()){
         this.siblingVisit = false;
         this.finals = false;
      }

   }
   public void unmarksib(){
      this.siblingVisit = false;
   }
   public void pathToRoot(T value){
      forgetpath(); //before we proceed, we want to forget the path
      //this is because the nodes that are marked as visited by previous findpath methods will interfere with our findpath
      findPath(value);

      Node<T> temp = this;//we can put any value, but to avoid complications and to satisfy node instantiation conditions, lets put value
      if(!temp.isVisited()){
         //do nothing
      }
      else{

         LinkedList<T> l = new LinkedList<T>();
         System.out.println(temp.getRight().getLeft().isVisited()+" je ");

         while(temp.isVisited()){
            if(temp.getRight()!=null && temp.getLeft()!=null){
               System.out.println(" test 3 ");

                if(temp.getRight().isVisited()==false && temp.getLeft().isVisited()==false){
                   l.addFront(temp);
                   break;
                }
            }
            if(temp.getRight()!=null){

               if(temp.getRight().isVisited()){
                  System.out.println(" test 1 ");

                  l.addFront(temp);
                  temp = temp.getRight();
                  continue;
               }
            }
            if(temp.getLeft()!=null){

               if(temp.getLeft().isVisited()){
                  System.out.println(" test 2 ");

                  l.addFront(temp);
                  temp = temp.getLeft();
                  continue;
               }
            }

            else{
                  if(temp.isVisited()){
                     l.addFront(temp);
                  }
                  break;
            }
         }
         System.out.println(l.toString());
      }


   }
   public T LeastCommonSubsumer(T value1, T value2){
      forgetpath();
      findPath(value1);
      findPath(value2);

      Node<T> temp = this;//doesn't matter which value we put


      while(temp.getRight().isVisited() == false || temp.getLeft().isVisited()==false){
          if(temp.getRight()!=null){
             if(temp.getRight().isVisited()){
                temp = temp.getRight();
                continue; //this statement is very crucial for our code
             }
           }
           if(temp.getLeft()!=null){
              if(temp.getLeft().isVisited()){
                 temp = temp.getLeft();
                 if(temp.getRight()==null || temp.getLeft()==null){
                   break;
                 }
              }
           }
           else{
             break;
           }
      }
      //the if statement below is there incase of nodes which are parents and children.
      //for example, 5 is parent of 10. if some one passes 5, 10 as arguments we have to written 5
      //this if statement does that job for us

      if(temp.getValue().equals(value1) || temp.getValue().equals(value2)){
         if(temp.getValue().equals(value1)){
            return value2;
         }
         if(temp.getValue().equals(value2)){
            return value1;
         }
      }
      return temp.getValue();
   }

   public void findPath(T value){
      if(this.getValue().equals(value)){//we want to stop if we found our desired value
         this.visited = true;
         return;
      }
      if(this.getRight()==null && this.getLeft()==null){
         return;
      }
      else if(this.getRight()==null){
         this.getLeft().findPath(value);
         if(this.getLeft().isVisited()){
            this.visited = true;
         }
         return;
      }
      else if(this.getLeft()==null){
         this.getRight().findPath(value);
         if(this.getRight().isVisited()){
            this.visited = true;
         }
         return;
      }
      else{
         this.getRight().findPath(value);
         this.getLeft().findPath(value);
      }

      if(this.getRight().isVisited() || this.getLeft().isVisited()){
         this.visited = true;
      }
   }
   public void forgetpath(){
      if(this.isVisited()){
         this.visited = false;
      }

      if(this.getRight()==null && this.getLeft()==null){
         return;
      }
      else if(this.getRight()==null){
         this.getLeft().forgetpath();
         if(!this.getLeft().isVisited()){
            this.visited = false;
         }
         return;
      }
      else if(this.getLeft()==null){
         this.getRight().forgetpath();
         if(!this.getRight().isVisited()){
            this.visited = false;
         }
         return;
      }
      else{
         this.getRight().forgetpath();
         this.getLeft().forgetpath();
      }

      if(this.getRight().isVisited() || this.getLeft().isVisited()){
         this.visited = false;
      }
   }

}
