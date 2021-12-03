package com.gulukal.PhoneBook;

import com.gulukal.PhoneBook.model.Person;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primary;
	private BorderPane rootpane;
	private ObservableList<Person> people; // fxml de name surname tablo ile gosterdigimiz icin observableList dedik

	private ObservableList<Person> getPeople(){
		if(this.people ==null) {
			this.people = FXCollections.observableArrayList();
		}
		return this.people;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		initPhoneEntries();
		initPrimaryStage(primaryStage);
		initRootLoayout();
		initRootLoayout();
		showPersonOverview();

	}

	private void initPhoneEntries() {
		this.getPeople().add(new Person("Gülten", "Ulukal"));  // constracter ile
		this.getPeople().add(new Person.Builder().name("Deniz").surname("Yonkuc").phoneNumber("111").build());   // builder ile
		
	}

	private void initPrimaryStage(Stage primaryStage) {

		this.primary = primaryStage;
		this.primary.getIcons().add(new Image(getClass().getResourceAsStream("resources/PhoneBookIcon.png")));
		this.primary.setTitle("GU PHONE BOOK");

	}

	private void showPersonOverview() {

		FXMLLoader loader = new FXMLLoader(); // scene i ekranda gostermek icin
		loader.setLocation(getClass().getResource("view/PersonOverview.fxml"));

		try {

			AnchorPane personOverview = (AnchorPane) loader.load();
			this.rootpane.setCenter(personOverview);

		} catch (Exception e) {
			// TODO: handle exception
		}

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
