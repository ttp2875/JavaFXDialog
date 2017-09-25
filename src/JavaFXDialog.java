import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import java.util.Optional;

public class JavaFXDialog extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextInputDialog textInputDialog = new TextInputDialog("5\'10\"");
        Optional<String> heightInput = textInputDialog.showAndWait();

        String height = heightInput.get();
        String heightFeet = height.substring(0,height.lastIndexOf("\'"));
        String heightInches = height.substring(height.lastIndexOf("\'")+1,height.lastIndexOf("\""));

        double inches = (Double.parseDouble(heightFeet)*12+Double.parseDouble(heightInches));

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Alert alert = new Alert(AlertType.INFORMATION);
        double screenWidth = primaryScreenBounds.getWidth();
        double screenheight = primaryScreenBounds.getHeight();

        double dialogWidth = alert.getDialogPane().getWidth();
        double heightInCm = inches*2.54;

        alert.setTitle("Matrix System Converter");
        alert.setHeaderText("Feet and Inches to centimeters Converter");
        alert.setContentText("Your height in centimeters is " + heightInCm);
        alert.setX(screenWidth-dialogWidth);
        alert.setY(0);
        alert.show();
    }

    public static void main(String [] args){
        launch(args);
    }
}



