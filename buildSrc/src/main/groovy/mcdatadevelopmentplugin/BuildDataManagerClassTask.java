package mcdatadevelopmentplugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BuildDataManagerClassTask extends DefaultTask {
    @TaskAction
    public void run() {
        File sourceCodeDirectory = new File(getProject().getProjectDir(), "src/main/java/ru/vladislav117/mcdata");

        // TODO: Move imports to JavaWriter methods

        String sourceCode = "";
        sourceCode += "package ru.vladislav117.mcdata;\n\n";
        sourceCode += """
                import org.bukkit.NamespacedKey;
                import org.bukkit.persistence.PersistentDataContainer;
                import org.bukkit.persistence.PersistentDataType;
                import org.jetbrains.annotations.Nullable;
                import ru.vladislav117.mcdata.error.DataManagerKeyError;
                import ru.vladislav117.mcdata.error.DataManagerTypeError;
                
                """;

        DataManagerClass variantClass = new DataManagerClass();
        sourceCode += variantClass.build(0);

        try {
            com.google.common.io.Files.write(sourceCode.getBytes(StandardCharsets.UTF_8), new File(sourceCodeDirectory, "DataManager.java"));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
