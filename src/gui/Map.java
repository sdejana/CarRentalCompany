package gui;
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Map extends Application {

    private static final int MAP_SIZE = 20;
    private Label[][] mapGrid = new Label[MAP_SIZE][MAP_SIZE];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Initialize the map grid
        initializeMap(gridPane);

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vehicle Map Simulation");
        primaryStage.show();

        // Simulate vehicle movement
        simulateMovement("T1", new int[]{0, 0}, new int[]{7, 8}, 5);
    }

    private void initializeMap(GridPane gridPane) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                Label label = new Label(".");
                label.setFont(new Font("Arial", 20));
                label.setTextFill(Color.BLACK);
                mapGrid[i][j] = label;
                gridPane.add(label, j, i);
            }
        }
    }

    private void simulateMovement(String vehicleId, int[] start, int[] dest, int duration) {
        int xStep = (dest[0] - start[0]) / duration;
        int yStep = (dest[1] - start[1]) / duration;

        for (int i = 0; i < duration; i++) {
            int x = start[0] + i * xStep;
            int y = start[1] + i * yStep;

            updateMapPosition(x, y, vehicleId);

            try {
                Thread.sleep(1000); // Simulate real-time movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mark the final position
        updateMapPosition(dest[0], dest[1], vehicleId);
    }

    private void updateMapPosition(int x, int y, String vehicleId) {
        // Clear previous positions
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                mapGrid[i][j].setText(".");
            }
        }

        // Set the new position
        mapGrid[x][y].setText(vehicleId);
        mapGrid[x][y].setTextFill(Color.RED);
    }
}
*/