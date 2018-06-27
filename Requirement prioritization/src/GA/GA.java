 package GA;


import java.util.*;

public class GA {
    public static int iteration=0,it=1;
      public static double bf=0.0;
  //  public static ArrayList<Double> bestresult=new ArrayList<Double>();
  

    public static ArrayList<Double> fitt=new ArrayList<Double>();
   

  public static  ArrayList<Double> callmain(ArrayList<Integer> r1,ArrayList<Integer> r2,ArrayList<Double> r3,ArrayList<Double> r4,ArrayList<Integer> count)
    {
    iteration=50;
        ArrayList<ArrayList<Double>> X=new ArrayList<ArrayList<Double>>();
        GA ga=new GA();

  
      
      
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
  ga.crossovermutation(X);
       
  

  Fittness ft=new Fittness();
  fitt=ft.findfittness(X, r1, r2, r3,r4, count);
  
  System.out.println(fitt+"  fit");


     while(it<iteration)
        {
           
            ga.updation(X,fitt);
            
            
            fitt=new ArrayList<Double>();
   
           ga.crossovermutation(X);
           fitt=ft.findfittness(X, r1, r2, r3, r4, count);
           it++;
   
        }
   
  System.out.println(fitt.size()+"  "+fitt);
int po=fitt.indexOf(Collections.min(fitt));

System.out.println(X.get(po));
return X.get(po);
    }
  
  void crossovermutation(ArrayList<ArrayList<Double>> X)
  {
      int n=X.size();
      for(int i=0;i<n;i=i+2)
      {
          ArrayList<Double> t1=new ArrayList<Double>();
          ArrayList<Double> t2=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size()/2;j++)
          {
              t1.add(X.get(i).get(j));
              t2.add(X.get(i+1).get(j));
          }
          for(int j=X.get(i).size()/2;j<X.get(i).size();j++)
          {
              t2.add(X.get(i).get(j));
              t1.add(X.get(i+1).get(j));
          }
          X.add(t1);
          X.add(t2);
      }
      Random r=new Random();
      for(int i=0;i<n;i++)
      {
          ArrayList<Double> t=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size();j++)
          {
              t.add(X.get(i).get(j));
          }
         double re=r.nextDouble();
         t.remove(2);
         t.add(2,re);
         X.add(t);
      }
              
  }
  
  
  void updation(ArrayList<ArrayList<Double>> X,ArrayList<Double> fit)
  {
     int n=fit.size()/3;
     System.out.println(n+"  nu");
     while(fit.size()>n)
     {
         int p=fit.indexOf(Collections.max(fit));
         fit.remove(p);
         X.remove(p);
     }
         
     for(int i=0;i<X.size();i++)
     {
         ArrayList<Double> t=new ArrayList<Double>();
         for(int j=0;j<X.get(i).size();j++)
             t.add(X.get(i).get(j));
         
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
