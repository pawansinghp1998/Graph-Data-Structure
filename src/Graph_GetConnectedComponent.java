import java.util.ArrayList;
public class Graph_GetConnectedComponent {
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
        public static void findComponent(ArrayList<Edge>[] graph,int src,boolean visited[],ArrayList<Integer> arr){
            if(!visited[src]){
                arr.add(src);
            }
            visited[src]=true;
       for(Edge e:graph[src]){
           if(!visited[e.nbr]){
               findComponent(graph,e.nbr,visited,arr);
           }
       }
        }

        public static void main(String[] args) {
            int vces=7;
            ArrayList<Edge> graph[]=new ArrayList[7];
            for(int i=0;i<vces;i++){
                graph[i]=new ArrayList<>();
            }
            graph[0].add(new Edge(0,1,10));
            graph[1].add(new Edge(1,0,10));
            graph[2].add(new Edge(2,3,10));
            graph[3].add(new Edge(3,2,10));
            graph[4].add(new Edge(4,5,10));
            graph[4].add(new Edge(4,6,10));
            graph[5].add(new Edge(5,4,10));
            graph[5].add(new Edge(5,6,10));
            graph[6].add(new Edge(6,4,10));
            graph[6].add(new Edge(6,5,10));
            boolean visited[]=new boolean[vces];
            for(int i=0;i<vces;i++){
                if(!visited[i]) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    findComponent(graph, i, visited, arr);
                    arrr.add(arr);
                }
            }
          System.out.println(arrr);
        }
    }

