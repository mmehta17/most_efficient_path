package implement;

import search.A_star;
import data.Graph;
import data.StarGraph;

public class Execute {
	
	public static void main(String args[]) {
		StarGraph G = new StarGraph(50);

		A_star A = new A_star();
		A.setGraph(G);
		A.setTarget(43, 19);
		System.out.println(A.astar(0, 0));
	}

	@SuppressWarnings("unused")
	private static void printGraph(Graph G) {
		int rows = G.Map.length;
        int columns = G.Map[0].length;
        String str = "|\t";

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                str += G.Map[i][j].cost + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }
	}
}
