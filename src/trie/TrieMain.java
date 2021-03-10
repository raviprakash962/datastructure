package trie;

public class TrieMain {
	
	public static void main(String args[])
	{
		Trie trie= new Trie();
		
		//CASE# 1
		trie.insert("bcde");
		trie.insert("bckg");
		trie.delete("bcde");
		trie.search("bcde");
		trie.search("bckg");
		
		//CASE #2
		
		trie.insert("bcdf");
		trie.insert("bcdfgh");
		trie.delete("bcdf");
		trie.search("bcdf");
		trie.search("bcdfgh");
		
		//Case 3
		
		trie.insert("AEROPLANE");
		trie.insert("AERO");
		trie.delete("AEROPLANE");
		trie.search("AEROPLANE");
		trie.search("AERO");
		trie.search("AE");
		trie.search("A");
		
		//CASE # 4
		
		trie.insert("AIR");
		trie.delete("AIR");
		trie.search("AIR");
	}

}
