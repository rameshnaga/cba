package com.org.controller;


/**
 * @author MYPC
 *
 */

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

import com.org.data.Alerts;
import com.org.data.Generator;
import com.org.data.WeatherModel;
import com.org.model.Item;
import com.org.parser.ItemParser;
import com.org.io.SingleItemReader;

public class MainController {
	
	private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());
	
	public static void main(String[] args) {
		LOGGER.info("Generating Weather data:::");
		
		
		if (args == null | args.length < 5) {
			LOGGER.severe("Usage ::: MainController  <modelfile> <alertsfile> <startdate> <duration> <outputfile>"
					+ "e.g java -cp WeatherSimulator.jar MainController items.txt alerts.json 2016-12-29 10 output.txt");
			System.exit(1);
		}
		Boolean result;
		
		try {
			// load dictionary from 
			SingleItemReader<Item> singleLogReader = new SingleItemReader<Item>(
					new ItemParser(), new File(args[0]));
			WeatherModel<Item> weatherModel = new WeatherModel<Item>(singleLogReader);
			// load Alert
			Alerts alert = new Alerts(args[1]);
			// prepare generator
			Generator generator = new Generator(weatherModel, alert);
			String startDate = args[2];
			int duration = Integer.parseInt(args[3]);
			String outputPath = args[4];
			result = generator.generateData(startDate, duration,outputPath);
			System.out.println("--------------------------------------------");
			if (result != null)
				System.out.println("Completed!");
			else
				System.out.println("Sorry, Something wrong.");
		} catch (IOException e) {
			System.out.println("The file format is not valid.");
			e.printStackTrace();
			System.exit(1);
		} catch (ParseException e) {
			System.out.println("The file can not be parsed. ");
			System.exit(-1);
		} catch (Exception e) {
			System.out.println("Exception found :"  + e.toString());
			
			System.exit(-1);
		}

		System.out.println("--------------------------------------------");

		
		
	}

}
