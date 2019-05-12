package graphtest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
			
		StarGraph g1 = new StarGraph(24);
		g1.printGraph();
		
		
		/* Toy Example for Demonstration 
		 * 
		 * We look at a 25 node graph with
		 * 25*25*0.6 = 375 edges
		 * with min weight = 1
		 * and max weight = 543
		 * 
		 * 
		 * 
		 * */
		/*
		AdjacencyList graph = new AdjacencyList(25,0.6,1,543);
		for(int key:graph.graph.keySet()){
			System.out.print(key);
			System.out.print("-->");
			System.out.print(graph.graph.get(key));
			System.out.println("");
		}
		int[][] singles = new int[25][25];
		for(int source = 0;source<25;source++){
			int[] test1 = Dijkstra.dijkstra(graph, source);
			int[] test2 = Dijkstra.dijkstraFib(graph, source, 0);
			int[] test3 = Dijkstra.dijkstraHeap(graph, source);
			int[] test4 = Bellman.bellman(graph, source, 0);
			int[] test5 = Bellman.bellman_naive(graph, source);
			
			boolean correct = Arrays.equals(test1, test2) && Arrays.equals(test2, test3) 
			&& Arrays.equals(test3, test4) && Arrays.equals(test4, test5);
			singles[source] = test1;
			System.out.println(correct);
		}
		int[][] test2 = FloydWarshal.floydWarshalNaive(graph.buildMatrix());
		int[][] test1 = Johnsons.johnsonNaive(graph, graph.buildMatrix());
		
		//johnsons should be run last. does not keep graph data structure intact
		
		for(int i = 0;i<25;i++){
			System.out.println(Arrays.equals(singles[i],test2[i]) && Arrays.equals(test1[i], test2[i]));
		}
		for(int i = 0;i<25;i++){
			for(int j = 0;j<25;j++){
				System.out.print(singles[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}

		*/
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		//int nodes = 2000;
		/*
		for(int i = 0;i<25;i++){
			AdjacencyList graph = new AdjacencyList(10000,.01);
			System.out.println("test");
		}
		 //make sure we can reliably generate graphs of size n with p_edge x for experiments
		*/
		
		
		/*
		 * 
		 * 		
		ArrayList<ArrayList<Long>> bellman = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> bellmanNaive = new ArrayList<ArrayList<Long>>();
		long startTime;
		long endTime;
		long duration;
		double p_edge = .01;
		for(int nodes = 1000; nodes < 10000;nodes = nodes + 1000){
			ArrayList<Long> bellmanIteration = new ArrayList<Long>();
			ArrayList<Long> bellmanNaiveIteration = new ArrayList<Long>();
			for(int rep = 0; rep < 5; rep++){
				AdjacencyList graph = new AdjacencyList(nodes, p_edge,-10,1000);
				System.out.println(rep);
				
				startTime = System.nanoTime();
				int[] test1 = Bellman.bellman_naive(graph, 98);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				
				bellmanNaiveIteration.add(duration);
				//System.out.println("floyd done");
				
				startTime = System.nanoTime();
				int[] test3 = Bellman.bellman(graph, 98, 0);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				
				if(test1 == null && test3 == null){
					System.out.println("negative cycle");
				}
				if(!Arrays.equals(test1,test3)){
					System.out.println("invalid");
				}
				bellmanIteration.add(duration);
			}
			bellman.add(bellmanIteration);
			bellmanNaive.add(bellmanNaiveIteration);	
		}
		
		
		//write results to file
		try {
			PrintWriter writer = new PrintWriter("/Users/jgiesler/Desktop/exp2bbellman_results.csv","UTF-8");
			for(ArrayList<Long> arr:bellman){
				writer.println(arr.toString().replace("[", "").replace("]", "")
			            .replace(", ", ","));
			}
			writer.close();
			
			writer = new PrintWriter("/Users/jgiesler/Desktop/exp2bnaivebellman_results.csv","UTF-8");
			for(ArrayList<Long> arr:bellmanNaive){
				writer.println(arr.toString().replace("[", "").replace("]", "")
			            .replace(", ", ","));
			}
			writer.close();

			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		/*
		 * Old Test Cases
		 * -Building a random graph
		 * -Turning random graph into matrix
		 * -Testing Johnson and Floyd
		 * -Testing Dijkstra/bellman -all implementations get same results
		 * -Tested Negative Cycles
		 * 
		 * -Tested all algorithms on pen/paper
		 */

		
		//int nodes = 250000;
		//double p_edge = 0.0001;
		
		//int nodes = 30000;
		//double p_edge = 0.01;
		
		//int nodes = 5;
		//double p_edge = .3;
		//AdjacencyList graph = new AdjacencyList(nodes,p_edge)
		//for(int i:graph.graph.keySet()){
		//	System.out.println(graph.graph.get(i));
		//int[][] graphMat = graph.buildMatrix();
		//for(int[] row:graphMat){
		//	for(int i:row){
		//		System.out.print(i);
		//		System.out.print(" ");
		//	}
		//	System.out.println("");
		//}
		
		/*
		 * Negative Cycles and values
		 * set weightMin to -5 or something
		 */
		//AdjacencyList newGraph = AdjacencyList(nodes,p_edge,weightMin,weightMax)
		
		/*
		 * Testing Johnsons
		 * 
		int nodes = 5;
		double p_edge = .4;
		
		AdjacencyList graph = new AdjacencyList(nodes, p_edge);
		
		int[][] iterativeBellman = new int[nodes][nodes];
		for(int i =0;i<nodes;i++){
			iterativeBellman[i] = Bellman.bellman(graph, i,0);
		}
		
		for(int[] row:iterativeBellman){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		int[][] result = johnsons.johnsonNaive(graph);
		
		for(int[] row: result){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
		*/
		//int nodes = 10;
		//double p_edge =.2;

		/*

		*/
		
	
		
		
		
		/*
		//Testing floyd warshal
		
		int[][] hugeMatrix = graph.buildMatrix();
		

		int[][] result = floydWarshal.floydWarshalNaive(hugeMatrix.clone());	
		for(int[] row:result){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}

		System.out.println("\n\n\n");
		
		for(int i = 0;i<graph.size;i++){
			int[] toPrint = Bellman.bellman(graph, i);
			for(int j:toPrint){
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println("");
		}

		*/
		
		/*
		 // testing dijkstra and fib impl
		//run dijkstra with source of 1200 on our graph
		long startTime = System.nanoTime();
		int[] toPrint = Dijkstra.dijkstraFib(graph, 1200);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Fib Impl:");
		System.out.println(duration);
		//print results
		startTime = System.nanoTime();
		int[] secondPrint = Bellman.bellman(graph, 1200);
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Standard Impl");
		System.out.println(duration);
		
		System.out.println(Arrays.equals(toPrint, secondPrint));		
		*/
		
		
		
		/*
		 * Example of using timing functions
		ArrayList<ArrayList<Long>> floyd = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> johnson = new ArrayList<ArrayList<Long>>();
		long startTime;
		long endTime;
		long duration;
		
		int nodes = 2000;
		
		
		for(int i = 0;i<25;i++){
			AdjacencyList graph = new AdjacencyList(2000,.01);
			System.out.println("test");
		}
		
		//4,000 to 400,000 thousand edges by
		double p_edge = .001;
		for(int nodes = 5; nodes < 4000;nodes = nodes + 1000){
			System.out.println(p_edge);
			ArrayList<Long> floydIterations = new ArrayList<Long>();
			ArrayList<Long> johnsonIterations = new ArrayList<Long>();
			for(int rep = 0; rep < 5; rep++){
				AdjacencyList graph = new AdjacencyList(nodes, p_edge);
				int[][] graphMat = graph.buildMatrix();
				System.out.println(rep);
				startTime = System.nanoTime();
				int[][] test1 = FloydWarshal.floydWarshalNaive(graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				floydIterations.add(duration);
				//System.out.println("floyd done");
				
				startTime = System.nanoTime();
				int[][] test3 = Johnsons.johnsonNaive(graph,graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				johnsonIterations.add(duration);
			}
			johnson.add(johnsonIterations);
			floyd.add(floydIterations);	
		}
		
		 */
	}

}
