import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseSingleListTest {

	@Test
	public void test() {
		//test1
		ReverseSingleList rsl = new ReverseSingleList();
		ReverseSingleList.Node n1 = rsl.new Node(1);
		ReverseSingleList.Node n2 = rsl.new Node(2);
		ReverseSingleList.Node n3 = rsl.new Node(3);
		ReverseSingleList.Node n4 = rsl.new Node(4);
		ReverseSingleList.Node n5 = rsl.new Node(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		String str = n5.value+"->"+n4.value+"->"+n3.value+"->"+n2.value+"->"+n1.value+"->";
		ReverseSingleList.Node rnode = rsl.reverse(n1);
		String rstr = "";
		while(rnode!=null){
			rstr+=rnode.value+"->";
			rnode = rnode.next;
		}
		assertEquals(str,rstr);
		
		//test2, list has only one element
		n1 = rsl.new Node(1);
		rnode = rsl.reverse(n1);
		str = n1.value+"->";
		rstr = rnode.value+"->";
		assertEquals(str,rstr);
	}
}
