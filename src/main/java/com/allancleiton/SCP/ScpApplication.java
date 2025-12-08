package com.allancleiton.SCP;

import com.allancleiton.SCP.adapters.outbound.service.ExcelLoadPallet;
import com.allancleiton.SCP.adapters.outbound.service.ExcelLoadProduct;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class ScpApplication extends Application {

    private static Scene mainScene;
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws IOException {

        springContext = new SpringApplicationBuilder(ScpApplication.class).run();

        ExcelLoadPallet excelLoadPallet = springContext.getBean(ExcelLoadPallet.class);
        ExcelLoadProduct excelLoadProduct = springContext.getBean(ExcelLoadProduct.class);
        excelLoadPallet.LoadPallets();
        excelLoadProduct.LoadProducts();




    }

    @Override
    public void start(Stage stage) {
        try{

            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/view/MainView.fxml")));
            AnchorPane parent = loader.load();

            mainScene = new Scene(parent);
            mainScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style/application.css")).toExternalForm());
            stage.setTitle("SIMP");
            stage.setScene(mainScene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void stop() {
        springContext.close();
    }

    static void main(String[] args){
        launch(args);
    }

    public static Scene getMainScene(){
        return mainScene;
    }
}
