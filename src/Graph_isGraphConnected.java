import java.util.ArrayList;

public class Graph_isGraphConnected {
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
static ArrayList<ArrayList<Integer>> arrr=new ArrayList<>();
        public static void isGraphConnected(ArrayList<Edge>[] graph,int src,boolean visited[],ArrayList<Integer> arr){
if(!visited[src]){
    arr.add(src);
}
visited[src]=true;
for (Edge e:graph[src]){
    if(!visited[e.nbr]){
        isGraphConnected(graph,e.nbr,visited,arr);
    }
}
        }
        public static void main(String[] args) {
            int vces=7;
            ArrayList<Edge> graph[]=new ArrayList[7];
            for(int i=0;i<vces;i++){
                graph[i]=new ArrayList<>();
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
            boolean visited[]=new boolean[vces];
            for(int i=0;i<vces;i++){
                if(!visited[i]){
                    ArrayList<Integer> arr=new ArrayList<>();
                    isGraphConnected(graph,i,visited,arr);
                    arrr.add(arr);
                }

            }
            if(arrr.size()==1)
                System.out.println("Graph is connected");
            else
                System.out.println("Graph is not connected");
        }
    }
