/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palace.el.finder;


import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

/**
 *
 * @author tarun
 */
public class PalaceEL {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        Response doc = Jsoup.connect("https://palace-skateboards.myshopify.com/collections/frontpage.oembed")
                .ignoreContentType(true)
                .execute();
        JSONObject productOembed = new JSONObject(doc.body());
        JSONArray products = productOembed.getJSONArray("products");
        for(int i = 0; i < products.length(); i++){
            String productName = products.getJSONObject(i).getString("title");
            String productLink = "https://shop-usa.palaceskateboards.com/products/"+products.getJSONObject(i).getString("product_id");
            System.out.println(productName +"\n\r"+productLink+"\r\n\r\n");
            
        }
        System.out.println("Found "+products.length() + " products");

    }
    
    

}
