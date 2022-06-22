//Thomas Evans
//Assignment #5
//2235 - 01
//Scoreboard with linked lists

//Code for the Doubly Linked List Class
public class DoublyLinkedList<E>{
  //Nested class
  private static class Node<E>{

    //Instantiate Variables
    private E element;
    private Node<E> prev;
    private Node<E> next;
    
    //Constructor
    public Node(E e, Node<E> p, Node<E> n){
      element=e;
      prev=p;
      next=n;
    }
    //Methods for element/forward/back
    public E getElement(){return element;}
    public Node<E> getPrev(){return prev;}
    public Node<E> getNext(){return next;}
    public void setPrev(Node<E> p){prev=p;}
    public void setNext(Node<E> n){next=n;}
  }
  //End Nested Node class
  
  //Instance Variables for the SLL class
  private Node<E> header =null;
  private Node<E> trailer =null;
  private int size =0;

  //Constructor for generic DoublyLinkedList
  public DoublyLinkedList(){
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
  }

  //Method for the Singly Linked List class
  //Access Methods
  public int getSize(){return size;}
  public boolean isEmpty(){return size==0;}

  //First method returns the element at the head of the list
  public E first(){
    if(isEmpty()) {return null;}
    return header.getNext().getElement();
  }
  //Last method: return the element at the tail of list
  public E last(){
    if(isEmpty()){ return null;}
    return trailer.getPrev().getElement();
  }
  //Update methods
  //addFirst Method: add new element as the head of the SLL
  public void addFirst(E e){
    addBetween(e, header ,header.getNext());
  }
  //addLast Method: add new element as the tail of SLL
  public void addLast(E e){
    addBetween(e, trailer.getPrev(), trailer);
  }

  //removeFirst method: This return and remove the head element
  public E removeFirst(){
    if (isEmpty()) return null;
    return remove(header.getNext());
  }

  //removeLast method: This return and remove the trailer element
  public E removeLast(){
    if (isEmpty()) return null;
    return remove(trailer.getNext());
  }

  //adds new entry between two list items and relinks them all
  private void addBetween(E e, Node<E> predecessor, Node<E> successor){
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }
    //removes an entry between two list items and relinks them all
  private E remove(Node<E> node){
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

}