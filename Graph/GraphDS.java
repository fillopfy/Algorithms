import java.util.*;
import java.io.*;

class Graph{
	int V;
	ArrayList<ArrayList<Integer>> adjlist;
	int[] distance;
	int[] parent;
	Graph(int v){
		this.V=v;
		this.adjlist=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<V;i++){
			adjlist.add(new ArrayList<Integer>());
		}
		distance=new int[V];
		parent=new int[V];
		Arrays.fill(distance,0);
		Arrays.fill(parent,-1);

	}

	void addEdge(int u, int v, boolean bidir){
		adjlist.get(u).add(v);
		if(bidir){
			adjlist.get(v).add(u);	
		}
		
	}

	void printList(){
		for(int i=0;i<V;i++){
			System.out.print(i+" -> ");
			for(int j=0;j<adjlist.get(i).size();j++){
				System.out.print(adjlist.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}


	void distanceFromSource(){
		for(int i=0;i<V;i++){
			System.out.print(distance[i]+" ");
		}
		System.out.println();

	}

	void parentNode(){
		for(int i=0;i<V;i++){
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}


	void dfs(int src){
		Stack<Integer> stack=new Stack<>();
		stack.push(src);
		Set<Integer> visited = new HashSet<>();
		visited.add(src);
		System.out.println("DFS: ");
		while(!stack.isEmpty()){
			int node=stack.pop();
			System.out.print(node+" ");
			for(int i=0;i<adjlist.get(node).size();i++){
				if(!visited.contains(adjlist.get(node).get(i))){
					stack.push(adjlist.get(node).get(i));
					visited.add(adjlist.get(node).get(i));
					//distnce calculation from src
					distance[adjlist.get(node).get(i)]=distance[node]+1;
					parent[adjlist.get(node).get(i)]=node;
				}
			}
		}
		System.out.println();
	}

	void path(int src, int dst){
		int temp=dst;
		StringBuilder s=new StringBuilder();
		while(temp!=src){
			// System.out.print(temp+" <-");
			s.append(temp);
			s.append(" >- ");
			temp=parent[temp];
		}
		s.append(temp);
		System.out.println(s.reverse().toString());

	}

	void bfs(int source){
		Queue<Integer> qu=new LinkedList<Integer>();
		qu.add(source);
		Set<Integer> visited=new HashSet<>();
		visited.add(source);
		System.out.println("BFS:");
		parent[source]=source;
		while(!qu.isEmpty()){
			int point=qu.poll();
			
			System.out.print(point+" ");
			ArrayList<Integer> list=adjlist.get(point);
			for(int i=0;i<list.size();i++){
				if(!visited.contains(list.get(i))){
					qu.add(list.get(i));
					visited.add(list.get(i));
					//Shortest distance
					distance[list.get(i)]=distance[point]+1;
					//Parent
					parent[list.get(i)]=point;
				}
			}

		}
		System.out.println();
	}
}

public class GraphDS{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		// System.out.println("Source and destination: ");
		// int u=sc.nextInt();
		// int v=sc.nextInt();
		// int n=sc.nextInt();
		Graph graph=new Graph(50);
		
		// for(int i=0;i<n;i++){
		// 	int u=sc.nextInt();
		// 	int v=sc.nextInt();
		// 	graph.addEdge(u,v);
		// }

		// graph.addEdge(0,1);
		// graph.addEdge(1,2);
		// graph.addEdge(2,4);
		// graph.addEdge(4,0);
		// graph.addEdge(4,3);
		// graph.addEdge(3,2);

		int[] board=new int[50];
		board[2]=13;
		board[5]=2;
		board[9]=18;
		board[18]=11;
		board[17]=-13;
		board[20]=-14;
		board[24]=-8;
		board[25]=10;
		board[32]=-2;
		board[34]=-22;

		//Insert edges

		for(int u=0;u<36;u++){
			for(int dice=1;dice<=6;dice++){
				int v=u+dice+board[u+dice];
				graph.addEdge(u,v,false);
			}
		}

		graph.printList();
		System.out.println();
		System.out.println();
		graph.bfs(0);
		System.out.println();
		System.out.println();

		// graph.dfs(0);
		// graph.parentNode();
		// graph.distanceFromSource();
		graph.path(0,36);
	}
}