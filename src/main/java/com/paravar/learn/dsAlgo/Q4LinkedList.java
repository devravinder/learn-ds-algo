package com.paravar.learn.dsAlgo;

public class Q4LinkedList {
    public static void main(String[] args) {

        OwnLinkedList<Number> linkedList = new OwnLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.print();

        System.out.println(" before reverse ");
        linkedList.reverse();


        linkedList.print();

    }
}

class OwnLinkedList<T> {
    private Node<T> head;
    int size;

    public void add(T data){
        Node<T> node = new Node<>(data);

        if(head==null){
            head=node;
            size++;
            return;
        }

        Node<T> temp = head;

        while (temp.getNext()!=null){
            temp = temp.getNext();
        }

        temp.setNext(node);
        size++;

    }



    void print(){
        print(head);
        /*
        Node<T> temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.getNext();
        }*/

    }

    private void print(Node<T> node){
        if (node==null)
            return;

        System.out.println(node.data);
        print(node.getNext());
//         System.out.println(node.data); // reverse order

    }

    public void reverse(){

        head = reverse(head);
    }

    private Node<T> reverse(Node<T> current){

        // if the list is empty (current is null) or we reached the last node
        if(current==null || current.next == null) // ***
            return current;

        Node<T> newHead = reverse(current.next);

        current.next.next = current; // Set the next node's next pointer to the current node // ***
        current.next = null; // break the original

        return newHead;
    }

    public  Node<T> reverse2(Node<T> head) {
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = next;               // move curr
        }
        return prev; // new head
    }

    public  boolean search(Node<T> head, T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public  boolean searchRecursive(Node<T> head, T key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        return searchRecursive(head.next, key);
    }

    public  Node<T> remove(Node<T> head, T key) {

        // Case 1: head itself needs to be removed
        if (head != null && head.data == key) {
            return head.next;
        }

        Node<T> curr = head;

        while (curr.next != null) {
            if (curr.next.data == key) {
                curr.next = curr.next.next; // unlink
                break;
            }
            curr = curr.next;
        }

        return head;
    }

    public  Node<T> removeAll(Node<T> head, T key) {

        // Remove leading matches
        while (head != null && head.data == key) {
            head = head.next;
        }

        Node<T> curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public  Node<T> removeWithDummy(Node<T> head, T key) {

        // Avoids special head handling 👌 // best practice
        Node<T> dummy = new Node<T>(null);
        dummy.next = head;

        Node<T> curr = dummy;

        while (curr.next != null) {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }



}
class  Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
    // setter & getter

    Node<T> getNext(){
        return next;
    }
    void  setNext(Node<T> node){
        this.next = node;
    }
}

