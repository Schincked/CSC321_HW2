# Virtual Dulcimer

This project is a virtual dulcimer simulation that allows users to play a dulcimer using their keyboard. The project includes classes for modeling the dulcimer and its strings, as well as utilities for audio playback and graphical display.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Classes and Methods](#classes-and-methods)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/virtual-dulcimer.git
    ```
2. Navigate to the project directory:
    ```sh
    cd virtual-dulcimer
    ```
3. Compile the Java files:
    ```sh
    javac src/*.java
    ```

## Usage

To run the virtual dulcimer, execute the `DulcimerDriver` class:
    ```sh
    java src/DulcimerDriver
    ```

## Project Structure
README.md
src/
    .gitkeep
    Dulcimer.java
    DulcimerDriver.java
    DulcimerString.java
    StdAudio.java
    StdDraw.java

Dulcimer.java: Models the dulcimer and its strings.
DulcimerDriver.java: The main driver class for the virtual dulcimer.
DulcimerString.java: Represents a single string on the dulcimer.
StdAudio.java: Utility class for audio playback.
StdDraw.java: Utility class for graphical display.

## Classes and Methods

### Dulcimer

#### Constructor
`Dulcimer(String notes)`: Constructs a Dulcimer with the specified notes.

#### Methods
`void hammer(int stringNum)`: Strikes the specified string.
`void play()`: Plays the sounds corresponding to all struck strings.

### DulcimerDriver

#### Main Method
`public static void main(String[] args)`: The entry point for the virtual dulcimer application.

### DulcimerString

#### Constructor
`DulcimerString(String note)`: Creates a dulcimer string with the specified note.

#### Methods
`String getNote()`: Gets the note information.
`int getOffsetFromMiddleC()`: Calculates the offset from middle C.
`void strike()`: Strikes the string.
`double sample()`: Samples the string.

### StdAudio

#### Methods
`static void play(double in)`: Plays a single audio sample.
`static void play(double[] input)`: Plays an array of audio samples.
`static double[] read(String filename)`: Reads audio samples from a file.
`static void save(String filename, double[] input)`: Saves audio samples to a file.

### StdDraw

#### Methods
`static void setCanvasSize(int w, int h)`: Sets the canvas size.
`static void setXscale(double min, double max)`: Sets the x-scale.
`static void setYscale(double min, double max)`: Sets the y-scale.
`static void textLeft(double x, double y, String s)`: Draws left-aligned text.
`static boolean hasNextKeyTyped()`: Checks if a key has been typed.
`static char nextKeyTyped()`: Gets the next key typed.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

