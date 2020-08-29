import java.util.*;
import java.io.*;

class Graph<T>{
	Map<T, LinkedList<T>> adjList;

	Graph(){
		adjList=new HashMap<>();
	}

	void addEdge(T u, T v){
		if(adjList.containsKey(u)){
			adjList.get(u).add(v);
		}else{
			adjList.put(u, new LinkedList<T>());
			adjList.get(u).add(v);
		}

		if(adjList.containsKey(v)){
			adjList.get(v).add(u);
		}else{
			adjList.put(v, new LinkedList<T>());
			adjList.get(v).add(u);
		}
	}

	void printList(){
		for(T key:adjList.keySet()){
			LinkedList<T> list=adjList.get(key);
			System.out.print(key+" => ");
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}

public class GraphDS2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Graph<String> graph=new Graph<String>();

		while(n-->0){
			String a=sc.next();
			String b=sc.next();
			graph.addEdge(a,b);
			// graph.addEdge(b,a);
		}

		graph.printList();
	}
}