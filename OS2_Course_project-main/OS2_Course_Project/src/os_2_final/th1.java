/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_2_final;

/**
 *
 * @author hp
 */
public class th1 implements Runnable { 
    private  boolean res ;
    private int [] [] square = new int [4][4];
//    private int dim1 ,dim2;
//    
//    th1(int dim1_org,int dim2_org)
//    {
//        this.dim1=dim1_org;
//        this.dim2=dim2_org;
//    }
//    private int [][] piece  = new int [dim1][dim2];
    private int[][] piece;

    public boolean isRes() {
        return this.res;
    }

    public void setSquare(int[][] square) {
        this.square = square;
    }

    public void setPiece(int[][] piece_org) {
     this.piece=piece_org;    
    }
    
    
    @Override
     public void run() {
//         System.out.print(this.piece.length + " "+this.piece[0].length);
//         System.out.println();
//          for (int x=0;x<piece.length;x++)
//          {
//              for (int y=0;y<piece[0].length;y++)
//              {
//                  System.out.print(" "+piece[x][y]);
//              }
//              System.out.println();
//          }

int x = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (square[i][j] == 0)
                {
                    int r = j;
                    int[][] copy = new int[4][4];
                    for(int k = 0 ; k < 4 ; k++)
                    {
                        for(int m = 0 ; m < 4 ; m++)
                        {
                            copy[k][m] = square[k][m] ;
                        }
                    }
                    for (int i1 = 0; i1 < piece.length; ++i1)
                    {
                        for (int j1 = 0; j1 < piece[0].length; ++j1)
                        {
                            if (piece[i1][j1] != 0 && x == 0)
                            {
                                j = j - j1;
                                x = 1;
                            }
                            if (x == 1)
                            {
                                if (r < 4 && r >= 0 && i < 4)
                                {
                                    if (square[i][r] != 0 && piece[i1][j1] != 0)
                                    {
                                        //Array.Copy(copy, 0, sq, 0, sq.Length);
                                        for(int k = 0 ; k < 4 ; k++)
                                        {
                                            for(int l = 0 ; l < 4 ; l++)
                                            {
                                                copy[k][l] = square[k][l] ;
                                            }
                                        }
                                        res = false;
                                        return;
                                    }
                                    else if (square[i][r] == 0 && piece[i1][j1] != 0)
                                    {
                                        square[i][r] = piece[i1][j1];
                                    }
                                }
                                else
                                {
                                    //Array.Copy(copy, 0, sq, 0, sq.Length);
                                    for(int k = 0 ; k < 4 ; k++)
                                    {
                                        for(int l = 0 ; l < 4 ; l++)
                                        {
                                            copy[k][l] = square[k][l] ;
                                        }
                                    }
                                    res = false;
                                    return;
                                }
                                r++;
                            }
                        }
                        r = j;
                        i++;
                    }
                    res = true;
                    return ;
                }
            }
        }
        res=false;
        return ;
    }
}
   
     

/*
int x = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (square[i][j] == 0)
                {
                    int r = j;
                    int[][] copy = new int[4][4];
                    for(int k = 0 ; k < 4 ; k++)
                    {
                        for(int m = 0 ; m < 4 ; m++)
                        {
                            copy[k][m] = square[k][m] ;
                        }
                    }
                    for (int i1 = 0; i1 < piece.length; ++i1)
                    {
                        for (int j1 = 0; j1 < piece[0].length; ++j1)
                        {
                            if (piece[i1][j1] != 0 && x == 0)
                            {
                                j = j - j1;
                                x = 1;
                            }
                            if (x == 1)
                            {
                                if (r < 4 && r >= 0 && i < 4)
                                {
                                    if (square[i][r] != 0 && piece[i1][j1] != 0)
                                    {
                                        //Array.Copy(copy, 0, sq, 0, sq.Length);
                                        for(int k = 0 ; k < 4 ; k++)
                                        {
                                            for(int l = 0 ; l < 4 ; l++)
                                            {
                                                copy[k][l] = square[k][l] ;
                                            }
                                        }
                                        res = false;
                                        return;
                                    }
                                    else if (square[i][r] == 0 && piece[i1][j1] != 0)
                                    {
                                        square[i][r] = piece[i1][j1];
                                    }
                                }
                                else
                                {
                                    //Array.Copy(copy, 0, sq, 0, sq.Length);
                                    for(int k = 0 ; k < 4 ; k++)
                                    {
                                        for(int l = 0 ; l < 4 ; l++)
                                        {
                                            copy[k][l] = square[k][l] ;
                                        }
                                    }
                                    res = false;
                                    return;
                                }
                                r++;
                            }
                        }
                        r = j;
                        i++;
                    }
                    res = true;
                    return ;
                }
            }
        }
        res=false;
        return ;
*/





















/*r (int x =0;x <piece.length;x++)
          {
              for (int j=0;j<piece.length;j++)
                  System.out.print(" " + piece[x][j]);
                  System.out.println();
          }
*/

/*
private boolean res = false;
   private int di1;
   private int di2;
   
    int [][] square=new int[4][4];
   
     th1()
     {
         
     }
    @Override
    public void run() {
         //could logic
         this.res=true;
         System.out.println("hello " + res);
         int x = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (square[i][j] == 0)
                {
                    int r = j;
                    int[][] copy = new int[4][4];
                    for(int k = 0 ; k < 4 ; k++)
                    {
                        for(int m = 0 ; m < 4 ; m++)
                        {
                            copy[k][m] = square[k][m] ;
                        }
                    }
                    for (int i1 = 0; i1 < piece.length; ++i1)
                    {
                        for (int j1 = 0; j1 < piece[0].length; ++j1)
                        {
                            if (piece[i1][j1] != 0 && x == 0)
                            {
                                j = j - j1;
                                x = 1;
                            }
                            if (x == 1)
                            {
                                if (r < 4 && r >= 0 && i < 4)
                                {
                                    if (square[i][r] != 0 && piece[i1][j1] != 0)
                                    {
                                        //Array.Copy(copy, 0, sq, 0, sq.Length);
                                        for(int k = 0 ; k < 4 ; k++)
                                        {
                                            for(int l = 0 ; l < 4 ; l++)
                                            {
                                                copy[k][l] = square[k][l] ;
                                            }
                                        }
                                        res = false;
                                        return;
                                    }
                                    else if (square[i][r] == 0 && piece[i1][j1] != 0)
                                    {
                                        square[i][r] = piece[i1][j1];
                                    }
                                }
                                else
                                {
                                    //Array.Copy(copy, 0, sq, 0, sq.Length);
                                    for(int k = 0 ; k < 4 ; k++)
                                    {
                                        for(int l = 0 ; l < 4 ; l++)
                                        {
                                            copy[k][l] = square[k][l] ;
                                        }
                                    }
                                    res = false;
                                    return;
                                }
                                r++;
                            }
                        }
                        r = j;
                        i++;
                    }
                    res = true;
                    return ;
                }
            }
        }
        res=false;
        return ;
         
    }
   
    public boolean isRes() {
        return this.res;
    }

    
    
    public void setPiece(int[][]piece_org,int d1_org,int d2_org){
      this.di1=d1_org;
      this.di2=d2_org;
      int [][]piece ;
      this.piece.length=this.di1;
      this.piece[0].length = this.di2;
       for (int i = 0;i < di1; i++) {
                for (int j = 0; j < di2; j++) {
                  piece[i][j] = piece_org[i][j];
            }
    }

    
}
    

    public void setSquare(int[][] square) {
        for (int i = 0;i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                this.square[i][j] = square[i][j];
            }
        }
    }





*/