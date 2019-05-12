package data;

public class StarGraph {
	public StarGraphNode[][] Map;
	
	public StarGraph(int n){
		this.Map = new StarGraphNode[n][n];
		for(int i = 0; i <n;i++){
			for(int j = 0; j<n;j++){
				Map[i][j] = new StarGraphNode(i,j,n-1);
			}
		}
	}
	public void printGraph(){
		for(StarGraphNode[] asdf:this.Map){
			for(StarGraphNode i:asdf){
				System.out.println(i.toString());
			}
		}
	}
}
