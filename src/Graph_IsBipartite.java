import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph_IsBipartite {
    public  static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public static class Pair{
        int v;
        String psf;
        int level;
        Pair(int v, String psf,int level){
            this.v=v;
            this.psf=psf;
            this.level=level;
        }
    }
    public static boolean isbipartite(ArrayList<Edge> graph[],Pair pair,int visited[]){
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(pair);
        while(queue.size()>0){
            Pair removed=queue.removeFirst();
            if(visited[removed.v]!=-1){
                if(removed.level!=visited[removed.v])
                    return false;
            }
            else {
                visited[removed.v] = removed.level;
            }
                for(Edge e:graph[removed.v]){
                    if(visited[e.nbr]==-1){
                        Pair pair1=new Pair(e.nbr,removed.psf+e.nbr, removed.level+1);
                       queue.add(pair1);
                    }
                }
            }
        return true;
    }

    public static void main(String[] args) {
        int vces=5;
        ArrayList<Edge> graph[]=new ArrayList[vces];
        for(int i=0;i<vces;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));

        int visited[]=new int[7];
        Arrays.fill(visited,-1);
        for(int i=0;i<vces;i++) {
            if (visited[i] == -1) {
                Pair pair = new Pair(i, i + "", 0);
                boolean isbipart = isbipartite(graph, pair, visited);
                if (!isbipart) {
                    System.out.println("Not bipartite");
                    return;
                }
            }
        }
        System.out.println(" bipartite");
    }
}
