package com.gulukal.PhoneBook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primary;
	private BorderPane rootpane;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		initPrimaryStage(primaryStage);
		initRootLoayout();
		initRootLoayout();

	}

	private void initPrimaryStage(Stage primaryStage) {

		this.primary = primaryStage;
		this.primary.getIcons().add(new Image(getClass().getResourceAsStream("resources/PhoneBookIcon.png")));
		this.primary.setTitle("GU PHONE BOOK");

	}

	private void initRootLoayout() {
		try {
			this.rootpane = (BorderPane) FXMLLoader.load(getClass().getResource("view/PhoneBook.fxml"));
			Scene scene = new Scene(this.rootpane, 400, 400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			this.primary.setScene(scene);
			// primaryStage.initStyle(StageStyle.UNDECORATED);
			this.primary.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
