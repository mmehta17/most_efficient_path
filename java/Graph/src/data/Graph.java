package data;

import java.util.Comparator;


/*
 * Data Structure for storing the graph that will be
 * processed by the A* algorithm. 
 * 
 * This is and adjacency list representation of the graph.
 * The Graph[m][n] serves the purpose of the list.
 * This makes referencing individual nodes more efficient.
 * 
 * sub class edge is the element of the adjacency list for
 * each node
 * 
 * the dimensions of the graph must be specified at the
 * point of creation
 * 
 * Author: Utkarsh Khanna
 */
public class Graph {
public node Map[][];
	
	public Graph(int x, int y) {
		Map = new node[x][y];
	}
	
	public class node implements Comparator<node>, Comparable<node>{
		
		node parent = null;
		public int x;
		public int y;
		
		public int heapIndex;
		public boolean discovered = false;
	
		public int[] edge = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		public int curCost = Integer.MAX_VALUE; //Actual cost of reach the node
		public int estCost = Integer.MAX_VALUE; //Heuristic cost
		public int cost = Integer.MAX_VALUE;
		public int compareTo(node o) {
			return this.cost - o.cost;

		}
		public int compare(node o1, node o2) {
			return o1.cost - o2.cost;
		}
	}
	
	
	public boolean addEdge(int x, int y, int dir, int weight) {
		
		if(Map[x][y].edge[dir] == Integer.MAX_VALUE) {
			Map[x][y].edge[dir] = weight;
			return true;
		}
			
		return false;
	}
	
}
