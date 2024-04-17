public class Tree<T> {
    public Node<T> head;//this is head node
    private T value; //stores value of a tree
    private Node<T> pointer;
    public int numChildren; //keeps track of number of children in the tree
    public Tree(){
        //instantiate the Node
        this.pointer = head;

    }
    public Node<T> getHead(){
        return this.head;
    }
    public void direct(int numChildren){//each time we add, this method will be called. This method basically moves our n node to an appropriate direction
        //once direct method moves our node to correct node, our add method will do its job by adding a value to the node

        //these two are our base cases
        if(numChildren == 2){//when numchildren hits 2, n will be moved left
            pointer = pointer.getLeft();//move pointer to left
            //let us also increment the numchild of pointer
        }
        else if(numChildren == 3){//if numchildren is 3 that means the node belongs to right tree
            pointer = pointer.getRight();//pointer = pointer.right directs the pointer towards right
            //incrementing the child that's on right

        }
        else if(numChildren%2 == 0){// if numchildren is even then it should get directed to left
            direct(numChildren/2);
            if(pointer.getLeft()==null){
                return;
            }
            else{
                //the else statement will get executed only if left child is null
                pointer.incnumChild();
                pointer = pointer.getLeft();
            }
        }
        //if numchildren is odd then we will go to right
        else if(numChildren%2 == 1){//
            direct(numChildren/2);
            //if right child is null, we will return and do noting
            if(pointer.getRight()==null){
                return;
            }
            //if right is not null, we will change pointer to right and increment the the child count by1
            
            else{
              pointer.incnumChild();
              pointer = pointer.getRight();

            }
        }

    }
    //let us make a inorder traversal
    public T inorder(){

    }

    //we will  into tree by calling the add method of the Node
    public void add(Node<T> value){
        numChildren++;//increment number of children by 1
        if(numChildren == 1){
            head = value;
        }
        else if(numChildren==2){//if this is second child then we want this on right tree
            pointer.assignLeft(value);//if this is the second child we know right way this is a left node of tree

        }
        else if(numChildren==3){//if this is third child then we want this on left tree
            pointer.assignRight(value);//third child means right node of the head

        }
        else if((numChildren%2 == 0) && (numChildren>2)){//this block of code is only for child count that is even
            direct(numChildren);//we will ask the direct method where this node goes
            Node<T> leftChild = new Node<T>(value);//once direct method sets the pointer to the correct location
            pointer.assignLeft(leftChild);//we will add this value to the left child of the pointer

        }
        else if((numChildren%2 == 1) && (numChildren>3)){
            direct(numChildren);
            Node<T> rightChild = new Node<T>(value);
            pointer.assignRight(rightChild);

        }
        pointer = head;


    }

    public  static boolean isSumTree(Node<Integer> n){//this will call isSumTree method of the Node
        //the isSumTree() method has been written at line 30 of the Node class
        //this will return a boolean value based on isSumTree of node n
        return n.isSumTree(n);

    }

    public void pathToRoot(T value){
        this.head.pathToRoot(value);

    }

    public T LeastCommonSubsumer(T value1, T value2){
          return this.head.LeastCommonSubsumer(value1,value2);
    }

    public T siblings(T value){
      return this.head.siblings(value);
    }

    public int depth(){//this will call the depth() method of the head
        //will return the the number of nodes you have down before you reach null
        return this.head.depth();
    }

    public void addValue(T value){
        //add value takes in a value and incrments the number of children first
        //based on number of children, the pointer will point to an appropriate node
        numChildren++;//increment number of children by 1

        //1,2,3 are base cases.

        //If the node that is being added is 1st node, it will be head

        if(numChildren == 1){
           head = new Node<T>(value);
        }

        //if it is 2nd Node, it will be left of the head node
        else if(numChildren==2){//if this is second child then we want this on right tree
            Node<T> leftChild = new Node<T>(value);
            pointer.assignLeft(leftChild);
            head.incnumChild();


        }

        //if it is 3rd Node, it will go to right of the head node
        else if(numChildren==3){//if this is third child then we want this on left tree
            Node<T> rightChild  = new Node<T>(value);
            pointer.assignRight(rightChild);
            head.incnumChild();
        }

        //once the base cases are done, we will go a step better
        //if the number of children passed as argument is odd, the pointer has to be moved to left
        //because left nodes are even
        else if((numChildren%2 == 0) && (numChildren>2)){
            direct(numChildren);
            Node<T> leftChild = new Node<T>(value);
            pointer.incnumChild();
            pointer.assignLeft(leftChild);
            head.incnumChild();//we should not forget to increment head's children

        }
        //same goes for odd nodes except. Here, it will go towards right side
        else if((numChildren%2 == 1) && (numChildren>3)){
            direct(numChildren);
            Node<T> rightChild  = new Node<T>(value);
            pointer.incnumChild();
            pointer.assignRight(rightChild);
            head.incnumChild();

        }
        pointer = head;

    }
    //a toString method to return all the values of the tree
    public String toString(){
        String temp = "";
        temp = stringbuilder( temp, this.head);

        return temp;

    }

    //string builder
    public String stringbuilder(String temp, Node<T> newnode) {
        if (newnode != null) {
            temp += newnode.getValue() + ", ";
            // System.out.println("Test 1");
            temp = stringbuilder(temp, newnode.getLeft());
            // System.out.println("Test 2");
            temp = stringbuilder(temp, newnode.getRight());

            // System.out.println("Test 3");
            // System.out.println("Test 4");

        }
        return temp;
    }





}