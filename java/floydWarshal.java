package graphtest;

public class FloydWarshal {
	//note this solution REQUIRES adjacency matrix.
	public static int[][] floydWarshalNaive(int[][] graph){
		int size = graph.length;

		//floyd warshal algorithm
		for(int k = 0; k<size;k++){
			for(int i = 0;i<size;i++){
				for(int j = 0;j<size;j++){
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		//check for negative cycles
		for(int i = 0;i<size;i++){
			if(graph[i][i]< 0){
				System.out.println("Negative cycle found");
				return null;
			}
		}
		return graph;
		
	}
	
}
