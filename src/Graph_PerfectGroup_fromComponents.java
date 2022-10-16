import java.util.*;
public class Graph_PerfectGroup_fromComponents {
    public static class Edge{
        int vces;
        int nbr;
        Edge(int vces,int nbr){
            this.vces=vces;
            this.nbr=nbr;
        }
    }
    public static void  findConnectedComponent(ArrayList<Edge> graph[],int src,boolean visited[], ArrayList<Integer> component){
    visited[src]=true;
    component.add(src);
       for(Edge e:graph[src]) {
           if (!visited[e.nbr]) {
               findConnectedComponent(graph, e.nbr, visited, component);
           }
       }
    }
    public static  int PossibleSelection(ArrayList<ArrayList<Integer>> arr){
        int total=0;
        for(int i =0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                total=total+arr.get(i).size()*arr.get(j).size();
            }
        }
        return  total;
    }
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter vertices and Edge");
//        int vces=sc.nextInt();
//        int edge=sc.nextInt();
//        System.out.println("Enter Edge Representation seperated by _");
//                for(int i=0;i<edge;i++){
//                    String e=sc.next();
//                }
        int vces=7;
        int edge=5;
        String e[]={"0_1","2_3","4_5","5_6","4_6"};
                ArrayList<Edge> graph[]=new ArrayList[vces];
                System.out.println(graph[0]);
                for(int i=0;i<vces;i++){
                    graph[i]=new ArrayList<>();
                }
        System.out.println(graph[0]);
                for(int i=0;i<e.length;i++){
                     String ege[]=e[i].split("_");
                     int s=Integer.parseInt(ege[0]);
                     int n=Integer.parseInt(ege[1]);
                     graph[s].add(new Edge(s,n));
                    graph[n].add(new Edge(n,s));
                }
                boolean visited[]=new boolean[vces];
                ArrayList<ArrayList<Integer>> components=new ArrayList<>();
                for(int i=0;i<edge;i++){
                    if(!visited[i]){
                        ArrayList<Integer> component=new ArrayList<>();
                      findConnectedComponent(graph,i,visited,component);
                      components.add(component);
                    }
                }

                int count=PossibleSelection(components);
                System.out.println(count);
    }
}
