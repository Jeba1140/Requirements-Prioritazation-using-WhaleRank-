/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CBR;


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lenovo
 */
public class Fittness {
    
    ArrayList<Double> findfittness(ArrayList<ArrayList<Double>> initial,ArrayList<Integer> r1,ArrayList<Integer> r2,ArrayList<Double> r3,ArrayList<Double> r4,ArrayList<Integer> count)
    {
        ArrayList<Double> fit=new ArrayList<Double>();
        for(int i=0;i<initial.size();i++)
        {
            double dis=0.0;
            for(int j=0;j<r1.size();j++)
            {
                double d=r1.get(j)*initial.get(i).get(0)+r2.get(j)*initial.get(i).get(1)+r3.get(j)*initial.get(i).get(2)+r4.get(j)*initial.get(i).get(3);
           dis=dis+Math.pow((count.get(j)-d),2.0);
            }
           fit.add(dis/(double)r1.size());
        }
        
       
      return fit;  
    }
}
