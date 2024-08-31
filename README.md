# PRODIGY_AD_04
Tic Tac Toe
Overview
This project is a simple Tic Tac Toe game built for Android. The game allows two players to take turns placing their symbols (X or O) on a 3x3 grid, with the objective of forming a horizontal, vertical, or diagonal line of three symbols to win. The app includes a reset option to start a new game.

Features
Two-Player Mode: Two players can compete against each other on the same device.
Win Detection: The game automatically detects and announces the winner or if the game ends in a draw.
Reset Functionality: Players can reset the game board at any time to start a new match.
Intuitive User Interface: Simple and user-friendly UI designed for easy gameplay.
Files
1. activity_main.xml
Location: res/layout/
Purpose: This XML file defines the layout for the main activity, including the 3x3 grid where the game is played, and buttons for player interaction (e.g., reset button).
2. MainActivity.java
Location: src/main/java/com/yourpackage/
Purpose: This Java file contains the logic for the Tic Tac Toe game. It manages player turns, checks for winning conditions, and handles the reset functionality.
Key Features:
Game logic implementation (turn-taking, win/draw detection).
UI updates based on player interactions.
Resetting the game state.
Getting Started
Clone or download the project.
Open the project in Android Studio.
Build and run the app on an Android device or emulator.
How to Play
The game starts with Player X.
Players take turns tapping on an empty cell in the grid to place their symbol.
The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins the game.
If all cells are filled without a winner, the game ends in a draw.
Use the reset button to start a new game.
Additional Information
Minimum SDK Version: 21 (or whichever version you're targeting)
Target SDK Version: 30 (or whichever version you're targeting)
