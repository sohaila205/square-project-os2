/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_2_final;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class OS_2_FINAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ////sample1 
        int [][] s1_piece1 = { {1,1,1} , {1,0,1} };
        int [][] s1_piece2 = { {0,2} , {0,2},{2,2},{0,2} };
        int [][] s1_piece3 = { {3} , {3} };
        int [][] s1_piece4 = { {4,0},{4,0},{4,4} };
        ////sample 2
        int [][] s2_piece1 = {{1,1,1,1}};
        int [][] s2_piece2 = {{2,2,2,2}};
        int [][] s2_piece3 = {{3,3,3,3}};
        int [][] s2_piece4 = {{4,4,4,4}};
        ////sample 3
        int [][] s3_piece1 = { {1,1},{1,1}};
        int [][] s3_piece2 = { {2,2},{2,2}};
        int [][] s3_piece3 = { {3,3},{3,3}};
        int [][] s3_piece4 = { {4,4},{4,4}};
        ///sample 4 worng sample
        int [][] s4_piece1 = {{1,1,1,1,1,1}};
        int [][] s4_piece2 = {{2,2,2,2}};
        int [][] s4_piece3 = {{3,3,3,3}};
        int [][] s4_piece4 = {{4,4,4,4}};
        //sample 5 wrong sample
        int [][] s5_piece1 = {{1,0,1,1}};
        int [][] s5_piece2 = {{2,0,2,0}};
        int [][] s5_piece3 = {{3,0,0,3}};
        int [][] s5_piece4 = {{4,4,0,4}};

        
        int[][] square = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0, }, { 0, 0, 0, 0 } };
        List<int[][]> pieces = new ArrayList<int[][]>();
        
        
        boolean test =false;
        int count=0;
        Scanner input= new Scanner(System.in);
        
        System.out.print("Choose a sample : ");
        
        int sample = input.nextInt();
        
        switch (sample )
        {
            case 1:
            {
                pieces.add(s1_piece1); pieces.add(s1_piece2); pieces.add(s1_piece3); pieces.add(s1_piece4);
                for(int i=0;i<pieces.size();i++)
        {
            for (int x =0 ;x<pieces.get(i).length;x++)
            {
                for (int y=0;y<pieces.get(i)[0].length;y++)
                {
                    if(pieces.get(i)[x][y] != 0)
                        count++;
                }
            }
        }
         if (count!=16)
         {
             System.out.println("No Solution..");
             return;
         }
               
        for (int i=0;i<pieces.size();i++)
        {
          if (pieces.get(i).length>4 ||pieces.get(i)[0].length>4 )
          { 
          System.out.println("No Solution..");
          return;
          }
          
          for (int _try_ =1 ;_try_<=2;_try_++)
          {
                      //get all posibble shapes
                      int [][] p_sh1 = new int [pieces.get(i).length ][ pieces.get(i)[0].length] ;
                      System.arraycopy(pieces.get(i), 0, p_sh1, 0, p_sh1.length);
                      int [][] p_sh2 = Rotating_Fliping.rotate(p_sh1);
                      int [][] p_sh3 = Rotating_Fliping.rotate(p_sh2);
                      int [][] p_sh4 = Rotating_Fliping.rotate(p_sh3);
                      int[][] squareCopy = new int[4][4];
                      System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      //start trying
                      //first shape trying
                      th1 ob1 = new th1();
                      ob1.setPiece(p_sh1);
                      ob1.setSquare(squareCopy);
                      Thread t1= new Thread(ob1);  
                      t1.start(); 
                      t1.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, square.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 1st try
                      
                      //second shape trying
                      th1 ob2 =  new th1();
                      ob2.setPiece(p_sh2);
                      ob2.setSquare(squareCopy);
                      Thread t2= new Thread(ob2);  
                      t2.start(); 
                      t2.join();
                      test=ob2.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                          
                          break;
                      }
                      //END 1st try
                      
                      //third shape trying
                      th1 ob3 = new th1();
                      ob3.setPiece(p_sh3);
                      ob3.setSquare(squareCopy);
                      Thread t3= new Thread(ob3);  
                      t3.start(); 
                      t3.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                  
                          break;
                      }
                      //END 1st try
                      
                      //first shape trying
                      th1 ob4 = new th1();
                      ob4.setPiece(p_sh4);
                      ob4.setSquare(squareCopy);
                      Thread t4= new Thread(ob4);  
                      t4.start(); 
                      t4.join();
                      test=ob4.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 4st try
                      //////////////////END all times/////////////
                      Rotating_Fliping.flip(pieces.get(i));
             }
          
          
        }
                       for (int x =0;x <square.length;x++)
                            {
                             for (int j=0;j<square[0].length;j++)
                                System.out.print(" " + square[x][j]);
                              System.out.println();
                            }      
                       
                
            }
            //end of case one//
            
            case 2:
            {
            pieces.add(s2_piece1); pieces.add(s2_piece2); pieces.add(s2_piece3); pieces.add(s2_piece4);
                for(int i=0;i<pieces.size();i++)
             {
            for (int x =0 ;x<pieces.get(i).length;x++)
            {
                for (int y=0;y<pieces.get(i)[0].length;y++)
                {
                    if(pieces.get(i)[x][y] != 0)
                        count++;
                }
            }
        }
         if (count!=16)
         {
             System.out.println("No Solution..");
             return;
         }
               
        for (int i=0;i<pieces.size();i++)
        {
          if (pieces.get(i).length>4 ||pieces.get(i)[0].length>4 )
          { 
          System.out.println("No Solution..");
          return;
          }
          
          for (int _try_ =1 ;_try_<=2;_try_++)
          {
                      //get all posibble shapes
                      int [][] p_sh1 = new int [pieces.get(i).length ][ pieces.get(i)[0].length] ;
                      System.arraycopy(pieces.get(i), 0, p_sh1, 0, p_sh1.length);
                      int [][] p_sh2 = Rotating_Fliping.rotate(p_sh1);
                      int [][] p_sh3 = Rotating_Fliping.rotate(p_sh2);
                      int [][] p_sh4 = Rotating_Fliping.rotate(p_sh3);
                      int[][] squareCopy = new int[4][4];
                      System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      //start trying
                      //first shape trying
                      th1 ob1 = new th1();
                      ob1.setPiece(p_sh1);
                      ob1.setSquare(squareCopy);
                      Thread t1= new Thread(ob1);  
                      t1.start(); 
                      t1.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, square.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 1st try
                      
                      //second shape trying
                      th1 ob2 =  new th1();
                      ob2.setPiece(p_sh2);
                      ob2.setSquare(squareCopy);
                      Thread t2= new Thread(ob2);  
                      t2.start(); 
                      t2.join();
                      test=ob2.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                          
                          break;
                      }
                      //END 1st try
                      
                      //third shape trying
                      th1 ob3 = new th1();
                      ob3.setPiece(p_sh3);
                      ob3.setSquare(squareCopy);
                      Thread t3= new Thread(ob3);  
                      t3.start(); 
                      t3.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                  
                          break;
                      }
                      //END 1st try
                      
                      //first shape trying
                      th1 ob4 = new th1();
                      ob4.setPiece(p_sh4);
                      ob4.setSquare(squareCopy);
                      Thread t4= new Thread(ob4);  
                      t4.start(); 
                      t4.join();
                      test=ob4.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 4st try
                      //////////////////END all times/////////////
                      Rotating_Fliping.flip(pieces.get(i));
             }
          
          
        }
                       for (int x =0;x <square.length;x++)
                            {
                             for (int j=0;j<square[0].length;j++)
                                System.out.print(" " + square[x][j]);
                              System.out.println();
                            }    
            }
            ///end of case 2//
            case 3 :
            {
            pieces.add(s3_piece1); pieces.add(s3_piece2); pieces.add(s3_piece3); pieces.add(s3_piece4);
                for(int i=0;i<pieces.size();i++)
               {
            for (int x =0 ;x<pieces.get(i).length;x++)
            {
                for (int y=0;y<pieces.get(i)[0].length;y++)
                {
                    if(pieces.get(i)[x][y] != 0)
                        count++;
                }
            }
        }
         if (count!=16)
         {
             System.out.println("No Solution..");
             return;
         }
               
        for (int i=0;i<pieces.size();i++)
        {
          if (pieces.get(i).length>4 ||pieces.get(i)[0].length>4 )
          { 
          System.out.println("No Solution..");
          return;
          }
          
          for (int _try_ =1 ;_try_<=2;_try_++)
          {
                      //get all posibble shapes
                      int [][] p_sh1 = new int [pieces.get(i).length ][ pieces.get(i)[0].length] ;
                      System.arraycopy(pieces.get(i), 0, p_sh1, 0, p_sh1.length);
                      int [][] p_sh2 = Rotating_Fliping.rotate(p_sh1);
                      int [][] p_sh3 = Rotating_Fliping.rotate(p_sh2);
                      int [][] p_sh4 = Rotating_Fliping.rotate(p_sh3);
                      int[][] squareCopy = new int[4][4];
                      System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      //start trying
                      //first shape trying
                      th1 ob1 = new th1();
                      ob1.setPiece(p_sh1);
                      ob1.setSquare(squareCopy);
                      Thread t1= new Thread(ob1);  
                      t1.start(); 
                      t1.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, square.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 1st try
                      
                      //second shape trying
                      th1 ob2 =  new th1();
                      ob2.setPiece(p_sh2);
                      ob2.setSquare(squareCopy);
                      Thread t2= new Thread(ob2);  
                      t2.start(); 
                      t2.join();
                      test=ob2.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                          
                          break;
                      }
                      //END 1st try
                      
                      //third shape trying
                      th1 ob3 = new th1();
                      ob3.setPiece(p_sh3);
                      ob3.setSquare(squareCopy);
                      Thread t3= new Thread(ob3);  
                      t3.start(); 
                      t3.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                  
                          break;
                      }
                      //END 1st try
                      
                      //first shape trying
                      th1 ob4 = new th1();
                      ob4.setPiece(p_sh4);
                      ob4.setSquare(squareCopy);
                      Thread t4= new Thread(ob4);  
                      t4.start(); 
                      t4.join();
                      test=ob4.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 4st try
                      //////////////////END all times/////////////
                      Rotating_Fliping.flip(pieces.get(i));
             }
          
          
        }
                       for (int x =0;x <square.length;x++)
                            {
                             for (int j=0;j<square[0].length;j++)
                                System.out.print(" " + square[x][j]);
                              System.out.println();
                            } 
                       
            }
            //end of case 3////
            case 4:
            {
            pieces.add(s4_piece1); pieces.add(s4_piece2); pieces.add(s4_piece3); pieces.add(s4_piece4);
                for(int i=0;i<pieces.size();i++)
               {
            for (int x =0 ;x<pieces.get(i).length;x++)
            {
                for (int y=0;y<pieces.get(i)[0].length;y++)
                {
                    if(pieces.get(i)[x][y] != 0)
                        count++;
                }
            }
               }
         if (count!=16)
         {
             System.out.println("No Solution..");
             return;
         }
               
        for (int i=0;i<pieces.size();i++)
        {
          if (pieces.get(i).length>4 ||pieces.get(i)[0].length>4 )
          { 
          System.out.println("No Solution..");
          return;
          }
          
          for (int _try_ =1 ;_try_<=2;_try_++)
          {
                      //get all posibble shapes
                      int [][] p_sh1 = new int [pieces.get(i).length ][ pieces.get(i)[0].length] ;
                      System.arraycopy(pieces.get(i), 0, p_sh1, 0, p_sh1.length);
                      int [][] p_sh2 = Rotating_Fliping.rotate(p_sh1);
                      int [][] p_sh3 = Rotating_Fliping.rotate(p_sh2);
                      int [][] p_sh4 = Rotating_Fliping.rotate(p_sh3);
                      int[][] squareCopy = new int[4][4];
                      System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      //start trying
                      //first shape trying
                      th1 ob1 = new th1();
                      ob1.setPiece(p_sh1);
                      ob1.setSquare(squareCopy);
                      Thread t1= new Thread(ob1);  
                      t1.start(); 
                      t1.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, square.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 1st try
                      
                      //second shape trying
                      th1 ob2 =  new th1();
                      ob2.setPiece(p_sh2);
                      ob2.setSquare(squareCopy);
                      Thread t2= new Thread(ob2);  
                      t2.start(); 
                      t2.join();
                      test=ob2.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                          
                          break;
                      }
                      //END 1st try
                      
                      //third shape trying
                      th1 ob3 = new th1();
                      ob3.setPiece(p_sh3);
                      ob3.setSquare(squareCopy);
                      Thread t3= new Thread(ob3);  
                      t3.start(); 
                      t3.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                  
                          break;
                      }
                      //END 1st try
                      
                      //first shape trying
                      th1 ob4 = new th1();
                      ob4.setPiece(p_sh4);
                      ob4.setSquare(squareCopy);
                      Thread t4= new Thread(ob4);  
                      t4.start(); 
                      t4.join();
                      test=ob4.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 4st try
                      //////////////////END all times/////////////
                      Rotating_Fliping.flip(pieces.get(i));
             }
          
          
        }
                       for (int x =0;x <square.length;x++)
                            {
                             for (int j=0;j<square[0].length;j++)
                                System.out.print(" " + square[x][j]);
                              System.out.println();
                            }  
                       
                  }
            case 5:
            {
              pieces.add(s5_piece1); pieces.add(s5_piece2); pieces.add(s5_piece3); pieces.add(s5_piece4);
                for(int i=0;i<pieces.size();i++)
                {
            for (int x =0 ;x<pieces.get(i).length;x++)
            {
                for (int y=0;y<pieces.get(i)[0].length;y++)
                {
                    if(pieces.get(i)[x][y] != 0)
                        count++;
                }
            }
        }
         if (count!=16)
         {
             System.out.println("No Solution..");
             return;
         }
               
        for (int i=0;i<pieces.size();i++)
        {
          if (pieces.get(i).length>4 ||pieces.get(i)[0].length>4 )
          { 
          System.out.println("No Solution..");
          return;
          }
          
          for (int _try_ =1 ;_try_<=2;_try_++)
          {
                      //get all posibble shapes
                      int [][] p_sh1 = new int [pieces.get(i).length ][ pieces.get(i)[0].length] ;
                      System.arraycopy(pieces.get(i), 0, p_sh1, 0, p_sh1.length);
                      int [][] p_sh2 = Rotating_Fliping.rotate(p_sh1);
                      int [][] p_sh3 = Rotating_Fliping.rotate(p_sh2);
                      int [][] p_sh4 = Rotating_Fliping.rotate(p_sh3);
                      int[][] squareCopy = new int[4][4];
                      System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      //start trying
                      //first shape trying
                      th1 ob1 = new th1();
                      ob1.setPiece(p_sh1);
                      ob1.setSquare(squareCopy);
                      Thread t1= new Thread(ob1);  
                      t1.start(); 
                      t1.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, square.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 1st try
                      
                      //second shape trying
                      th1 ob2 =  new th1();
                      ob2.setPiece(p_sh2);
                      ob2.setSquare(squareCopy);
                      Thread t2= new Thread(ob2);  
                      t2.start(); 
                      t2.join();
                      test=ob2.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                          
                          break;
                      }
                      //END 1st try
                      
                      //third shape trying
                      th1 ob3 = new th1();
                      ob3.setPiece(p_sh3);
                      ob3.setSquare(squareCopy);
                      Thread t3= new Thread(ob3);  
                      t3.start(); 
                      t3.join();
                      test=ob1.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                  
                          break;
                      }
                      //END 1st try
                      
                      //first shape trying
                      th1 ob4 = new th1();
                      ob4.setPiece(p_sh4);
                      ob4.setSquare(squareCopy);
                      Thread t4= new Thread(ob4);  
                      t4.start(); 
                      t4.join();
                      test=ob4.isRes();
                      if(test == false )
                      {
                          System.arraycopy(square, 0, squareCopy, 0, squareCopy.length);
                      }
                      else 
                      {
                          System.arraycopy(squareCopy ,0,square,0,square.length);
                         
                          break;
                      }
                      //END 4st try
                      //////////////////END all times/////////////
                      Rotating_Fliping.flip(pieces.get(i));
             }
          
          
        }
                       for (int x =0;x <square.length;x++)
                            {
                             for (int j=0;j<square[0].length;j++)
                                System.out.print(" " + square[x][j]);
                              System.out.println();
                            }    
            }
                
                
        }
        
        
        
        
        
        
                       
          
    }
    
}
