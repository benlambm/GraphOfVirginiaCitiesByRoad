package edu.vwcc.citygraph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AnyTextReader {
	// Get the current working directory
	private String currentWorkingDir = System.getProperty("user.dir");

	// Store the absolute file path
	private Path filePath = null;

	// Store all lines of text as a List of Strings
	private List<String> lines = null;

	// This constructor requires all folder names and text file name from Project
	// root directory!
	public AnyTextReader(String... pathNames) {
		filePath = Paths.get(currentWorkingDir, pathNames);
		// Use Files.readAllLines() to read in lines of text as List of Strings
		try {
			lines = Files.readAllLines(filePath);
		} catch (IOException e) {
			System.out.println("Error reading in text file: ");
			e.printStackTrace();
		}
	}

	public List<String> getFullText() {
		return lines;
	}

}
