package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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

        //Configurando Group and Scene
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Polyglot Sidequest: Thirdly");
        primaryStage.setScene(scene);

        //labels
        Label escalado = new Label("Escalado:");
        final Spinner<Integer> spinnerE = new Spinner<Integer>();
        Label rotacion = new Label("Rotacion:");
        final Spinner<Integer> spinnerR = new Spinner<Integer>();
        Label traslacion = new Label("Traslacion:");
        final Spinner<Integer> spinnerT = new Spinner<Integer>();

        //Numero inicializador del spinner
        final int initialValue = 1;

        // Value factory
        SpinnerValueFactory<Integer> valueFactoryE = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
        SpinnerValueFactory<Integer> valueFactoryR = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
        SpinnerValueFactory<Integer> valueFactoryT = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);

        spinnerE.setValueFactory(valueFactoryE);
        spinnerR.setValueFactory(valueFactoryR);
        spinnerT.setValueFactory(valueFactoryT);

        //Botones de inicio y fin
        Button buttonE = new Button("Iniciar");
        Button buttonR = new Button("Iniciar");
        Button buttonT = new Button("Iniciar");

        Button buttonEs = new Button("Parar");
        Button buttonRo = new Button("Parar");
        Button buttonTr = new Button("Parar");

        //Organizando
        VBox label = new VBox( 30, escalado, rotacion, traslacion );
        VBox spinner = new VBox( 20, spinnerE, spinnerR, spinnerT );
        VBox buttonStart = new VBox( 20, buttonE , buttonR, buttonT );
        VBox buttonStop = new VBox( 20, buttonEs , buttonRo, buttonTr );

        HBox buttonBar = new HBox(5,label,spinner,buttonStart,buttonStop);

        buttonEs.setDisable(false);
        buttonRo.setDisable(false);
        buttonTr.setDisable(false);


        //Crea cuadrado
        Rectangle cuadrado = new Rectangle(200,200,200,200);
        cuadrado.setFill(Color.SKYBLUE);
        cuadrado.setStrokeWidth(5);

        //Inicializando clase RotateTransition para Rotacion
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS); //Eje de rotacion
        rotate.setByAngle(360); //Angulo de rotacion
        rotate.setCycleCount(500); //Conteo de ciclos de rotacion

        //Inicializando clase TranslateTransition para Traslacion
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400); //Cambiando coordenadas en x
        translate.setCycleCount(500); //Conteo de ciclos de rotacion


        //Evento para el boton Escalado
        buttonE.setOnAction(event -> {
        });

        //Evento para el boton Rotacion
        buttonR.setOnAction(event -> {
            buttonR.setDisable(true);
            buttonRo.setDisable(false);

            //Configuracion de rotacion y duracion
            if (valueFactoryR.getValue()==1){
                rotate.setDuration(Duration.millis(3000)); //duracion
                rotate.setAutoReverse(true); //autorotacion en reversa
                rotate.setNode(cuadrado);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==2){
                rotate.setDuration(Duration.millis(2000)); //duracion
                rotate.setAutoReverse(true); //autorotacion en reversa
                rotate.setNode(cuadrado);
                rotate.play();
            }else if(valueFactoryR.getValue()==3){
                rotate.setDuration(Duration.millis(1500)); //duracion
                rotate.setAutoReverse(true); //autorotacion en reversa
                rotate.setNode(cuadrado);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==4){
                rotate.setDuration(Duration.millis(1000)); //duracion
                rotate.setAutoReverse(true); //autorotacion en reversa
                rotate.setNode(cuadrado);
                rotate.play(); //inicia rotacion
            }else if(valueFactoryR.getValue()==5){
                rotate.setDuration(Duration.millis(500)); //duracion
                rotate.setAutoReverse(true); //autorotacion en reversa
                rotate.setNode(cuadrado);
                rotate.play(); //inicia rotacion
            }
        });

        //Evento para detener rotacion
        buttonRo.setOnAction(event -> {
            rotate.stop(); //Detiene rotacion
            buttonRo.setDisable(true);
            buttonR.setDisable(false);
        });

        //Evento para el boton Traslacion
        buttonT.setOnAction(event -> {

            buttonT.setDisable(true);
            buttonTr.setDisable(false);

            //Configuracion de traslacion y duracion
            if (valueFactoryT.getValue()==1){
                translate.setDuration(Duration.millis(3000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==2){
                translate.setDuration(Duration.millis(3000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==3){
                translate.setDuration(Duration.millis(3000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==4){
                translate.setDuration(Duration.millis(3000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==5){
                translate.setDuration(Duration.millis(3000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }
        });

        //Evento para detener rotacion
        buttonTr.setOnAction(event -> {
            translate.stop(); //Detiene rotacion
            buttonTr.setDisable(true);
            buttonT.setDisable(false);
        });


        root.getChildren().add(cuadrado);
        root.getChildren().add(buttonBar);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
