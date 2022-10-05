
public class Graph_FindNoOfIsland {
    public  static  void noOfIsland(int arr[][],int i,int j,boolean visited[][]){
        if(  i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]==1 || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        noOfIsland(arr,i+1,j,visited);
        noOfIsland(arr,i-1,j,visited);
        noOfIsland(arr,i,j+1,visited);
        noOfIsland(arr,i,j-1,visited);
    }
    public  static  void main(String args[]){
        int arr[][]={{0,0,1,1,1,1,1,1},{0,0,1,1,1,1,1,1},{1,1,1,1,0,1,1,0},{1,1,0,0,0,1,1,0},{1,1,1,1,0,1,1,0},
                {1,1,1,1,0,1,1,0},{1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,0}};
        boolean visited[][]=new boolean[arr.length][arr[0].length];
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!visited[i][j] && arr[i][j]==0){
                    noOfIsland(arr,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
