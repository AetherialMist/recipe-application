package com.github.aetherialmist.recipe.spring;

import com.github.aetherialmist.recipe.SpringRunner;
import com.github.aetherialmist.recipe.javafx.JavaFxApplication;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * Is only created as a Bean so the DeferredLog can reply messages
 * once Spring is ready. All logic of this class is called BEFORE
 * Spring or JavaFX is initialized, and from a purely static context.
 */
@Slf4j
@Component
public class JavaFxSpringContext {

    private ConfigurableApplicationContext context;
    private final DeferredLog deferredLog = new DeferredLog();

    public void registerContextEventsWithJavaFx() {
        registerSpringContextInitialization();
        registerStageReadyEventPublisher();
        bindSpringContextCloseToJavaFxClose();
    }

    /**
     * Create the Spring Context
     */
    private void registerSpringContextInitialization() {
        Consumer<Application> consumer = application -> {
            // Create Beans from JavaFX instances.
            ApplicationContextInitializer<GenericApplicationContext> fxBeanInitializer = applicationContext -> {
                applicationContext.registerBean(Application.class, () -> application);
                applicationContext.registerBean(Application.Parameters.class, application::getParameters);
                applicationContext.registerBean(HostServices.class, application::getHostServices);
            };

            this.context = new SpringApplicationBuilder()
                .sources(SpringRunner.class) // Class annotated with SpringBootApplication
                .initializers(fxBeanInitializer)
                .run(application.getParameters().getRaw().toArray(new String[0]));

            // When JavaFX is instantiated
            // Then the Spring context is instantiated in the lines above
            // And cached logs can be replayed safely to the context
            deferredLog.replayTo(JavaFxSpringContext.class);
        };

        JavaFxApplication.addInitializer(consumer);
        deferredLog.info("Registered Spring context to JavaFX.");
    }

    private void registerStageReadyEventPublisher() {
        Consumer<Stage> consumer = stage -> context.publishEvent(new StageReadyEvent(stage));
        JavaFxApplication.addStagePostProcessor(consumer);
        deferredLog.info("Registered 'Stage ready' event publisher.");
    }

    private void bindSpringContextCloseToJavaFxClose() {
        Consumer<Application> consumer = application -> {
            log.info("Closing application.");
            context.close();
        };
        JavaFxApplication.addCloser(consumer);
        deferredLog.info("Binding Spring context.close() to JavaFX application.close().");
    }

}
