import java.util.ArrayList;
import java.util.HashSet;

public class Graph_isHamiltonPathAndCycle {
    public static  class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public  static void checkHamiltonPathAndCycle(ArrayList<Edge> graph[],int src,String Path,HashSet<Integer> visited
    ,int initialsrc){
        if(visited.size() == graph.length - 1){
            System.out.println(Path);
            boolean closingEdgeFound=false;
            for(Edge e:graph[src]){
                if(e.nbr==initialsrc){
                   closingEdgeFound=true;
                   break;
                }
            }
            if(closingEdgeFound) {
                System.out.println('*');
            }
            else {
                System.out.println('.');
            }
            return;
        }
        visited.add(src);
        for(Edge edge:graph[src]){
            if(!visited.contains(edge.nbr)){
                checkHamiltonPathAndCycle(graph,edge.nbr,Path+edge.nbr,visited,initialsrc);
            }
        }
        visited.remove(src);
    }

    public static void main(String[] args) {
        int vces=7;
        ArrayList<Edge> graph[]=new ArrayList[7];
        for(int i=0;i<vces;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,5));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,6));
        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        graph[6].add(new Edge(6,4));
        graph[6].add(new Edge(6,5));
        HashSet<Integer> visited=new HashSet<>();
        checkHamiltonPathAndCycle(graph,0,0+"",visited,0);
    }
}
