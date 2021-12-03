module PhoneBook {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens com.gulukal.PhoneBook to javafx.graphics, javafx.fxml;
}
