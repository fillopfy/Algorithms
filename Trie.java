import java.util.*;


class Node{
	Node[] child;
	ArrayList<String> strings;
	int count;
	Node(){
		this.child=new Node[26];
		this.strings=new ArrayList<>();
		this.count=0;
	}
	Node root=null;
	public void insert(String word){
		if(root==null){
			root=new Node();
		}
		Node curr=root;
		word=word.toLowerCase();
		int n=word.length();
		for(int i=0;i<n;i++){
			char c=word.charAt(i);
			int idx=c-'a';
			if(curr.child[idx]==null)curr.child[idx]=new Node();
			curr=curr.child[idx];
		}
		
		curr.strings.add(word);
		curr.count++;
	}

	public boolean search(String word){
		if(root==null){
			return false;
		}
		Node curr=root;
		int n=word.length();
		for(int i=0;i<n;i++){
			int idx=word.charAt(i)-'a';
			if(curr==null){
				return false;
			}
			curr=curr.child[idx];
		}
		return curr.count>0;
	}

	public boolean startWith(String word){
		if(root==null){
			return false;
		}
		Node curr=root;
		int n=word.length();
		for(int i=0;i<n;i++){
			int idx=word.charAt(i)-'a';
			if(curr==null){
				return false;
			}
			curr=curr.child[idx];
		}
		return true;

	}
}


public class Trie{
	public static void main(String[] args){
		Node trie=new Node();
		trie.insert("abc");
		trie.insert("abd");
		System.out.println(trie.search("ab")?"Yes":"No");//No
		System.out.println(trie.search("abc")?"Yes":"No");//Yes
		System.out.println(trie.startWith("ab")?"Yes":"No");//Yes
		System.out.println(trie.startWith("a")?"Yes":"No");//Yes


	}
}