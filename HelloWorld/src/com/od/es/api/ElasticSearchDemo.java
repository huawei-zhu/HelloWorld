package com.od.es.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchDemo {

	public static void main(String[] args) {
		// execute();
		createIndex();
	}

	public static void createIndex() {
		try {
			TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress
					.getByName("127.0.0.1"), 9300));

			Map<String, Object> json = new HashMap<String, Object>();
			json.put("user", "kimchy");
			json.put("postDate", new Date());
			json.put("message", "trying out Elasticsearch");
			
			IndexResponse response = client.prepareIndex("indexdemo", "typedemo").setSource(json).execute().actionGet();
			System.out.println("response:" + response.toString());
			searcher(client,"indexdemo", "typedemo");
			
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void searcher(TransportClient client, String indexname, String type) {
		QueryBuilder queryBuilder = QueryBuilders.termQuery("user", "kimchy");
		SearchResponse searchResponse = client.prepareSearch(indexname).setTypes(type).setQuery(queryBuilder).execute().actionGet();
		SearchHits hits = searchResponse.getHits();
		System.out.println("total = " + hits.getTotalHits());
		SearchHit[] searchHists = hits.getHits();
		if (searchHists.length > 0) {
			for (SearchHit hit : searchHists) {
				String name = (String) hit.getSource().get("user");
				System.out.println("(" + name + ")");
			}
		}
	}

	public static void execute() {
		System.out.println("Beginning execute method!");

		try { // get URL content
			URL url = new URL("http://127.0.0.1:9200");
			URLConnection conn = url.openConnection();// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();
			System.out.println("Done");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
