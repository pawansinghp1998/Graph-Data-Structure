import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph_FindAllPaths_DFS {
        public  static  class Edge{
            int src;
            int nbr;
            int wt;
            Edge(int src,int nbr ,int wt){
                this.src=src;
                this.nbr=nbr;
                this.wt=wt;
            }
        }static class Pair implements Comparable<Pair>{
            int wsf;
            String path;
            Pair(int wsf,String path){
                this.wsf=wsf;
                this.path=path;
            }
            public int CompareTo(Pair o){
                return this.wsf-o.wsf;
            }

        @Override
        public int compareTo(Pair o) {
            return 0;
        }
    }
      static  String maxPath;
        static int maxPathWt=Integer.MIN_VALUE;
       static String minPath;
      static int minPathWt=Integer.MAX_VALUE;
      static String ceilPath;
      static int ceilPathWt=Integer.MAX_VALUE;
      static String floorPath;
      static int floorPathWt=Integer.MIN_VALUE;
static PriorityQueue<Pair> pq= new PriorityQueue<>();
        public  static void findAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[],String path,int wsf,int criteria){
            if(src==dest) {
                if(wsf>maxPathWt){
                    maxPathWt=wsf;
                    maxPath=path;
                }
                if(wsf<minPathWt){
                    minPathWt=wsf;
                    minPath=path;
                }
                if(wsf>criteria && wsf<ceilPathWt){
                    ceilPathWt=wsf;
                    ceilPath=path;
                }
                if(wsf<criteria && wsf>floorPathWt){
                    floorPathWt=wsf;
                    floorPath=path;
                }
if(pq.size()<3) {
    pq.add(new Pair(wsf, path));
}
    else{
        if(wsf>pq.peek().wsf){
            pq.remove();
            pq.add(new Pair(wsf,path));
        }
    }

                return;
            }
            visited[src]=true;
            for(Edge edge:graph[src]){
                if(!visited[edge.nbr]){
                    findAllPath(graph,edge.nbr,dest,visited,path+edge.nbr,wsf+ edge.wt,criteria);
                }}
            visited[src]=false;
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
            findAllPath(graph,0,6,visited,0+"",0,40);
            System.out.println(maxPath);
            System.out.println(maxPathWt);
            System.out.println(minPath);
            System.out.println(minPathWt);
            System.out.println(ceilPath);
            System.out.println(ceilPathWt);
            System.out.println(floorPath);
            System.out.println(floorPathWt);

            for(Pair p:pq){
                System.out.print(p.wsf+" "+p.path+" ");
            }
        }
    }
