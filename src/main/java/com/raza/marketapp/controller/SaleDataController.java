
package com.raza.marketapp.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import static java.lang.Math.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import com.raza.marketapp.model.*;

@RestController
@RequestMapping("api")
public class SaleDataController {
	private static final String USER_AGENT = "Mozilla/5.0";

	@RequestMapping(value = "/get_sale_data", method = RequestMethod.GET)
	public String get_sale_data() {

		ArrayList<String> output = new ArrayList<String>();

		output.add("Market Maker Service\n====================================================<br><br>");
		output.add("<input type='text' id='buy' value='Buy'></input><input type='text' id='sell' value='Sell'></input><button>Submit</button><br>");

		output.add("Ticker Tesla\n====================================================<br>");

		output.add("<style>\ntable { border-collapse: collapse; width: 100%; border: 1px solid black; background: #ddd; table-layout: fixed; }</style>");

		output.add("<style>\ntable th, table td { border: 1px solid #000; width: auto; }</style>");

		output.add("<table><thead><tr><th colspan='3'>Buy</th><th colspan='3'>Sell</th></tr><tr><th colspan='1'>#Shares</th><th colspan='1'>$</th><th colspan='1'>Total_shares</th><th colspan='1'>#Shares2</th><th colspan='1'>$</th><th colspan='1'>Total_shares</th></tr></thead><tbody>");

		Gson g = new Gson();
		String out;
		try
		{
			out = sendGET("http://34.107.49.226/api/get_sale_data");
		}
		catch (IOException e)
		{
			return "<div>Error!</div>";
		}
		ArrayList<MarketItem> lst = g.fromJson(out, new TypeToken<ArrayList<MarketItem>>(){}.getType());

		for (MarketItem it : lst)
		{
			output.add("<tr><td colspan='1'>100</td><td colspan='1'>" + round(it.getBuyprice()*100.0)/100.0 + "</td><td colspan='1'>" + it.getTotalshares() + "</td><td colspan='1'>100</td><td colspan='1'>" + round(it.getSellprice()*100.0)/100.0 + "</td><td colspan='1'>" + it.getTotalshares() + "</td></tr>");
		}
		output.add("</tbody></table>");
		return String.join("", output);
		//return new Gson().toJson(items);
		//return "docker-java-app is up and running: " + new Date();
	}

	private static String sendGET(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		} else {
			return null;
		}

	}
}
