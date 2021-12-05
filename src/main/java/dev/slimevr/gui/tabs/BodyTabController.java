package dev.slimevr.gui.tabs;

import dev.slimevr.gui.MainStage;
import dev.slimevr.gui.dialogs.AutoConfigurationDialog;
import dev.slimevr.gui.views.SkeletonConfigView;
import dev.slimevr.gui.views.SkeletonDataListView;
import io.eiren.vr.Main;
import io.eiren.vr.VRServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class BodyTabController {

	@FXML
	VBox bodyItems;
	@FXML
	VBox skeletonData;

	private VRServer server;

	public BodyTabController() {
		this.server = Main.vrServer;
	}

	@FXML
	public void initialize() {
		initSkeletonConfigList();
		initSkeletonDataList();
	}



	private void initSkeletonConfigList() {
		SkeletonConfigView skeletonConfigView = new SkeletonConfigView(server);
		bodyItems.getChildren().add(skeletonConfigView);
	}

	private void initSkeletonDataList() {
		SkeletonDataListView skeletonDataListView = new SkeletonDataListView(server);
		skeletonData.getChildren().add(skeletonDataListView);
	}

	@FXML
	public void openAutoConfigurationPressed(ActionEvent actionEvent) {
		openAutoConfiguration();
	}

	private void openAutoConfiguration() {
		FXMLLoader fxmlLoader = new FXMLLoader(getResource("/dialogs/autoConfigurationDialog.fxml"));
		Stage stage = new Stage();
		//AutoConfigurationDialog autoConfigurationDialog = new AutoConfigurationDialog(server,stage);
		//fxmlLoader.setController(autoConfigurationDialog);
		// fxmlLoader.setController(autoConfigurationDialog);
		fxmlLoader.setResources(ResourceBundle.getBundle("localization_files/LangBundle", new Locale("en", "EN")));
		Scene scene = null;
		try {

			scene = new Scene(fxmlLoader.load());
			AutoConfigurationDialog controller = fxmlLoader.getController();
			controller.init(server,stage);
			stage.setScene(scene);
			stage.setTitle("Skeleton Auto-Configuration");
			stage.setResizable(false);
			stage.centerOnScreen();
			// stage.initStyle(StageStyle.UNDECORATED);

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}


	/*	stage.setTitle("AutoBoneWindow");
		stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon256.png"))));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();*/

	}

}
