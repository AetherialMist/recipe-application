package com.github.aetherialmist.recipe;

import com.github.aetherialmist.recipe.javafx.JavaFxApplication;
import com.github.aetherialmist.recipe.spring.JavaFxSpringContext;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRunner {

    public static void main(String[] args) {
        JavaFxSpringContext context = new JavaFxSpringContext();
        context.registerContextEventsWithJavaFx();
        Application.launch(JavaFxApplication.class, args);
    }
}
