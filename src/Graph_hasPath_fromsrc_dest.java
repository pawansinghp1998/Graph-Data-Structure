import java.util.ArrayList;

public class Graph_hasPath_fromsrc_dest{
        public  static  class Edge{
            int src;
            int nbr;
            int wt;
            Edge(int src,int nbr ,int wt){
                this.src=src;
                this.nbr=nbr;
                this.wt=wt;
            }
        }

        public  static  boolean hasPath(ArrayList<Edge>[] graph,int src, int dest,boolean visited[]){
            if(src==dest)
                return  true;
            visited[src]=true;
            for(Edge edge:graph[src]){
                if(!visited[edge.nbr]){
                boolean hasNbrPath=hasPath(graph,edge.nbr,dest,visited);
                if(hasNbrPath)
                    return  true;
            }}
            return false;
        }

        public static void main(String[] args) {
            int vces=7;
            ArrayList<Edge> graph[]=new ArrayList[7];
            for(int i=0;i<vces;i++){
                graph[i]=new ArrayList<Edge>();
            }
            graph[0].add(new Edge(0,1,10));
            graph[0].add(new Edge(0,3,10));
            graph[1].add(new Edge(1,0,10));
            graph[1].add(new Edge(1,2,10));
            graph[2].add(new Edge(2,1,10));
            graph[2].add(new Edge(2,3,10));
            graph[3].add(new Edge(3,2,40));
            graph[3].add(new Edge(3,0,10));
            graph[3].add(new Edge(3,4,10));
            graph[4].add(new Edge(4,3,10));
            graph[4].add(new Edge(4,5,10));
            graph[4].add(new Edge(4,6,10));
            graph[5].add(new Edge(5,4,10));
            graph[5].add(new Edge(5,6,10));
            graph[6].add(new Edge(6,5,10));
            graph[6].add(new Edge(6,4,10));
            boolean visited[]=new boolean[7];
            System.out.println(hasPath(graph,0,6,visited));
        }
    }