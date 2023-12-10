package com.github.aetherialmist.recipe.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class JavaFxApplication extends Application {

    private static final List<Consumer<Application>> initializers = new ArrayList<>();
    private static final List<Consumer<Stage>> stagePostProcessors = new ArrayList<>();
    private static final List<Consumer<Application>> closers = new ArrayList<>();

    public static void addInitializer(Consumer<Application> consumer) {
        initializers.add(consumer);
    }

    public static void addStagePostProcessor(Consumer<Stage> consumer) {
        stagePostProcessors.add(consumer);
    }

    public static void addCloser(Consumer<Application> consumer) {
        closers.add(consumer);
    }

    @Override
    public void init() {
        publishEvent(this, initializers);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(true);
        stage.setTitle("Recipe App");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/recipe-app.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.getIcons().add(new Image("/Pineapple_0.PNG"));

        publishEvent(stage, stagePostProcessors);

        stage.show();
    }

    @Override
    public void stop() {
        publishEvent(this, closers);
        Platform.exit();
    }

    private <T> void publishEvent(T event, List<Consumer<T>> consumers) {
        for (Consumer<T> consumer : consumers) {
            try {
                consumer.accept(event);
            } catch (Exception e) {
                log.error("Consumer failed to process event.", e);
            }
        }
    }

}
