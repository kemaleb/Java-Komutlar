//JsoupUsage.java (Main)



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.broadcast;        

     
     
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Kemal
 */
public class JsoupUsage {
    public static void main(String[] args){
        int a=06;
        
        
        
        List<Broadcast> broadcastList = new ArrayList<> ();
        try
        {
            Document document = Jsoup.connect("https://www.kanald.com.tr/yayin-akisi").get();
            Elements broadcasts = document.select("#day-060818");//burada gireceğimiz günü belirten divin ismini yazdık.
            
                for (Element element : broadcasts) {
                     
                Broadcast broadcast = new Broadcast();    
                broadcast.setTime(element.getElementsByClass("time").text()+"\n");
                broadcast.setTitle(element.getElementsByClass("title").text()+"\n");
                broadcast.setImageUrl(element.getElementsByTag("img").attr("data-src")+"\n");
                broadcast.setTag(element.getElementsByClass("tag").text()+"\n");
                    
                broadcastList.add(broadcast);
            }
                
                for (Broadcast broadcast :broadcastList) {
                System.out.println("Saatler-"+broadcast.getTime()+"\n");
                System.out.println("Programlar-"+broadcast.getTitle()+"\n");
                System.out.println("Resim-"+broadcast.getImageUrl()+"\n");
                System.out.println("Etiket-"+broadcast.getTag()+"\n");
                    
            }
        }
        catch(Exception e)
                {
                e.printStackTrace();
                }
            
        }
            
    }
     

