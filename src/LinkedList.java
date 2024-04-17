public class LinkedList<T> {
    private ListNode<T> head;//the head changes everytime we add something
    private int size;//returns the size of the linked list

    public LinkedList(){

    }
    public void addFront(Node<T> n){//we will first increase the size and then add the node into the linkedlist
      //everytime you add something it will go as the head of the code

       size++;
       if(size==1){//if this is the first listnode then it will be the head
        //we will fetch the value from the head node and put it in the listnode
         T val = n.getValue();

         ListNode<T> temp2 = new ListNode<T>(val);
         //once we have created a ListNode we will make it our head
         head = temp2;
       }
       else{
         T val = n.getValue();
         ListNode<T> temp = head;
         ListNode<T> temp2 = new ListNode<T>(val);

         while(temp.next()!=null){
           temp = temp.next();
         }
         temp.assignNext(temp2);


       }

    }

    public ListNode<T> getThis(){
        return head;
    }

    public ListNode<T> getNext(){
        return head.next();
    }

    public T headValue(){
      return head.getValue();
    }

    public T nextValue(){
      return this.next.getValue();
    }

    public int size(){
      return this.size;
    }

    public String toString(){//a to string method that converts all values into strings
       ListNode<T> dup = head;
       String toString = "";
       while(dup!=null){
         toString += dup.getValue();
           toString += "->";

         dup = dup.next();

       }
       return toString;
    }
}
