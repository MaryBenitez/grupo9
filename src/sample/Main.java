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
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.net.ssl.HostnameVerifier;
import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Configurando Group and Scene
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Polyglot Sidequest: Thirdly");
        primaryStage.setScene(scene);

        //Crea cuadrado
        Rectangle cuadrado = new Rectangle(10,100,100,100);
        cuadrado.setFill(Color.SKYBLUE);
        cuadrado.setStrokeWidth(5);

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
        Button buttonE = new Button("Aplicar");
        Button buttonR = new Button("Iniciar");
        Button buttonT = new Button("Iniciar");

        Button buttonRo = new Button("Parar");
        Button buttonTr = new Button("Parar");

        //Organizando
        VBox label = new VBox( 30, rotacion, traslacion, escalado);
        VBox spinner = new VBox( 20, spinnerE, spinnerR, spinnerT);
        VBox buttonStart = new VBox( 20, buttonR, buttonT, buttonE);
        VBox buttonStop = new VBox( 20, buttonRo, buttonTr );

        HBox buttonBar = new HBox(5,label,spinner,buttonStart,buttonStop);

        VBox completo = new VBox(100,buttonBar,cuadrado);

        buttonRo.setDisable(false);
        buttonTr.setDisable(false);

        //Inicializando clase RotateTransition para Rotacion
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS); //Eje de rotacion
        rotate.setByAngle(360); //Angulo de rotacion
        rotate.setCycleCount(500); //Conteo de ciclos de rotacion

        //Inicializando clase TranslateTransition para Traslacion
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400); //Cambiando coordenadas en x
        translate.setCycleCount(500); //Conteo de ciclos de rotacion

        //Creando escalado en 2D
        Scale scale = new Scale();

        //Valores iniciales en x ^ y
        scale.setX(-1.5);
        scale.setY(1.5);


        //Evento para el boton Escalado
        buttonE.setOnAction(event -> {

            //Configuracion de escalado
            if (valueFactoryE.getValue()==1){
                //setting the pivot points along which the scaling is done
                scale.setPivotX(50);
                scale.setPivotY(50);

                //applying transformations on the 2nd circle
                cuadrado.getTransforms().add(scale);
            }else if(valueFactoryE.getValue()==2){
                //setting the pivot points along which the scaling is done
                scale.setPivotX(100);
                scale.setPivotY(100);

                //applying transformations on the 2nd circle
                cuadrado.getTransforms().add(scale);
            }else if(valueFactoryE.getValue()==3){
                //setting the pivot points along which the scaling is done
                scale.setPivotX(150);
                scale.setPivotY(150);

                //applying transformations on the 2nd circle
                cuadrado.getTransforms().add(scale);
            }else if(valueFactoryE.getValue()==4){
                //setting the pivot points along which the scaling is done
                scale.setPivotX(200);
                scale.setPivotY(200);

                //applying transformations on the 2nd circle
                cuadrado.getTransforms().add(scale);
            }else if(valueFactoryE.getValue()==5){
                //setting the pivot points along which the scaling is done
                scale.setPivotX(250);
                scale.setPivotY(250);

                //applying transformations on the 2nd circle
                cuadrado.getTransforms().add(scale);
            }

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
                translate.setDuration(Duration.millis(2000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==3){
                translate.setDuration(Duration.millis(1500)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==4){
                translate.setDuration(Duration.millis(1000)); //duracion
                translate.setAutoReverse(true);
                translate.setNode(cuadrado);
                translate.play(); //inicia traslacion
            }else if(valueFactoryT.getValue()==5){
                translate.setDuration(Duration.millis(500)); //duracion
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


        root.getChildren().add(completo);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
