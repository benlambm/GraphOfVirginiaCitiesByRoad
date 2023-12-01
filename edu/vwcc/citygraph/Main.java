package edu.vwcc.citygraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	// let's begin!
	public static void main(String[] args) {

		// load data from text file initially into simple String map
		Map<String, String[]> cityMap = readTxtFile("DrivingDistances_CitiesVA.txt");

		// convert cityMap to real Graph data structure using custom helper class
		GraphHelper graphHelper = new GraphHelper(cityMap);

		// run UI loop
		int menuChoice = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			displayMenu();
			menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				graphHelper.dataSummary();
				break;
			case 2:
				printMap(cityMap);
				break;
			case 3:
				graphHelper.findShortestPath();
			}

		} while (menuChoice != 0);
		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("""
				ENTER A MENU NUMBER:
				1. Summarize Graph Data
				2. View Full Graph
				3. Calculate Shortest Driving Route Between Two Cities
				or 0. to Exit""");
	}

	private static Map<String, String[]> readTxtFile(String fileName) {
		Map<String, String[]> map = new HashMap<>();
		AnyTextReader tr = new AnyTextReader("edu", "vwcc", "citygraph", fileName);
		List<String> txt = tr.getFullText();
		// perform text input processing to create HashMap
		for (String line : txt) {
			int colon = line.indexOf(':');
			String city = line.substring(0, colon);
			String neighbors = line.substring(colon + 2);
			map.put(city, neighbors.split(", "));
		}
		return map;
	}

	private static void printMap(Map<String, String[]> map) {
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			System.out.println(
					"City: " + key + " -> Neighbors: " + Arrays.stream(values).collect(Collectors.joining(" ")));
		}
	}

}
