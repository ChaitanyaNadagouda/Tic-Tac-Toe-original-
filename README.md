# Tic-Tac-Toe-original
Tic-Tac-Toe Game - Command Line Interface

Welcome to the Tic-Tac-Toe Command Line Game! 
This repository houses a fully playable Tic-Tac-Toe game implemented in Java, where you can challenge your friends or play against bots of varying difficulty levels.

How to Play

Clone the Repository:
bash
git clone https://github.com/your_username/tic-tac-toe.git

Navigate to the Repository:
bash
cd tic-tac-toe

Compile the Java Files:
javac TicTacToe.java

Run the Game:
java TicTacToe

Follow On-Screen Instructions:

Enter the coordinates of the cell you want to place your marker (X or O).
Play against a friend or challenge the bot!

Design Patterns Implemented
This game leverages various design patterns to ensure maintainability, extensibility, and ease of understanding. Here's how:

Strategy Pattern for Winning Strategies and Bot Playing Strategies:

The game implements a strategy pattern to define various winning strategies.
It also uses different strategies for bot players of varying difficulty levels, such as Easy, Medium, and Hard.
By decoupling the strategies from the main game logic, it becomes easy to add new strategies without modifying existing code.
Builder Design Pattern for Game Building:

The builder design pattern is employed to construct the game environment, including the game board, players, and bot difficulty levels.
This pattern enables the creation of complex game configurations step by step, ensuring flexibility and ease of customization.
Factory Design Pattern for Easy Bot Playing Strategy:

A factory design pattern is utilized to instantiate easy bot playing strategies.
This abstraction allows for easy creation of bot instances without exposing the creation logic to the client.
Contributions
Contributions are welcome! Whether you want to add new features, fix bugs, or improve documentation, feel free to submit pull requests.

Feedback and Support
If you encounter any issues or have suggestions for improvements, please open an issue on GitHub. Your feedback is highly appreciated.

Enjoy playing Tic-Tac-Toe!

Disclaimer: This game is for educational purposes only. Have fun responsibly!







