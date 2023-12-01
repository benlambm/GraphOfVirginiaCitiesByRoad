# GraphOfVirginiaCitiesByRoad README 🛣️ 

## Introduction 🔍

GraphOfVirginiaCitiesByRoad is a demo Java-based graph application that creates a graph of major Virginia cities and computes the shortest path between any two cities by road. It utilizes the JGraphT library to manage and process graph data efficiently.

## Features 🚗 

- Initializes a simple weighted, unidirectional graph of select cities in Virginia.
- Finds the shortest path between any two cities based on road distances.
- Uses JGraphT for graph operations and pathfinding algorithms.

## Prerequisites

Download [JGraphT Library](https://www.jgrapht.org/download.html), manually (not using Maven), unarchive it, find the two jars listed below (core and Jheaps) in the lib folder, and add them to your Build Path:
- Java JDK 17 or later.
- JGraphT core library (version 1.5.2).
- JHeaps library (version 0.14).


### Step 3: Set Up the Project

1. Open your Java IDE (e.g., Eclipse, IntelliJ IDEA).
2. Import the files however you wish (git, etc)
3. Ensure that the following files are included in your project:
   - `edu/vwcc/citygraph`
   - `AnyTextReader.java`
   - `GraphHelper.java`
   - `Main.java`
   - `DrivingDistances_CitiesVA.txt`
4. Add the JGraphT and JHeaps libraries to your project's build path.

## Usage

1. Run `Main.java` in your IDE to start the application.
2. Follow the on-screen instructions to input two Virginia cities.
3. The program will display the shortest path by road between the selected cities.

## Contributing

Contributions to the GraphOfVirginiaCitiesByRoad project are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Thanks to the JGraphT team for their excellent graph library!
- This project was inspired by VDOT :) 

---

For more information or support, please contact the repository owner: [Ben Lamb](https://benlamb.github.io)

