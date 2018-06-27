 package WOA;

import java.util.*;

public class Woa {
    public static int iteration=0,it=1;
      public static double bf=0.0;
   public static ArrayList<Double> bestresult=new ArrayList<Double>();
  

    public static ArrayList<Double> fitt=new ArrayList<Double>();
       
    public static ArrayList<Double> A=new ArrayList<Double>();
    public static ArrayList<Double> C=new ArrayList<Double>();

  public static  ArrayList<Double> callmain(ArrayList<Integer> r1,ArrayList<Integer> r2,ArrayList<Double> r3,ArrayList<Double> r4,ArrayList<Integer> count)
    {
    iteration=50;
        ArrayList<ArrayList<Double>> X=new ArrayList<ArrayList<Double>>();
        Woa woa=new Woa();

  
      
      
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
       
       
        ArrayList<Double> av=new ArrayList<Double>();
        ArrayList<Double> rv=new ArrayList<Double>();
        av.add(2.0);
        for(int i=1;i<X.get(0).size()-1;i++)
        {
                av.add(av.get(i-1)-(r.nextDouble()/(double)10));
        }
        av.add(0.0);
        
        for(int i=0;i<X.get(0).size();i++)
            rv.add(r.nextDouble());
        for(int i=0;i<av.size();i++)
        {
            A.add((2*av.get(i)*rv.get(i))-av.get(i));
            C.add(2*rv.get(i));
        }
            

  Fittness ft=new Fittness();
  fitt=ft.findfittness(X, r1, r2, r3,r4, count);
  System.out.println(fitt+"  fit");
//  
int p=fitt.indexOf(Collections.min(fitt));

double lv=0.0,pv=0.0,aval=0.0;
for(int i=0;i<A.size();i++)
    aval=aval+A.get(i);
aval=aval/(double)(A.size());
pv=r.nextDouble();
lv=r.nextDouble();
if(pv<0.5)
{
    if(aval<lv)
    {
        woa.updation1(X.get(p),X);
    }
    if(aval>=lv)
        woa.updation2(X.get(p), X);
}
else
    woa.updation3(X.get(p), X);

     while(it<iteration)
        {
            fitt=new ArrayList<Double>();
   
           
           fitt=ft.findfittness(X, r1, r2, r3, r4, count);
           
         
            it++;
            
            System.out.println("iteration "+it+"  fitness  "+fitt);
            
            
            p=fitt.indexOf(Collections.min(fitt));
 lv=0.0;pv=0.0;aval=0.0;
for(int i=0;i<A.size();i++)
    aval=aval+A.get(i);
aval=aval/(double)(A.size());
pv=r.nextDouble();
lv=r.nextDouble();
if(pv<0.5)
{
    if(aval<lv)
    {
        woa.updation1(X.get(p),X);
    }
    if(aval>=lv)
        woa.updation2(X.get(p), X);
}
else
    woa.updation3(X.get(p), X);
;  


for(int k=0;k<X.size();k++)
    System.out.println(X.get(k).size()+" xk "+it);
        }
   
    // code.Run.presult.add(bestresult);
int po=fitt.indexOf(Collections.min(fitt));

System.out.println(X.get(po)+"  be");


return X.get(po);
    }
    
  void updation1(ArrayList<Double> best,ArrayList<ArrayList<Double>> X)
  {
      for(int i=0;i<X.size();i++)
      {
          
          ArrayList<Double> t=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size();j++)
          {
              double d=Math.abs(best.get(j)-X.get(i).get(j));
              double v=(best.get(j)-(A.get(j)*d));
            if(j==3)
            {
                if(v>8.0)
                    t.add(v);
                else
                    t.add((9.5));
            }else
              t.add(v);
             
          }
        
          X.remove(i);
          X.add(i,t);
          
      }
      
  }
    
     void updation2(ArrayList<Double> best,ArrayList<ArrayList<Double>> X)
  {
      Random r=new Random();
      for(int i=0;i<X.size();i++)
      {
          
          ArrayList<Double> t=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size();j++)
          { double d=Math.abs(best.get(j)-X.get(i).get(j)); 
              double ep=Math.exp(0.5*r.nextDouble());
              double cosv=Math.cos(2*3.14*r.nextDouble());
              double v=(d*ep*cosv+best.get(j));
             
              if(j==3)
            {
                if(v>8.0)
                    t.add(v);
                else
                    t.add((9.5));
            }else
              t.add(v);
             
            
          }
         
          X.remove(i);
          X.add(i,t);
          
      }
      
  }
       void updation3(ArrayList<Double> best,ArrayList<ArrayList<Double>> X)
  {
      Random r=new Random();
      for(int i=0;i<X.size();i++)
      {
           ArrayList<Double> t1=new ArrayList<Double>();
           for(int j=0;j<X.get(i).size();j++)
               t1.add(X.get(i).get(j));
       //    Collections.shuffle(t1);
          
          ArrayList<Double> t=new ArrayList<Double>();
          for(int j=0;j<X.get(i).size();j++)
          {
             double d=Math.abs(best.get(j)-X.get(i).get(j));
            
              double v=(t1.get(j)-(A.get(j)*d));
           
              if(j==3)
            {
                if(v>8.0)
                    t.add(v);
                else
                    t.add((9.5));
            }else
              t.add(v);
             
            
                      
          }
         
          X.remove(i);
          X.add(i,t);
          
      }
      
  }
    
}
