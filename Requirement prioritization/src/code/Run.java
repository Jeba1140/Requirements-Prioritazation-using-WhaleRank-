/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Run {
    public static ArrayList<Double> nda=new ArrayList<Double>();
    public static ArrayList<Double> acc=new ArrayList<Double>();
    public static void main(String args[])
    {
        Run r=new Run();
        ArrayList<String> name=new ArrayList<String>();
        ArrayList<Integer> count=new ArrayList<Integer>();
        r.readhandtrace(name,count);
         System.out.println(name);
           System.out.println(count);
           ArrayList<String> content=new ArrayList<String>();
        r.readinput(name,content);
        ArrayList<String> dict=new ArrayList<String>();
        r.formdictionarywords(content, dict);
        System.out.println(dict);
        Feature_calculation fc=new Feature_calculation();
        fc.featurecalculation(content, dict, count);
        System.out.println(nda+"\n"+acc);
        for(int i=0;i<nda.size();i++)
        {
            GUI.jTable1.setValueAt(nda.get(i), 0, i+1);
            GUI.jTable1.setValueAt(acc.get(i), 1, i+1);
        }
        
    }
    
    void formdictionarywords(ArrayList<String> content,ArrayList<String> dict)
    {
        try
        {
            ArrayList<String> sp=new ArrayList<String>();
            BufferedReader br=new BufferedReader(new FileReader("stopwords.txt"));
            String s="";
            while((s=br.readLine())!=null)
            {
              sp.add(s.trim().toLowerCase());  
            }
        
           
        for(int i=0;i<content.size();i++)
        {
            String a[]=content.get(i).split(" ");
            for(int j=0;j<a.length;j++)
            {
                if(!dict.contains(a[j]) && !sp.contains(a[j]))
                    dict.add(a[j]);
            }  
        }
        }catch(Exception e){}
    }
    
    void readinput(ArrayList<String> name,ArrayList<String> content)
    {
        
        try
        {
           // System.out.println(name.get(0));
           for(int i=0;i<name.size();i++)
           {
           BufferedReader br=new BufferedReader(new FileReader("high\\"+name.get(i).trim()));
          
            String s="";
        
            while((s=br.readLine())!=null)
            {
        
                s=s.replace(".", "").toLowerCase();
                s=s.replace(",", "");
                    s=s.replace("/", " ");
                  System.out.println(i+" "+s);
              content.add(s.trim());
            
            }
           }
            
        }catch(Exception e){
        System.out.println(e);
        }
    }
    void readhandtrace(ArrayList<String> name,ArrayList<Integer> count)
    {
        try
        {
         
            int n=(new File("high").listFiles().length/100)*GUI.tr;
            BufferedReader br=new BufferedReader(new FileReader("handtrace.txt"));
            String s="";
            br.readLine();
            int i=0;
            while((s=br.readLine())!=null && count.size()<=n)
            {
                i++;
                String a[]=s.trim().split("  ");
              //  System.out.println(s+" "+i+" "+a.length);
                name.add(a[0]);
                count.add(a.length-1);
            br.readLine();
            
            }
          
            
        }catch(Exception e){}
    }
}
