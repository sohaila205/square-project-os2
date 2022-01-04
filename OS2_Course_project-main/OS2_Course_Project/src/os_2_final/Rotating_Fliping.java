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
public class Rotating_Fliping {
    
    public static int [][] flip(int [][] origin) {
         //first we create an array with same origin demensions
      int [][]result = new int [origin.length][origin[0].length];
       //now we want to convert a column in origin to row in result but rotate for right
       for (int d1=0;d1<origin.length ;d1++)
       {
           int t_d =( origin[0].length )- 1; //to make sure i flip horizontal
           for (int d2=0;d2<origin[0].length;d2++)
           {
               result[d1][t_d] = origin [d1][d2];
               t_d-=1;
           }
       }
       
     return result;
    }
    
    
    public static int[][] rotate (int [][] origin)
    {
        //first we will create a result array with reversed origin demensions
        int [][] result = new int [origin[0].length][origin.length] ;
        for (int i = 0; i < result[0].length; i++)
        {
    for (int j = 0; j < result.length; j++)
    {
        // turn matrix 90º clockwise ⟳
        result[j][result[0].length - 1 - i] = origin[i][j]; 
    }
        }
        return result;
    }
    
}
