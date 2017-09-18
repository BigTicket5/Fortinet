
public class ReverseSingleList {
	
	class Node{
		Node next;
		int value;
		Node(int val){
			this.value = val;
		}
	}
	//Time complexity: O(n);
	//Space complexity: O(1);
	public Node reverse(Node head){
		if(head==null||head.next==null) return head;
		Node cur = head;
		Node nextNode = cur.next;
		Node prehead = new Node(-1);
		while(nextNode!=null){
			cur.next = prehead.next;
			prehead.next = cur;
			cur = nextNode;
			nextNode = nextNode.next;
		}
		cur.next = prehead.next;
		return cur;
	}
}
