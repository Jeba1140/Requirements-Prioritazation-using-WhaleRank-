 package Avg;



import java.util.*;

public class Avg {
    public static int iteration=0,it=1;
      public static double bf=0.0;
  //  public static ArrayList<Double> bestresult=new ArrayList<Double>();
  

    public static ArrayList<Double> fitt=new ArrayList<Double>();
   

  public static  ArrayList<Double> callmain(ArrayList<Integer> r1,ArrayList<Integer> r2,ArrayList<Double> r3,ArrayList<Double> r4,ArrayList<Integer> count)
    {
    iteration=50;
        ArrayList<ArrayList<Double>> X=new ArrayList<ArrayList<Double>>();
        Avg woa=new Avg();

  
      
      
        Random r=new Random();
         for(int i=0;i<code.GUI.nop;i++)
        {
          ArrayList<Double> tm=new ArrayList<Double>();
            for(int k=0;k<3;k++)
            {
         
         
          tm.add( r.nextDouble());
            }
            tm.add(r.nextInt(10)+r.nextDouble());
            X.add(tm);
               

         
        }
        System.out.println ("initial");
        for(int i=0;i<X.size();i++)
        System.out.println(X.get(i)+"  "+X.get(i).size());
       
       
  

  Fittness ft=new Fittness();
  fitt=ft.findfittness(X, r1, r2, r3,r4, count);
  System.out.println(fitt+"  fit");
//  
int p=fitt.indexOf(Collections.min(fitt));

     while(it<iteration)
        {
           
            woa.updation(X);
            
            
            fitt=new ArrayList<Double>();
   
           
           fitt=ft.findfittness(X, r1, r2, r3, r4, count);
           it++;
   
        }
   
    // code.Run.presult.add(bestresult);
int po=fitt.indexOf(Collections.min(fitt));

System.out.println(X.get(po));
return X.get(po);
    }
    
  void updation(ArrayList<ArrayList<Double>> X)
  {
      Random r=new Random();
      for(int i=0;i<X.size();i++)
      {
          
          ArrayList<Double> t=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size();j++)
          {
              double d=0.0;
             for(int k=0;k<X.size();k++)
             {
                if(k!=i) 
                {
                    d=d+X.get(k).get(j);
                }
             }
            
              t.add(d/(double)(X.size()-1));
             
          }
           if(t.get(3)<8.0)
                {
                    t.remove(3);;
                    t.add((9.5));
                }
             
          X.remove(i);
          X.add(i,t);
          
      }
      
  }
    
    
    
}
