
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
//@RequestMapping("api")
public class LoginController {
	private static final String USER_AGENT = "Mozilla/5.0";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String get_sale_data() {

		ArrayList<String> output = new ArrayList<String>();

                output.add("<html><head><link href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'></head><body><header><nav class='navbar navbar-expand-md navbar-dark fixed-top bg-dark'><a class='navbar-brand' href='/'>Trading site</a><div class='navbarCollapse' id='navbarCollapse'><ul class='navbar-nav mr-auto'><li class='nav-item active'><a href='/' class='nav-link'>Home</a></li><li class='nav-item'><a class='nav-link' href='/register'>Register</a></li><li class='nav-item'><a class='nav-link' href='/login'>Login</a></li></ul></div></nav></header>");
		output.add("Market Maker Service\n====================================================<br><br>");
		output.add("<input class='form-control mr-sm-2' type='text' id='username' placeholder='username'></input><input class='form-control mr-sm-2' type='text' id='password' placeholder='password'></input><button class='btn btn-outline-success my-2 my-sm-0'>Login</button></div><br></body></html>");

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
