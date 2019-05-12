//Jai Sai Ram//
package search;
import java.util.PriorityQueue;

import data.*;
//import data.Graph.node;


public class A_star {
	
	StarGraph G;
	StarGraphNode target;
	
	//Expected by the execution method
	public void setGraph(StarGraph G) {
		this.G = G;
	}
	
	public void setTarget(int x, int y) {
		target = G.Map[x][y];
	}
	
	/*
	 * A* search algorithm that takes as input
	 * x and y variable of the start node in
	 * the Graph structure 'Graph'
	 */
	public int astar(int X, int Y) {
		StarGraphNode start = G.Map[X][Y];
		start.curCost = 0;
		
		int currentCost = 0;
		
		PriorityQueue<StarGraphNode> Q = new PriorityQueue<StarGraphNode>();
		Q.add(start);
		//System.out.println(start.toString());
		
		StarGraphNode current;
		while(Q.size() != 0) {
			current = Q.poll();
			currentCost = current.curCost;
			if (current.equals(target))
				return target.curCost;
			/*
			for(int test:current.edge){
				System.out.println("x");
				System.out.println(test);
			}
			*/
			for(int i = 0; i < 4; i++) {
				StarGraphNode neighbour = null;
				if(current.edge[i] != Integer.MAX_VALUE){
					//System.out.println(current.edge[i]);
					if(i == 0 && current.x != 0){
						//System.out.println("left");
						neighbour = G.Map[current.x-1][current.y];
					}else if(i == 1 && current.y != 0){
						//System.out.println("up");
						 neighbour = G.Map[current.x][current.y-1];
					}else if(i == 3 && current.x != 49){
						//System.out.println("right");
						neighbour = G.Map[current.x+1][current.y];
					}else if(current.y != 49){
						//System.out.println("down");
						neighbour = G.Map[current.x][current.y+1];
					}
					
			
				//System.out.println(neighbour.toString());
				if ((neighbour != null) && (currentCost + current.edge[i] < neighbour.curCost)){
					//System.out.println(neighbour.toString());
						//System.out.println(neighbour);
					//System.out.println(currentCost+current.edge[i]);
					//System.out.println(neighbour.curCost);
					neighbour.curCost = currentCost + current.edge[i];
					neighbour.cost = neighbour.curCost + heuristic(neighbour.x, neighbour.y);
					Q.add(neighbour);
				} else{
					//System.out.println(currentCost+current.edge[i]);
					//System.out.println(neighbour.curCost);
				}
			}
			}
		}
		return -1;
	}
	
	//2 is down
	//3 is right
	//1 is up
	//0 left

	private int heuristic(int x, int y) {
		//Manhattan distance between current and target
		return (target.x - x) + (target.y - y);
	}
}
