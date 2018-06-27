/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Metrix {
    
    void findmetrix(ArrayList<Double> feature,ArrayList<Integer> count,ArrayList<Integer> r1,ArrayList<Integer> r2,ArrayList<Double> r3,ArrayList<Double> r4)
    {
       ArrayList<Double> res=new ArrayList<Double>();
       ArrayList<Double> res1=new ArrayList<Double>();
       for(int i=0;i<count.size();i++)
       {
         double d1=r1.get(i)*feature.get(0)+r2.get(i)*feature.get(1)+r3.get(i)*feature.get(2)+r4.get(i)*feature.get(3);
           double d=r4.get(i)*feature.get(3);
       res1.add(d);
       res.add(d1);
       }
       
       int c=0;
       for(int i=0;i<count.size();i++)
       {
           for(int j=0;j<count.size();j++)
           {
               if((count.get(i)>=count.get(j) && res.get(i)<res.get(j)) || (count.get(i)<count.get(j) && res.get(i)>=res.get(j)) )
                   c++;
           }
       }
          
       Run.nda.add((double)c/(double)(count.size()*count.size()));
   
    int c1=0;
    for(int i=0;i<count.size();i++)
    {
        if(Math.abs(res1.get(i)-count.get(i))<0.1)
        c1++;
    }
    Run.acc.add((double)c1/(double)count.size());

    
//    for(int i=0;i<res.size();i++)
//        System.out.println(res.get(i)+"  "+count.get(i));
    
    
    }
}
