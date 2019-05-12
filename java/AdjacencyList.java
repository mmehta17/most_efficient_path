package graphtest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AdjacencyList {
	//our graph
	public Map<Integer,HashMap<Integer,Integer>> graph = new HashMap<Integer,HashMap<Integer,Integer>>();
	
	public int size = 0;
	public int MAX_INT = 10000;
	private int weightMax = 500;
	private int weightMin = 1;
	

	public AdjacencyList(int nodes, double p_edge, int weightMin,int weightMax){
		this.weightMax = weightMax;
		this.weightMin = weightMin;
		buildGraph(nodes,p_edge);
	}
	public AdjacencyList(int nodes, double p_edge){
		buildGraph(nodes,p_edge);
	}

	private void buildGraph(int nodes, double p_edge){
		//calculate number of edges
		//we will need to explore performance based on p_edge for some algorithms
		double x = (double)nodes * (double)nodes;
		double edges = x * p_edge;
		//System.out.println(edges);
		
		this.size = nodes;
		//initialize graph for each source node
		//the second hash map will map destination nodes for weight of edge
		for(int i = 0;i<nodes;i++){
			// dict.put(i, new ArrayList<connection>());
			this.graph.put(i, new HashMap<Integer,Integer>());
		}
		
		for(int i = 0;i<edges;i++){
			//for each edge we need find a source, destination and weight value
			int source = ThreadLocalRandom.current().nextInt(0,nodes);
			int dest = ThreadLocalRandom.current().nextInt(0,nodes);
			int weight = ThreadLocalRandom.current().nextInt(this.weightMin,this.weightMax);
			
			//make sure that we don't already have a edge from our source to dest
			//generate dests until we find one which has not been assigned
			//we also need to make sure we are not making a loop at source
			while(this.graph.get(source).get(dest) != null || source == dest){
				dest = ThreadLocalRandom.current().nextInt(0,nodes);
			}
			
			//add our new source -> dest w/ weight to graph
			this.graph.get(source).put(dest, weight);

		}
		//System.out.println(this.graph.get(0));
		//System.out.println("Finishing Graph Build");
	}
	
	public HashMap<Integer,Integer> getNeighbors(int node){
		//for a specific node return all neighbors and their weights
		return this.graph.get(node);
	}
	
	public int[][] buildMatrix(){
		if(this.size > 30000){
			//add case here complaining about memory usage
			//with 6gb of a heap we run into issues greater than 30,000nodes
			System.out.println("too big of matrix for memory");
			return null;
		}
		
		int[][] bigMatrix = new int[size][size];
		for(int[] row:bigMatrix){
			Arrays.fill(row, this.MAX_INT);
		}
		
		for(int i = 0; i<this.size;i++){
			bigMatrix[i][i] = 0;
		}
		
		
		for(int node:this.graph.keySet()){
			for(int neighbor:this.getNeighbors(node).keySet()){
				bigMatrix[node][neighbor] = this.graph.get(node).get(neighbor);
			}
		}
		
		return bigMatrix;
	}
	
}
