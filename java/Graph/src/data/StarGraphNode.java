 package data;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;


public class StarGraphNode implements Comparator<StarGraphNode>, Comparable<StarGraphNode> {
	
	public int edge[];
	
	private Integer totalSize = 20;
	public Integer x;
	public Integer y;
	public int curCost = Integer.MAX_VALUE;
	public int cost = Integer.MAX_VALUE;
	// x ->
	// ^
 	// |
	// y
	public StarGraphNode(int x,int y,int totalSize){
		
		edge = new int[4];
		edge[1] = Integer.MAX_VALUE;
		edge[2] = Integer.MAX_VALUE;
		edge[0] = Integer.MAX_VALUE;
		edge[3] = Integer.MAX_VALUE;
		
		this.totalSize = totalSize;
		this.x = x;
		this.y = y;
		if(x == 0 && y == 0){
			//we're at root
			//right weight and down weight
			this.edge[3] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[2] = ThreadLocalRandom.current().nextInt(1,50);
		}else if(y == this.totalSize && x == this.totalSize){
			//left weight up weight
			this.edge[0] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[1] = ThreadLocalRandom.current().nextInt(1,50);
		}else if(x == 0){
			//left weight, right weight, down weight
			this.edge[1] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[3] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[2] = ThreadLocalRandom.current().nextInt(1,50);
		}else if(x == this.totalSize){
			// left weight down weight up weight
			this.edge[1] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[0] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[2] = ThreadLocalRandom.current().nextInt(1,50);
		}else if(y == this.totalSize){
			//left weight right weight up weight
			this.edge[1] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[3] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[0] = ThreadLocalRandom.current().nextInt(1,50);
		}else if(y == 0){
		  //left weight right weight, down weight
			this.edge[0] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[3] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[2] = ThreadLocalRandom.current().nextInt(1,50);
		}else{
			this.edge[0] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[3] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[2] = ThreadLocalRandom.current().nextInt(1,50);
			this.edge[1] = ThreadLocalRandom.current().nextInt(1,50);
			
		}
		//2 is down
		//3 is right
		//1 is up
		//0 left
	}
	
	public int compareTo(StarGraphNode o) {
		return this.cost - o.cost;

	}
	
	public int compare(StarGraphNode o1, StarGraphNode o2) {
		return o1.cost - o2.cost;
	}
	
	public String toString(){
		String returnMe = "";
		returnMe = returnMe + "("+ this.x.toString() + " " + this.y.toString() + ")";
		returnMe = returnMe + Integer.valueOf(this.edge[1]).toString()+" " + Integer.valueOf(this.edge[2]).toString() + " " +
				Integer.valueOf(this.edge[0]).toString() + " "+ Integer.valueOf(this.edge[3]).toString();
		return returnMe;
	}
}

