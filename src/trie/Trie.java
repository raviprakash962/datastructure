package trie;

import java.util.HashMap;
import java.util.*;

public class Trie {
	
	// Inner Class
	private class TrieNode
	{
		Map<Character, TrieNode> children;
		boolean endOfWords;
		
		public TrieNode()
		{
			children= new HashMap<>();
		}
	}
	
	private final TrieNode root;
	
	public Trie()
	{
		root= new TrieNode();
	}
	
	// insert a word in Trie
	public void insert(String word)
	{
	 TrieNode current =root;
	 for(int i=0;i<word.length();i++)
	 {
		 char ch= word.charAt(i);
		 TrieNode node= current.children.get(ch);
		 if(node==null)
		 {
			 node= new TrieNode();
			 current.children.put(ch, node);
		 }
		 current= node; 
	 }
	 current.endOfWords=true;
	 System.out.println(word+" inserted successfully in Trie!");
	}
	
	//Search for a word in Trie
	public boolean search(String word)
	{
		TrieNode current= root;
		
		for( int i=0;i< word.length();i++)
		{
			char ch= word.charAt(i);
			TrieNode node= current.children.get(ch);
			if(node==null)
			{
				//CASE 1 : if Word does not exist then return false 
				System.out.println( word +" not avilable in Trie ");
				return false;
			}
			current= node;
		}
		if(current.endOfWords==true)
		{
			//CASE 2: Word avilable in Trie
			System.out.println(word +" available in Trie  ");
			return true;
		}else {
			//CASE 3: When word exist as prefix for another words
			System.out.println(word +" is a prefix for another words , does not exists in Trie as a complete word. ");
		}
		return current.endOfWords;
	}
	
	public void delete(String word)
	{
		if( search(word)== true)
		{
			delete(root, word,0);
		}
	}
	
	private boolean delete(TrieNode parentNode, String word, int index)
	{
	 /*
	  * CASE 1: Some Other words prefix is same as prefix of this word(BCDE,BCDF)
	  * CASE 2: We are at last character of this word and this word is a prefix for some other words(BCDE,BCDEF)
	  * CASE 3: Some other word is a prefix of this word(BCDE,BC);
	  * CASE 4: No one is dependent on this word(BCDE,BCDE)
	  * 	
	  */
		char ch=word.charAt(index);
		TrieNode currentNode= parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		if(currentNode.children.size() >1)
		{
			System.out.println(" -------Entering Case1-------- ");
			delete(currentNode, word,index+1);
			return false;
		}
		
		if(index==word.length()-1)
		{
			System.out.println(" ------ Entering Case2--------");
			if(currentNode.children.size() >= 1)
			{
				currentNode.endOfWords=false;// Updating the value will signify that this word is no more avilable.
				return false;
			}else {
				System.out.println(" No dependency , Deleting this node.");
				parentNode.children.remove(ch);
				return true;
			}
		}
		
		if(currentNode.endOfWords==true)
		{
			//CASE3
			System.out.println(" ---------Entering CASE #3--------------------");
			delete(currentNode,word, index+1);
			return false;
		}
		System.out.println(" --------Enteiring CASE1------------");
		canThisNodeBeDeleted=delete(currentNode,word,index+1);
		if(canThisNodeBeDeleted==true)
		{
			System.out.println(" character "+ ch+" has no dependency, hence delting the node.");
			parentNode.children.remove(ch);
			return true;
			
		}else {
			return false;
		}
	}
}
