/**
* File: Main.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Entry point for the game. Launches JavaFX and hands control to the GameController.
*/

package main;

import controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// The controller takes over from here and shows the first screen
		new GameController(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
