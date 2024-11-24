# Magical Arena

## Overview
The Magical Arena is a simple Java program simulating a battle between two players. Each player has attributes for health, strength, and attack. Players take turns attacking and defending based on dice rolls until the health of one player reaches 0.

The game picks the player with lesser health to start with. Damage from an attacking die-throw is combined with the damage from a defending die-roll and subtracted from his health. Finally, when the battle ends, the program declares a winner.

## Feature
1.Two players with customizable attributes:
  -Health
  -Strength
  -Attack
2.Dice rolls to determine attack and defense outcomes.
3.Turns alternate between the players.
4.Game ends when one player's health reaches 0.
5.Simple, console-based output to show the battle flow and winner.


## Prerequisites
To run this program, ensure you have the following installed on your system:

Java Development Kit (JDK) 8 or higher
A code editor or IDE like IntelliJ IDEA, Eclipse, or VS Code
Terminal/Command Prompt for execution

## Setup Instructions
Follow these steps to install and run the program:

1. Download the Repository and extract it.
2. Open the project folder in your favorite Java IDE (IntelliJ IDEA, Eclipse, etc.).
   
3. Ensure the folder structure is as follows:
   src/
   Player.java
   Battle.java
   Game.java

4.Compile a code:
   Open the terminal/command prompt in the src folder.
   
  Compile the Java files: 
  **javac Player.java Battle.java Game.java**
   
  5.Run the program:
   Run the Game class: 
   **java Game**
   
   
