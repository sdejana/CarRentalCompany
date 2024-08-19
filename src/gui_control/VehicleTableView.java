package gui_control;

/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Vehicle;

import java.util.List;

public class VehicleTableView extends Application {

    private List<Vehicle> vehicleList;

    public VehicleTableView(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Vehicle> table = new TableView<>();

        // Definišite kolone
        TableColumn<Vehicle, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Vehicle, String> manufacturerColumn = new TableColumn<>("Manufacturer");
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

        TableColumn<Vehicle, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Vehicle, Double> batteryLevelColumn = new TableColumn<>("Battery Level");
        batteryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("currentBatteryLevel"));

        // Dodajte kolone u tabelu
        table.getColumns().add(idColumn);
        table.getColumns().add(manufacturerColumn);
        table.getColumns().add(modelColumn);
        table.getColumns().add(batteryLevelColumn);

        // Dodajte podatke u tabelu
        table.getItems().addAll(vehicleList);

        // Kreirajte scenu
        Scene scene = new Scene(table, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vehicle Table");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

*/