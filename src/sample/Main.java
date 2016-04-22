package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;


    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Blood Bank Management System");

        BorderPane skeleton = new BorderPane();
        skeleton.setStyle("-fx-background-color: transparent;");

         /*Lighting theme*/
        final Lighting lighting = new Lighting();
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        lighting.setLight(light);
        lighting.setSurfaceScale(9.0);
        /*Lighting theme*/

        /*top menu*/
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(30, 0, 0, 300));

        Label title = new Label("SINNVOLL BLOOD BANK MANAGEMENT SYSTEM");
        title.setTextFill(Color.DARKRED);
        title.setFont(Font.font("Ume Gothic", 42));
        title.setEffect(lighting);

        topMenu.getChildren().addAll(title);

         /*end of top menu*/

         /*Left menu*/

        VBox leftMenu = new VBox();
        leftMenu.setPadding(new Insets(150,0,0,300));

        Label l1 = new Label("DONATE");
        l1.setTextFill(Color.DARKRED);
        l1.setFont(Font.font("Ume Gothic", 42));
        l1.setEffect(lighting);
        l1.setPadding(new Insets(0,0,40,0));

        StackPane imgholder = new StackPane();
        Image img = new Image("file:/home/sharang/cleanUp/db.jpg");
        ImageView iv = new ImageView();
        iv.setImage(img);
        iv.setFitWidth(100);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        imgholder.getChildren().add(iv);
        imgholder.setPadding(new Insets(0,0,30,0));

        Button register = new Button("REGISTER");
        register.setOnAction(event -> {
            new NewWindow().RegistrationWindow();
        });
        StackPane bnholder = new StackPane();
        bnholder.getChildren().add(register);

        leftMenu.getChildren().addAll(l1,imgholder,bnholder);

         /*End of Left menu*/

         /*Right menu*/

        VBox rightMenu = new VBox();
        rightMenu.setPadding(new Insets(150,300,0,0));

        Label l2 = new Label("REQUEST");
        l2.setTextFill(Color.DARKRED);
        l2.setFont(Font.font("Ume Gothic", 42));
        l2.setEffect(lighting);
        l2.setPadding(new Insets(0,0,40,0));

        StackPane img2holder = new StackPane();
        Image img2 = new Image("file:/home/sharang/cleanUp/blood2.gif");
        ImageView iv2 = new ImageView();
        iv2.setImage(img2);
        iv2.setFitWidth(100);
        iv2.setFitHeight(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        img2holder.getChildren().add(iv2);
        img2holder.setPadding(new Insets(0,0,30,0));

        Button search = new Button("SEARCH");
        search.setOnAction(event -> {
            new NewWindow().searchWindow();
        });
        StackPane bnholder2 = new StackPane();
        bnholder2.getChildren().add(search);

        rightMenu.getChildren().addAll(l2,img2holder,bnholder2);

         /*End of Right menu*/


         /*Bottom menu*/

        HBox bottomMenu = new HBox();
        bottomMenu.setPadding(new Insets(0, 0, 50, 600));
        Label motto = new Label("SOW.REAP");
        motto.setTextFill(Color.DARKRED);
        motto.setFont(Font.font("Ume Gothic", 42));
        motto.setEffect(lighting);

        bottomMenu.getChildren().addAll(motto);

         /*End of Bottom menu*/

        /*Forming the skeleton Layout*/

        skeleton.setTop(topMenu);
        skeleton.setLeft(leftMenu);
        skeleton.setRight(rightMenu);
        skeleton.setBottom(bottomMenu);

        /*End of skeleton Layout*/

        /*populating scene with skeleton Layout*/
        Scene s = new Scene(skeleton,1920,1080,Color.BLACK);
        /*populating scene with skeleton Layout*/

         /*Adding scene to Window*/
        window.setScene(s);

         /*Showing window*/
        window.show();

        //System.out.println(javafx.scene.text.Font.getFamilies().toString());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
