import java.io.*;

public class LinkedList {
	Node head; // head of the list

	static class Node {
		int data;
		Node next;

		// Constructor of the Node next is by default null
		Node(int d) {
			data = d;
		}
	}

	// creation and insertion in the list
	public static LinkedList insert(LinkedList list, int data) {
		// create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// if Linked list is empty insert the node at the head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// else traverse till the last node and insert new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			// insert the new_node as next of last node
			last.next = new_node;
		}
		// return the list by head
		return list;
	}

//Method to print the List
	public static void printList(LinkedList list) {
		// start from the head
		Node currNode = list.head;
		while (currNode != null) {
			// print the data
			System.out.print(currNode.data + " ");
			// Go to next node
			currNode = currNode.next;
		}
		System.out.println();
	}

	//Deletion by key of the list
	public static LinkedList deleteByKey(LinkedList list, int key) {
		
		//Store the head node of the list to begin with
		Node currNode = list.head, prev = null;
		//Case 1: if key to be deleted is present at head
		if(currNode != null && currNode.data == key) {
		list.head =currNode.next; 
		System.out.println(key+" found and deleted");
		return list;
		}
		while (currNode != null && currNode.data != key) {
			// If currNode does not hold key continue to next node
			prev = currNode;
			currNode = currNode.next;
		}
		//if the key was present in the list, it should be at currNode therefore currNode shall not be null
		if(currNode!=null) {
			// Since the key is at currNode
            // Unlink currNode from linked list
			prev.next = currNode.next;
			System.out.println(key + " found and deleted");
		}
		else {
		//CASE 3 if key is not present can be else of above if
		System.out.println(key+ " not Found");
		}
		return list;
	}
	void printMiddle() {
		Node slowptr = head;
		Node  fastptr = head;
		if(head!=null)		
		{ 
			//when fast pointer has reached the end, slow pointer would be at the centre.
			while(fastptr!= null && fastptr.next!=null) 
			{
			//fast pointer will hop two spaces
			fastptr = fastptr.next.next;
			//slow pointer will hop one space at a time
			slowptr = slowptr.next;
		}
			System.out.println("The middle of the Linked List is : "+slowptr.data);
			}
		
	}
	
	//Driver Method
public static void main(String[] args) {
	  
	LinkedList list = new LinkedList();
	//insert values
	list.insert(list, 1);
	list.insert(list, 2);
	list.insert(list, 3);
	list.insert(list, 4);
	list.insert(list, 5);
	list.insert(list, 6);
	list.insert(list, 7);
	list.insert(list, 8);
	list.insert(list, 9);
	list.insert(list, 9);
	   // Print the LinkedList
    printList(list);
    list.printMiddle();
    //
    // ******DELETION BY KEY******
    //

    // Delete node with value 1
    // In this case the key is ***at head***
    deleteByKey(list, 1);

    // Print the LinkedList
    printList(list);

    // Delete node with value 4
    // In this case the key is present ***in the
    // middle***
    deleteByKey(list, 4);

    // Print the LinkedList
    printList(list);

    // Delete node with value 10
    // In this case the key is ***not present***
    deleteByKey(list, 10);

    // Print the LinkedList
    printList(list);
	
}
}
