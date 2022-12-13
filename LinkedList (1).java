
public class LinkedList {
	private Node head = null;
	private static int serialNumber=0;	
	
	public void insertFront(String info) {
		Node t = new Node(info);
		t.next = head;
		head = t;
	}
	
	public String removeFront() {
		if (head==null) return "List is empty!!";
		String data = head.stuff;
		head = head.next;
		return data;
	}
	
	public void insertRear(String info) {
		Node t = new Node(info);
		Node rear;
		if (head==null) {
			head = t;
		}
		else {
			rear = head;
			while(rear.next!=null) rear = rear.next;
			rear.next = t;
		}
	}
	
	public String removeRear() {
		// List is empty
		if (head==null) return "List is empty!!";

		String data;

		// List has only one Node
		if (head.next==null) {
			data = head.stuff;
			head = null;
			return data;
		}

		// List has more than one Node
		Node rear;
		Node next_to_rear;

		rear = head;
		next_to_rear = null;
		
		while(rear.next!=null) {
			next_to_rear = rear;
			rear = rear.next;
		}
		data = rear.stuff;
		next_to_rear.next = null;	

		return data;
	}
		
	
	public void print() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		Node q = head;
		while (q!=null) {
			System.out.println(q);
			q = q.next;
		}
	}
	
	class Node{

		int id;
		String stuff;
		Node next=null;
		
		public Node(String data) {
			id = ++serialNumber;
			stuff = data;
		}
		public Node() {
			id = ++serialNumber;
			stuff = "";
		}
		
		public String toString() {
			String out;
			out = ""+id+": "+stuff+"  Links to: ";
			if (next==null)
				out+="End of List";
			else
				out += next.id;
			return out;
		}
	}
}
