package graphtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Bellman {
	public static int[] bellman(AdjacencyList graph, int source, int returnPrev){
		int size = graph.size;
		int[] pred = new int[size];
		int[] min_dist = new int[size];
		int[] closed = new int[size];

		int MAX_INT = 10000;
		
		Arrays.fill(pred, -1);
		Arrays.fill(min_dist, MAX_INT);
		Arrays.fill(closed, 1);
		
		min_dist[source] = 0;
		closed[source] = 0;

		for(int i = 0; i<size;i++){
			for(int v:openCheck(closed)){
				HashMap<Integer,Integer> neighbors = graph.getNeighbors(v);
				
				for(int x:neighbors.keySet()){
					int weight = graph.graph.get(v).get(x); //equiv to graph[v][x] in adj mat
					if(min_dist[x] > min_dist[v] + weight){
						min_dist[x] = min_dist[v] + weight;
						pred[x] = v;
						closed[x] = 0;
					}	
				}
				closed[v] = 1;
			}
		}
		
		//need to check for negative cycles
		for(int v = 0;v<size;v++){
			HashMap<Integer,Integer> neighbors = graph.getNeighbors(v);
			for(int x:neighbors.keySet()){
				if(min_dist[x] > min_dist[v] + graph.graph.get(v).get(x)){
					//oh crap we found a negative cycle
					return null;
				}
			}
		}
		
		if(returnPrev == 1){
			return pred;
		}else{
			return min_dist;
		}
		
	}
	private static Integer[] openCheck(int arr[]){
		ArrayList<Integer> opens = new ArrayList<Integer>();
		for(int i = 0;i<arr.length;i++){
			if(arr[i] == 0){
				opens.add(i);
			}
		}
		Integer[] returnMe = new Integer[opens.size()];
		return opens.toArray(returnMe);
	}
}
