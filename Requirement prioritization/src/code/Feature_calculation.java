/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class Feature_calculation {
    
    void featurecalculation(ArrayList<String> content,ArrayList<String> dict,ArrayList<Integer> count)
    {
        
        ArrayList<Integer> r1=new ArrayList<Integer>();
        for(int i=0;i<content.size();i++)
        {
            String a[]=content.get(i).split(" ");
            int c=0;
            for(int j=0;j<a.length;j++)
            {
                if(dict.contains(a[j]))
                    c++;
                    
            }
            r1.add(c);
        }
        
       ArrayList<Integer> r2=new ArrayList<Integer>();
       int coun[][]=new int[content.size()][content.size()];
        
       for(int i=0;i<content.size()-1;i++)
       {
           for(int j=(i+1);j<content.size();j++)
           {
               String a[]=content.get(i).split(" ");
               int c=0;
               for(int k=0;k<a.length;k++)
               {
                   if(content.get(j).contains(a[k]))
                       c++;
               }
               coun[i][j]=c;
               coun[j][i]=c;
           }
       }
       
       for(int i=0;i<coun.length;i++)
       {
           int c=0;
           for(int j=0;j<coun[i].length;j++)
           {
               c=c+coun[i][j];
           }
           r2.add(c/coun.length);
       }
       System.out.println("r1: "+r1);
       System.out.println("r2: "+r2);
           ArrayList<Integer> mp=new ArrayList<Integer>();
           Random r=new Random();
           
           for(int i=0;i<content.size();i++)
           {
              mp.add(r.nextInt(3)+1);
           }
           ArrayList<Double> r3=new ArrayList<Double>();
           for(int i=0;i<mp.size();i++)
           {
               r3.add((double)mp.get(i)/(double)3);
           }
           System.out.println(r3);
           ArrayList<Double> r4=new ArrayList<Double>();
           for(int i=0;i<count.size();i++)
           {
               r4.add((double)count.get(i)/(double)Collections.max(count));
           }
           Metrix m=new Metrix();
        System.out.println(r4);
ArrayList<Double> best4=Avg.Avg.callmain(r1, r2, r3, r4, count);
m.findmetrix(best4, count, r1, r2, r3, r4);
ArrayList<Double> best3=GA.GA.callmain(r1, r2, r3, r4, count);
m.findmetrix(best3, count, r1, r2, r3, r4);
ArrayList<Double> best2=CBR.Cbr.callmain(r1, r2, r3, r4, count);
m.findmetrix(best2, count, r1, r2, r3, r4);

ArrayList<Double> best1=WOA.Woa.callmain(r1, r2, r3, r4, count);


m.findmetrix(best1, count, r1, r2, r3, r4);

System.out.println(best4);
System.out.println(best3);
System.out.println(best2);
System.out.println(best1);

    }

    
    
}
