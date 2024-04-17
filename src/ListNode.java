public class ListNode<T>{
    private T value;
    private ListNode<T> next;

    public ListNode(T value){
      this.value = value;
    }
    public void add(T value){
      this.value = value;
    }

    public T getValue(){
      return this.value;
    }

    public ListNode<T> next(){
      return this.next;
    }

    public void assignNext(ListNode<T> n){
      this.next = n ;
    }



}