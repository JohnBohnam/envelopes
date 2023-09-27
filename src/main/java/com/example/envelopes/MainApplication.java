package com.example.envelopes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    Controller controller = new Controller();
    Drawer drawer = new Drawer();
    int n = 10;
    double t = 2;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(controller);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();

        controller.tSlider.valueProperty().addListener((observable -> {
            this.t = controller.tSlider.getValue();
            update();
        }));
        controller.nSlider.valueProperty().addListener((observable -> {
            this.n = (int) controller.nSlider.getValue();
            controller.tSlider.setMax(n);
            update();
        }));
        controller.tField.setOnAction(observable -> {
            this.t = Double.parseDouble(controller.tField.getText());
            controller.tSlider.setMax(n);
            update();
        });
        controller.nField.setOnAction(observable -> {
            this.n = Integer.parseInt(controller.nField.getText() );
            update();
        });
    }

    void update() {
        var children = controller.anchorPane.getChildren();
        children.clear();
        children.addAll(drawer.draw(n, t));
        controller.nField.setText(String.valueOf(n));
        controller.tField.setText(String.valueOf(t));
        controller.nSlider.setValue(n);
        controller.tSlider.setValue(t);
    }

    public static void main(String[] args) {
        launch();
    }
}