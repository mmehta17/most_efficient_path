package graphtest;

import java.util.Arrays;
import java.util.HashMap;

public class Johnsons {
	public static int[][] johnsonNaive(AdjacencyList graph,int[][] untouchedGraph){
		//int[][] untouchedGraph = graph.buildMatrix();

		//add node to graph with zero edges to all other nodes in graph
		HashMap<Integer,Integer> newNode = new HashMap<Integer,Integer>();
		for(int i = 0; i < graph.size;i++){
			newNode.put(i, 0);
		}
		graph.graph.put(graph.size, newNode);

		//perform bellman
		int[] weights = Bellman.bellman(graph,graph.size-1,0);
		if(weights == null){
			System.out.println("negative cycle!");
			return null;
		}

		//remove edge
		graph.graph.remove(graph.size);
		
		for(int i:graph.graph.keySet()){
			for(int j:graph.graph.get(i).keySet()){
				if(weights[i] != graph.MAX_INT && weights[j] != graph.MAX_INT){
					graph.graph.get(i).put(j,graph.graph.get(i).get(j)+weights[i]-weights[j]);
				}
			}
		}


		int[][] result = new int[graph.size][graph.size];
		for(int i = 0;i<graph.size;i++){
			result[i] = Dijkstra.dijkstraFib(graph, i, 1);
		}	
		
		
		
	
		
		//okay so now we have all the previous nodes we have to reconstruct the weight.
		int[][] distances = new int[graph.size][graph.size];
		for(int[] row:distances){
			Arrays.fill(row, graph.MAX_INT);
		}
		for(int j = 0;j<graph.size;j++){

			int[] row = result[j];
			for(int i = 0;i<graph.size;i++){
				int current = i;
				
				
				if(row[current] == -1){
					if(i == j){
						distances[j][i] = 0;
					}else{
						distances[j][i] = graph.MAX_INT;
					}	
				}else{
					int dist = 0;
					while(row[current] != -1){
						//edge from previous to current:
						dist = dist + untouchedGraph[row[current]][current]; //current current
						current = row[current];
					}
					distances[j][i] = dist;
				}
			
			}
		}
		return result;
	}
	

}
