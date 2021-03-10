package CollectionApiCoreJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapEquality {
	// default hmap eqauls() test that both hmap having same key value pair then true else false.
	public boolean isEqualDefault( HashMap<String, Integer> hmap1, HashMap<String, Integer> hmap2)
	{
		return hmap1.equals(hmap2);
	}

	public boolean keySetEquality(HashMap<String, Integer> hmap1, HashMap<String, Integer> hmap2)
	{
		return hmap1.keySet().equals(hmap2.keySet());
	}

	public boolean customEqual(HashMap<String, Integer> hmap1, HashMap<String, Integer> hmap2)
	{
		if( hmap1.size()!= hmap2.size())
		{
			return false;
		}
		return hmap1.entrySet().stream().allMatch(e-> e.getValue().equals(hmap2.get(e.getKey())));
	}



	public static void main(String[] args) {

		HashMap<String, Integer> hmap1= new HashMap<String, Integer>();
		HashMap<String, Integer> hmap2= new HashMap<String, Integer>();
		hmap1.put("A", 1);
		hmap1.put("B",2);
		hmap1.put("C", 3);

		hmap2.put("A", 1);
		hmap2.put("B",2);
		hmap2.put("C", 3);
		//hmap2.put("C", 4);

		HashMap< String, Integer> map3 = new HashMap<>();

		map3.put("A", 1);
		map3.put("B", 2);
		map3.put("C",3);
		map3.put("C",3);

		System.out.println(map3.size());
		//List< ? extends Object> list =  new ArrayList<String>();
		Object[] objArray = new String[100];
		objArray[1]= 100;
		

		HashMapEquality obj= new HashMapEquality();
		boolean result=obj.isEqualDefault(hmap1, hmap2);
		boolean keySetResult=obj.keySetEquality(hmap1, hmap2);
		boolean keySetresult1= obj.keySetEquality(hmap1, map3);

		System.out.println(result);
		System.out.println(keySetResult);
		System.out.println(keySetresult1);


	}

}
