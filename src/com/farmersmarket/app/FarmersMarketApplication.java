package com.farmersmarket.app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.farmersmarket.views.LoginView;
public class FarmersMarketApplication {
    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();
        Scene scene = new Scene(loginView.getView(), 800, 600);
        primaryStage.setTitle("Farmers' Market Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
