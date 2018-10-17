package com.repository;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.List;

import com.model.Post;

public class DAO implements DAOInterface {
	//private RestClient client;
	private RestHighLevelClient client;
	
	
	public DAO() {
		client = new RestHighLevelClient (
				RestClient.builder(
						new HttpHost("localhost", 9200, "http"),
						new HttpHost("localhost", 9201, "http")));
	}
	
	public SearchHits getPosts(String user, String social_net) {
		/*Request request = new Request(
				"POST",
				"/posts_bzm/_search");
		request.addParameter("pretty", "true");
		request.setJsonEntity(
				"{\n" + 
				"  \"query\": {\n" + 
				"  	\"bool\": {\n" + 
				"  		\"must\": [\n" + 
				"  			{\"match\": { \"author.name\": \""+ user + "\"}},\n" + 
				"    		{\"match\": { \"service\" : \""+ social_net + "\"}}\n" + 
				"  		]\n" + 
				"    }	\n" + 
				"  },\n" + 
				"  \"sort\": [\n" + 
				"  	{ \"date\" : {\"order\" : \"asc\"}}\n" + 
				"	]\n" + 
				"}\n" + 
				""	
		);
		
		Response response = null;
		try {
			response = client.performRequest(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		HttpHost host = response.getHost();
		int statusCode = response.getStatusLine().getStatusCode();
		return response;*/
		
		
		SearchRequest searchRequest = new SearchRequest("posts_bzm");
		searchRequest.types("posts");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		
		BoolQueryBuilder bool = new BoolQueryBuilder().must(new MatchQueryBuilder("author.name", user)).must(new MatchQueryBuilder("service", social_net));
		searchSourceBuilder.query(bool); 
		searchSourceBuilder.sort(new FieldSortBuilder("date").order(SortOrder.ASC));
		
		searchRequest.source(searchSourceBuilder); 
		
		SearchResponse searchResponse = null;
		try {
			searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		
			SearchHits hits = searchResponse.getHits(); 
			
			return hits;
		
		}
		
	}
	
	


}
