//Thomas Evans
//Assignment #5
//2235 - 01
//Scoreboard with linked lists

//Code for the Singly Linked List Class
public class SinglyLinkedList<E>{
  //Nested class
  private static class Node<E>{
    //Instantiate Variables
    private E element;
    private Node<E> next;
    //Constructor
    public Node(E e, Node<E> n){
      element=e;
      next=n;
    }
    //Methods
    public E getElement(){return element;}
    public Node<E> getNext(){return next;}
    public void setNext(Node<E> n){next=n;}
  }
  //End Nested Node class
  //Instance Variables for the SLL class
  private Node<E> head =null;
  private Node<E> tail =null;
  private int size =0;

  //Constructor
  public SinglyLinkedList(){}//Just create empty SLL

  //Method for the Singly Linked List class
  //Access Methods
  public int getSize(){return size;}
  public boolean isEmpty(){return size==0;}

  //First method returns the element at the head of the list
  public E first(){
    if(isEmpty()) {return null;}
    return head.getElement();
  }
  //Last method: return the element at the tail of list
  public E last(){
    if(isEmpty()){ return null;}
    return tail.getElement();
  }
  //Update methods
  //addFirst Method: add new element as the head of the SLL
  public void addFirst(E e){
    head = new Node<>(e, head);
    if(size==0){
      tail=head;
    }
    size++;
  }
  //addLast Method: add new element as the tail of SLL
  public void addLast(E e){
    Node<E> newest = new Node<>(e, null);
    if(isEmpty()){
      head=newest;
    }
    else{
      tail.setNext(newest);
    }
    tail= newest;
    size++;
  }
  //removeFirst method: This return and remove the head element of the SLL
  public E removeFirst(){
    if(isEmpty()){return null;}
    E answer = head.getElement();
    head= head.getNext();
    size--;
    if(size==0){
      tail=null;
    }
    return answer;
  }

}