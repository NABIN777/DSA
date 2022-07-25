import java.lang.reflect.Array;
import java.util.LinkedList;



/* Java program to merge two
sorted linked lists */
import java.util.*;

/* Link list node */
class Node
{
	int data;
	Node next;
	Node(int d) {data = d;
				next = null;}
}
	
class MergeLists
{
Node head;

/* Method to insert a node at
the end of the linked list */
public void addToTheLast(Node node)
{
	if (head == null)
	{
		head = node;
	}
	else
	{
		Node temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = node;
	}
}

/* Method to print linked list */
void printList()
{
	Node temp = head;
	while (temp != null)
	{
		System.out.print(temp.data + " ");
		temp = temp.next;
	}
	System.out.println();
}


// Driver Code
public static void main(String args[])
{
	/* Let us create two sorted linked
	lists to test the methods
	Created lists:
		llist1: 5->10->15,
		llist2: 2->3->20
	*/
	MergeLists llist1 = new MergeLists();
	MergeLists llist2 = new MergeLists();
    MergeLists llist3 = new MergeLists();
	
	// Node head1 = new Node(5);
	llist1.addToTheLast(new Node(2));
	llist1.addToTheLast(new Node(4));
	llist1.addToTheLast(new Node(7));
    llist1.addToTheLast(new Node(5));
    llist1.addToTheLast(new Node(10));

	
	// Node head2 = new Node(4);
	llist2.addToTheLast(new Node(3));
	llist2.addToTheLast(new Node(2));
	llist2.addToTheLast(new Node(7));
    llist2.addToTheLast(new Node(9));



    // Node head3 = new Node(4);
    llist3.addToTheLast(new Node(12));
    llist3.addToTheLast(new Node(5));
    llist3.addToTheLast(new Node(6));
    llist3.addToTheLast(new Node(9));
	
	
	llist1.head = new Nabin().sortedMerge(llist1.head,
										llist2.head, llist3.head);
	llist1.printList();	
	
}
}


class Nabin{



    Node sortedMerge(Node a, Node b,Node c)
    {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return c;
        if (c == null)
            return a;
        if (a.data <= b.data && a.data <= c.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b, c);
        }
        else if (b.data <= c.data && b.data <= a.data)
        {
            result = b;
            result.next = sortedMerge(a, b.next, c);
        }
        else if (c.data <= a.data && c.data <= b.data);
        {
            result = c;
            result.next = sortedMerge(a, b, c.next);
        }
        return result;
}





}




