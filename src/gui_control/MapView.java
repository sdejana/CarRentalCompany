package gui_control;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class MapView extends Application {

    private static final int MAP_SIZE = 20;
    private Label[][] mapGrid = new Label[MAP_SIZE][MAP_SIZE];
    private Image bikeImage;
    private Image carImage;
    private Image scooterImage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Load images
        bikeImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/bike.png")));
        carImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/car.png")));
        scooterImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/scooter.png")));

        GridPane gridPane = new GridPane();

        // Initialize the map grid
        initializeMap(gridPane);

        // Wrap the GridPane inside a StackPane to center it in the Scene
        StackPane root = new StackPane(gridPane);
        root.setAlignment(Pos.CENTER); // Center the GridPane in the StackPane

        Scene scene = new Scene(root, 1050, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vehicle MapControl Simulation");
        primaryStage.show();

        // Create and start threads for each vehicle to move simultaneously
        Thread carThread = createVehicleThread("car", new int[]{0, 0}, new int[]{6, 19}, 5);
        Thread bikeThread = createVehicleThread("bike", new int[]{9, 10}, new int[]{5, 7}, 10);
        Thread scooterThread = createVehicleThread("scooter", new int[]{2, 2}, new int[]{8, 8}, 7);

        carThread.start();
        bikeThread.start();
        scooterThread.start();
    }

    private void initializeMap(GridPane gridPane) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                Label label = new Label();

                // Set the size of each cell (field)
                label.setMinSize(50, 35);
                label.setPrefSize(50, 35);
                label.setMaxSize(50, 35);

                label.setAlignment(Pos.CENTER);
                label.setStyle("-fx-border-color: black;");

                if (i >= 5 && i <= 14 && j >= 5 && j <= 14) {
                    label.setBackground(new Background(new BackgroundFill(Color.PALEVIOLETRED, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                }

                mapGrid[i][j] = label;
                gridPane.add(label, j, i);
                GridPane.setHalignment(label, HPos.CENTER);
                GridPane.setValignment(label, VPos.CENTER);
            }
        }
    }

    private Thread createVehicleThread(String vehicleType, int[] start, int[] dest, int speed) {
        return new Thread(() -> {
            try {
                simulateMovement(vehicleType, start, dest, speed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private void simulateMovement(String vehicleType, int[] start, int[] dest, int speed) throws InterruptedException {
        ImageView vehicleImageView = getVehicleImageView(vehicleType);

        if (vehicleImageView == null) return;

        int currentX = start[0];
        int currentY = start[1];

        int totalXSteps = Math.abs(dest[0] - start[0]);
        int totalYSteps = Math.abs(dest[1] - start[1]);

        while (currentX != dest[0] || currentY != dest[1]) {
            if (currentX != dest[0]) {
                currentX += Integer.signum(dest[0] - currentX); // Move horizontally
            } else if (currentY != dest[1]) {
                currentY += Integer.signum(dest[1] - currentY); // Move vertically
            }

            int finalCurrentX = currentX;
            int finalCurrentY = currentY;
            javafx.application.Platform.runLater(() -> updateMapPosition(finalCurrentX, finalCurrentY, vehicleImageView, 5));

            Thread.sleep(speed * 100); // Adjust speed to make vehicles move slower
        }
    }

    private ImageView getVehicleImageView(String vehicleType) {
        ImageView imageView = new ImageView();
        switch (vehicleType.toLowerCase()) {
            case "bike":
                imageView.setImage(bikeImage);
                break;
            case "car":
                imageView.setImage(carImage);
                break;
            case "scooter":
                imageView.setImage(scooterImage);
                break;
            default:
                return null;
        }
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);

        return imageView;
    }

    private void updateMapPosition(int x, int y, ImageView vehicleImageView, int number) {
        Label targetLabel = mapGrid[x][y];
        targetLabel.setGraphic(vehicleImageView);
        targetLabel.setContentDisplay(ContentDisplay.LEFT);
        targetLabel.setGraphicTextGap(1);
        //targetLabel.setText(String.valueOf(number));
        //targetLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
