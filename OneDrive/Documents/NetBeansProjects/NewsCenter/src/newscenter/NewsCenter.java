package newscenter;

import com.google.gson.Gson;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class NewsCenter { //comment

    public static void main(String[] args) {
        
        System.out.println("\nTop article title: " + createEverythingFeed("trump", "", "", "en").getArticles()[0].getTitle());     
        System.out.println("\nTop article title: " + createTopFeed("", "us", "sports").getArticles()[0].getTitle());    
        
    }
    
    public static Feed createEverythingFeed(String keyword, String fromDate, String toDate, String language) { //Must have at least keyword
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://newsapi.org/v2/everything?q=" + keyword + "&from=" + fromDate + "&to=" + toDate + "&language=" + language + "&apiKey=9e53b5c3d7c04ca2ae8c897643ecdb2b");
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(result);
        Gson gson = new Gson();
        Feed feed = gson.fromJson(result, Feed.class);
        
        System.out.println(target.toString());
        
        
        
        return feed;
    }
    
    public static Feed createTopFeed(String keyword, String country, String category) { //Must have at least one param
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://newsapi.org/v2/top-headlines?country=" + country + "&category=" + category + "&q=" + keyword + "&apiKey=9e53b5c3d7c04ca2ae8c897643ecdb2b");
        String result = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(result);
        Gson gson = new Gson();
        Feed feed = gson.fromJson(result, Feed.class);
        
        System.out.println(target.toString());
        
        
        
        return feed;
    }  
    
    
    
    /*
        ^^ This code will output a JSON file with the 20 top healines in the US.        
        Google News API Key: 9e53b5c3d7c04ca2ae8c897643ecdb2b
        Documentation @ https://newsapi.org/docs/endpoints
        
        https://newsapi.org/v2/
                                top-headlines? OR everything? OR sources?
                                                                            conutry=... for country
                                                                            category=... for category
                                                                            sources=...,...,etc     NOTE: Can't be used with country/category
                                                                            q=... for keyword
                                                                                                                        &apiKey=9e53b5c3d7c04ca2ae8c897643ecdb2b
        Json file from the HTTPS request is stored in the String result. The json is then converted to Classes Feed, Articles, and Source.
        */
    
}