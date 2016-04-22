package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sharang on 4/22/16.
 */
public class NewWindow {
    int row=1;

    public void RegistrationWindow()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("REGISTER");

        /*Lighting theme*/
        final Lighting lighting = new Lighting();
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        lighting.setLight(light);
        lighting.setSurfaceScale(9.0);
        /*Lighting theme*/

        BorderPane skeleton = new BorderPane();
        skeleton.setStyle("-fx-background-color: transparent;");

        HBox topPanel = new HBox();
        Label title = new Label("REGISTER");
        title.setTextFill(Color.DARKRED);
        title.setFont(Font.font("Ume Gothic", 42));
        title.setEffect(lighting);

        topPanel.setPadding(new Insets(30,0,0,300));
        topPanel.getChildren().addAll(title);


        GridPane form = new GridPane();
        form.setHgap(8);
        form.setVgap(8);
        form.setPadding(new Insets(60,0,0,250));

        Label name = new Label("Name");
        name.setTextFill(Color.WHITE);

        Label address = new Label("Address");
        address.setTextFill(Color.WHITE);

        Label contact = new Label("Contact No");
        contact.setTextFill(Color.WHITE);

        Label bg = new Label("Blood Group");
        bg.setTextFill(Color.WHITE);

        Label plateletCount = new Label("Platelet Count");
        plateletCount.setTextFill(Color.WHITE);

        Label rbcCount = new Label("RBC Count");
        rbcCount.setTextFill(Color.WHITE);

        TextField Entry_name = new TextField();
        TextField Entry_address = new TextField();
        TextField Entry_contact = new TextField();
        TextField Entry_bloodgroup = new TextField();
        TextField Entry_rbc = new TextField();
        TextField Entry_platelet = new TextField();


        GridPane.setConstraints(name,0,0);
        GridPane.setConstraints(address,0,1);
        GridPane.setConstraints(contact,0,2);
        GridPane.setConstraints(bg,0,3);
        GridPane.setConstraints(plateletCount,0,4);
        GridPane.setConstraints(rbcCount,0,5);

        GridPane.setConstraints(Entry_name,1,0);
        GridPane.setConstraints(Entry_address,1,1);
        GridPane.setConstraints(Entry_contact,1,2);
        GridPane.setConstraints(Entry_bloodgroup,1,3);
        GridPane.setConstraints(Entry_platelet,1,4);
        GridPane.setConstraints(Entry_rbc,1,5);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> {
            Database obj = new Database();
            obj.insert(Entry_name.getText(),Entry_address.getText(),Entry_contact.getText(),Entry_bloodgroup.getText(),
                       Entry_platelet.getText(),Entry_rbc.getText());
        });
        GridPane.setConstraints(registerButton,1,6);

        form.getChildren().addAll(name,address,contact,bg,plateletCount,rbcCount, Entry_name,Entry_address,
                                  Entry_contact,Entry_bloodgroup,Entry_platelet,Entry_rbc, registerButton);


        skeleton.setTop(topPanel);
        skeleton.setCenter(form);

        Scene s = new Scene(skeleton,800,400, Color.BLACK);
        window.setScene(s);
        window.showAndWait();

    }

    public void searchWindow()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("RESULTS");

        /*Lighting theme*/
        final Lighting lighting = new Lighting();
        final Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        lighting.setLight(light);
        lighting.setSurfaceScale(9.0);
        /*Lighting theme*/


        BorderPane skeleton = new BorderPane();
        skeleton.setStyle("-fx-background-color: transparent;");

        HBox topPanel = new HBox();
        Label title = new Label("SEARCH RESULTS");
        title.setTextFill(Color.DARKRED);
        title.setFont(Font.font("Ume Gothic", 42));
        title.setEffect(lighting);

        topPanel.setPadding(new Insets(30,0,0,250));
        topPanel.getChildren().addAll(title);

        GridPane form = new GridPane();
        form.setHgap(8);
        form.setVgap(8);
        form.setPadding(new Insets(60,0,0,120));

        Label bloodg = new Label("Enter BloodGroup");
        bloodg.setTextFill(Color.WHITE);
        TextField EntryBloodg = new TextField();
        Button search =new Button("Search");
        search.setOnAction(event -> {
            ResultSet rs = new Database().retrieve(EntryBloodg.getText());
            try {
                while(rs.next())
                {
                    int id = rs.getInt("id");
                    String name= rs.getString("name");
                    String addr= rs.getString("address");
                    String contact= rs.getString("contactno");
                    String bg= rs.getString("bloodgroup");
                    String platelet= rs.getString("platelet");
                    String rbc= rs.getString("rbc");

                    Label l1 = new Label(""+id);
                    l1.setTextFill(Color.WHITE);
                    Label l2 = new Label(name);
                    l2.setTextFill(Color.WHITE);
                    Label l3 = new Label(addr);
                    l3.setTextFill(Color.WHITE);
                    Label l4 = new Label(contact);
                    l4.setTextFill(Color.WHITE);
                    Label l5 = new Label(bg);
                    l5.setTextFill(Color.WHITE);
                    Label l6 = new Label(platelet);
                    l6.setTextFill(Color.WHITE);
                    Label l7 = new Label(rbc);
                    l7.setTextFill(Color.WHITE);

                    GridPane.setConstraints(l1,0,row);
                    GridPane.setConstraints(l2,1,row);
                    GridPane.setConstraints(l3,2,row);
                    GridPane.setConstraints(l4,3,row);
                    GridPane.setConstraints(l5,4,row);
                    GridPane.setConstraints(l6,5,row);
                    GridPane.setConstraints(l7,6,row);
                    form.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7);

                    row+=1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

        GridPane.setConstraints(bloodg,0,0);
        GridPane.setConstraints(EntryBloodg,1,0);
        GridPane.setConstraints(search,2,0);

        form.getChildren().addAll(bloodg,EntryBloodg,search);

        skeleton.setTop(topPanel);
        skeleton.setCenter(form);

        Scene s = new Scene(skeleton,800,800, Color.BLACK);
        window.setScene(s);
        window.showAndWait();
    }
}
