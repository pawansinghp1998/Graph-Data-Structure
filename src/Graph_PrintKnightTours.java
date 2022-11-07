import java.util.Scanner;

public class Graph_PrintKnightTours {
    public static void printKnightsTour(int chess[][],int r,int c,int mov){
        if(r<0||c<0||r>= chess.length||c>=chess[0].length||chess[r][c]>0){
            return;
        }
        else if(mov ==chess.length*chess[0].length){
          chess[r][c]=0;
          display(chess);
          chess[r][c]=0;
          return;
        }
        chess[r][c]=mov;
        printKnightsTour(chess,r-2,c+1,mov+1);
        printKnightsTour(chess,r-1,c+2,mov+1);
        printKnightsTour(chess,r+1,c+2,mov+1);
        printKnightsTour(chess,r+2,c+1,mov+1);
        printKnightsTour(chess,r+2,c-1,mov+1);
        printKnightsTour(chess,r+1,c-2,mov+1);
        printKnightsTour(chess,r-1,c-2,mov+1);
        printKnightsTour(chess,r-2,c-1,mov+1);
        chess[r][c]=0;
    }
    public static void display(int chess[][]){
        for(int i=0;i< chess.length;i++){
            for(int j=0;j<chess[0].length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter chess size");
        int n=sc.nextInt();
        System.out.println("Enter initial position");
        int row=sc.nextInt();
        int col=sc.nextInt();
        int chess[][]=new int[n][n];
        printKnightsTour(chess,row,col,1);
    }
}
