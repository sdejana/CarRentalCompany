package gui_control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class MapControl extends Application {

    private static final int MAP_SIZE = 20;
    private Label[][] mapGrid = new Label[MAP_SIZE][MAP_SIZE];
    private Image bikeImage;
    private Image carImage;
    private Image scooterImage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
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

        Scene scene = new Scene(root, 1050, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vehicle MapControl Simulation");
        primaryStage.show();

        // Simulate vehicle movement
        simulateMovement("car", new int[]{0, 0}, new int[]{6, 19}, 5);

        simulateMovement("bike", new int[]{9, 10}, new int[]{5, 7}, 10);

        simulateMovement("scooter", new int[]{2, 2}, new int[]{8, 8}, 7);
    }

    private void initializeMap(GridPane gridPane) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                Label label = new Label();
                label.setFont(new Font("Arial", 20));

                // Set the size of each cell (field)
                label.setMinSize(50, 33); // Set a larger size for better visibility
                label.setPrefSize(50, 33);
                label.setMaxSize(50, 33);

                // Center the text within the Label
                label.setAlignment(Pos.CENTER);

                // Style the label with a border for better visualization
                label.setStyle("-fx-border-color: black;");

                // Color specific fields from 5th to 14th
                if (i >= 5 && i <= 14 && j >= 5 && j <= 14) { // 5th to 14th fields are indices 4 to 13
                    label.setBackground(new Background(new BackgroundFill(Color.PALEVIOLETRED, CornerRadii.EMPTY,
                            javafx.geometry.Insets.EMPTY)));
                } else {
                    label.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY,
                            javafx.geometry.Insets.EMPTY)));
                }

                mapGrid[i][j] = label;
                gridPane.add(label, j, i);

                // Center the label within its GridPane cell
                GridPane.setHalignment(label, HPos.CENTER);
                GridPane.setValignment(label, VPos.CENTER);
            }
        }
    }

    private void simulateMovement(String vehicleType, int[] start, int[] dest, int duration) {
        ImageView vehicleImageView = getVehicleImageView(vehicleType);

        if (vehicleImageView == null) return;

        final int[] currentX = {start[0]};
        final int[] currentY = {start[1]};

        int totalXSteps = Math.abs(dest[0] - start[0]);
        int totalYSteps = Math.abs(dest[1] - start[1]);
        int totalSteps = totalXSteps + totalYSteps;

        // Declare the timeline variable
        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
            if (currentX[0] != dest[0]) {
                currentX[0] += Integer.signum(dest[0] - currentX[0]); // Move horizontally
            } else if (currentY[0] != dest[1]) {
                currentY[0] += Integer.signum(dest[1] - currentY[0]); // Move vertically
            }

            updateMapPosition(currentX[0], currentY[0], vehicleImageView,5);

            // Print current coordinates with vehicle type
            System.out.println(vehicleType + " is at (" + currentX[0] + ", " + currentY[0] + ")");

            // Stop the animation when the destination is reached
            if (currentX[0] == dest[0] && currentY[0] == dest[1]) {
                System.out.println(vehicleType + " has arrived at the destination.");
                timeline.stop(); // Stop the timeline
            }
        }));

        timeline.setCycleCount(totalSteps); // Set the number of cycles (steps)
        timeline.play(); // Start the animation
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
        imageView.setFitWidth(30); // Adjust size as needed
        imageView.setFitHeight(30); // Adjust size as needed

        return imageView;
    }

    private void updateMapPosition(int x, int y, ImageView vehicleImageView, int number) {
        // Reset the color of all fields and clear previous positions
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                mapGrid[i][j].setGraphic(null); // Clear the cell
                mapGrid[i][j].setText(""); // Clear the text

                // Reset the background color based on the position
                if (i >= 5 && i <= 14 && j >= 5 && j <= 14) {
                    mapGrid[i][j].setBackground(new Background(new BackgroundFill(Color.MEDIUMPURPLE, CornerRadii.EMPTY, Insets.EMPTY)));
                } else {
                    mapGrid[i][j].setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
        }

        // Set the new position with left alignment, custom background color, and number
        if (vehicleImageView != null) {
            Label targetLabel = mapGrid[x][y];
            targetLabel.setGraphic(vehicleImageView);
            targetLabel.setContentDisplay(ContentDisplay.LEFT); // Align the image to the left
            targetLabel.setGraphicTextGap(1); // Adjust the gap between the image and text if necessary
            targetLabel.setText(String.valueOf(number)); // Set the number next to the image

            // Change the background color of the current field to indicate a vehicle is present
            targetLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

}
