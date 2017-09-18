import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Separate2KGroupTest {

	@Test
	public void test() {
		Separate2KGroup sp = new Separate2KGroup();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(6);
		int k = 3;
		boolean res = sp.separate(list, k);
		assertEquals(true,res);
		k = 4;
		res = sp.separate(list, k);
		assertEquals(false,res);
	}

}
