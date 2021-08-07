package consumer.api.github;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pojo.Repository;
import pojo.Root;

public class TrendingRepositoriesConsumer {

	private String URL;
	private Date date;
	
	public TrendingRepositoriesConsumer(Date date) {
		this.date = date;
		this.setURL();
	}
	
	public List<Repository> getTrendingRepositories() throws Exception {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response res = invocationBuilder.get();
		
		int status = res.getStatus();
		
		if( status != 200 )
			throw new Exception("Github API is down");
		
	    return res.readEntity(new GenericType<Root>() {}).getItems();
		
	}
	
	private void setURL() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.URL = "https://api.github.com/search/repositories?q=created:%3E" + dateFormat.format(date) + "&sort=stars&order=desc";
		
	}

}
