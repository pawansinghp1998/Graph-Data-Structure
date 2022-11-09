import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph_SpreadOfInfection_BFS {
    public static class Edge{
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
        int t;
        Pair(int v,String psf,int t){
            this.v=v;
            this.psf=psf;
            this.t=t;
        }
    }

    public static void main(String[] args) {
        int vces=7;
        ArrayList<Edge> graph[]=new ArrayList[vces];
        for(int i=0;i<vces;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,3,40));
        graph[0].add(new Edge(0,1,40));
        graph[1].add(new Edge(1,0,40));
        graph[1].add(new Edge(1,3,40));
        graph[2].add(new Edge(2,3,40));
        graph[2].add(new Edge(2,1,40));
        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,40));
        graph[3].add(new Edge(3,4,40));
        graph[4].add(new Edge(4,3,40));
        graph[4].add(new Edge(4,5,40));
        graph[4].add(new Edge(4,6,40));
        graph[5].add(new Edge(5,4,40));
        graph[5].add(new Edge(5,6,40));
        graph[6].add(new Edge(6,4,40));
        graph[6].add(new Edge(6,5,40));
        int visited[]=new int[vces];
        ArrayDeque<Pair> queue=new ArrayDeque<Pair>();
        Pair start=new Pair(6,6+"",1);
        queue.add(start);
        int count=0;
        int time=4;
while(queue.size()>0){
    Pair remove=queue.removeFirst();
    if(visited[remove.v]>0){
        continue;
    }
    else{
        if(remove.t>time){
            break;
        }
        visited[remove.v]= remove.t;
        count++;
    }
    for(Edge e: graph[remove.v]){
        if(visited[e.nbr]==0){
            queue.add(new Pair(e.nbr, remove.psf+e.nbr, remove.t+1));
        }
    }
}
System.out.println("No of infected people in given time "+count);
    }
}
