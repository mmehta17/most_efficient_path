package graphtest;
import java.util.*;
///
/// Used for Dijkstra heap
//



public class DistanceNode implements Comparator<DistanceNode>, Comparable<DistanceNode> {
	int destination;
	int cost;
	public DistanceNode(int cost,int destination){
		this.cost = cost;
		this.destination = destination;
	}
	public int compareTo(DistanceNode d){
		int x = this.cost - d.cost;
		if (x == 0){
			return this.destination - d.destination;
		}
		else{
			return x;
		}
	}
	public int compare(DistanceNode d1,DistanceNode d2){
		int x = d1.cost - d2.cost;
		if (x == 0){
			return d1.destination - d2.destination;
		}
		else{
			return x;
		}
	}
	
}
