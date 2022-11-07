import java.util.ArrayList;
import java.util.*;
public class Graph_BFS {
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
        public static class Pair{
            int v;
            String psf;
            Pair(int v,String psf){
                this.v=v;
                this.psf=psf;
            }
        }

        public static void main(String[] args) {
            int vces=7;
            ArrayList<Edge> graph[]=new ArrayList[7];
            for(int i=0;i<vces;i++){
                graph[i]=new ArrayList<Edge>();
            }
            graph[0].add(new Edge(0,3,40));
            graph[0].add(new Edge(0,1,10));
            graph[1].add(new Edge(1,0,10));
            graph[1].add(new Edge(1,2,10));
            graph[2].add(new Edge(2,3,10));
            graph[2].add(new Edge(2,1,10));
            graph[3].add(new Edge(3,0,40));
            graph[3].add(new Edge(3,2,10));
            graph[3].add(new Edge(3,4,2));
            graph[4].add(new Edge(4,3,2));
            graph[4].add(new Edge(4,5,3));
            graph[4].add(new Edge(4,6,3));
            graph[5].add(new Edge(5,4,3));
            graph[5].add(new Edge(5,6,3));
            graph[6].add(new Edge(6,5,3));
            graph[6].add(new Edge(6,4,8));
            ArrayDeque<Pair> queue=new ArrayDeque<>();
            queue.add(new Pair(2,2+""));
            boolean visited[]=new boolean[vces];
            while(queue.size()>0){
                Pair remove=queue.removeFirst();
                if(visited[remove.v]==true){
                    continue;
                }
                visited[remove.v]=true;
                System.out.println(remove.v+" "+remove.psf);
                for(Edge e:graph[remove.v]){
                    if(visited[e.nbr]==false){
                            queue.add(new Pair(e.nbr, remove.psf+e.nbr));
                    }
                }
            }
        }
    }
