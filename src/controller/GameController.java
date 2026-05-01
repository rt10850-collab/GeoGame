/**
* File: GameController.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Manages navigation between all three screens and holds the shared GameSettings object that persists across screens.
*/

package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameSettings;
import model.GeoGame;
import view.GameLoopScreen;
import view.IntroductionScreen;
import view.SettingsScreen;

public class GameController {

	private Stage primaryStage;
	private GameSettings settings;

	/**
	 * - Creates the controller and starts the application on the Introduction
	 * Screen. - - @param primaryStage The main JavaFX window provided by the
	 * Application class
	 */
	public GameController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.settings = new GameSettings(); // One settings object shared by all screens

		showIntroductionScreen(); // Always start here
	}

	/**
	 * - Navigates to the Introduction Screen.
	 */
	public void showIntroductionScreen() {
		IntroductionScreen introScreen = new IntroductionScreen(settings, this);
		Scene scene = new Scene(introScreen.getLayout(), 700, 500);
		primaryStage.setTitle("GeoGame");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * - Navigates to the Settings Screen.
	 */
	public void showSettingsScreen() {
		SettingsScreen settingsScreen = new SettingsScreen(settings, this);
		Scene scene = new Scene(settingsScreen.getLayout(), 700, 500);
		primaryStage.setTitle("GeoGame - Settings");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * - Navigates to the Game Loop Screen. - Creates a fresh GeoGame each time so
	 * the score resets.
	 */
	public void showGameLoopScreen() {
		GeoGame game = new GeoGame(settings);
		GameLoopScreen gameLoopScreen = new GameLoopScreen(game, settings, this);
		Scene scene = new Scene(gameLoopScreen.getLayout(), 700, 500);
		primaryStage.setTitle("GeoGame - Playing");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * - Closes the application.
	 */
	public void exitGame() {
		primaryStage.close();
	}
}
