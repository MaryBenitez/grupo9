package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Configuring Group and Scene
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Polyglot Sidequest: Thirdly");
        primaryStage.setScene(scene);

        //Creating Rectangle
        Rectangle rect = new Rectangle(200,200,200,200);
        rect.setFill(Color.SKYBLUE);
        rect.setStrokeWidth(5);

        //Instantiating RotateTransition class
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);

        Label escalado = new Label("Escalado:");
        final Spinner<Integer> spinnerE = new Spinner<Integer>();
        Label rotacion = new Label("Rotacion:");
        final Spinner<Integer> spinnerR = new Spinner<Integer>();
        Label traslacion = new Label("Traslacion:");
        final Spinner<Integer> spinnerT = new Spinner<Integer>();

        final int initialValue = 1;

        // Value factory
        SpinnerValueFactory<Integer> valueFactoryE = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
        SpinnerValueFactory<Integer> valueFactoryR = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
        SpinnerValueFactory<Integer> valueFactoryT = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);

        spinnerE.setValueFactory(valueFactoryE);
        spinnerR.setValueFactory(valueFactoryR);
        spinnerT.setValueFactory(valueFactoryT);

        Button buttonE = new Button("Iniciar");
        Button buttonR = new Button("Iniciar");
        Button buttonT = new Button("Iniciar");

        Button buttonEs = new Button("Parar");
        Button buttonRo = new Button("Parar");
        Button buttonTr = new Button("Parar");

        VBox label = new VBox( 30, escalado, rotacion, traslacion );
        VBox spinner = new VBox( 20, spinnerE, spinnerR, spinnerT );
        VBox buttonStart = new VBox( 20, buttonE , buttonR, buttonT );
        VBox buttonStop = new VBox( 20, buttonEs , buttonRo, buttonTr );

        HBox buttonBar = new HBox(5,label,spinner,buttonStart,buttonStop);

        buttonEs.setDisable(false);
        buttonRo.setDisable(false);
        buttonTr.setDisable(false);

        buttonR.setOnAction(event -> {
            buttonR.setDisable(true);
            buttonRo.setDisable(false);

            //Setting duration of the transition
            if (valueFactoryR.getValue()==1){
                rotate.setDuration(Duration.millis(3000)); //velocidad
                rotate.setAutoReverse(true);
                rotate.setNode(rect);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==2){
                rotate.setDuration(Duration.millis(2000)); //velocidad
                rotate.setAutoReverse(true);
                rotate.setNode(rect);
                rotate.play();
            }else if(valueFactoryR.getValue()==3){
                rotate.setDuration(Duration.millis(1500)); //velocidad
                rotate.setAutoReverse(true);
                rotate.setNode(rect);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==4){
                rotate.setDuration(Duration.millis(1000)); //velocidad
                rotate.setAutoReverse(true);
                rotate.setNode(rect);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==5){
                rotate.setDuration(Duration.millis(500)); //velocidad
                rotate.setAutoReverse(true);
                rotate.setNode(rect);
                rotate.play(); //inicia rotacion
            }
        });

        buttonRo.setOnAction(event -> {
            //Detiene rotacion
            rotate.stop();
            buttonRo.setDisable(true);
            buttonR.setDisable(false);
        });


        root.getChildren().add(rect);
        root.getChildren().add(buttonBar);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
