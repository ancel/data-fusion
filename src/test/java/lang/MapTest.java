package lang;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	
	@Test
	public void test(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, "asdf");
	}
}
