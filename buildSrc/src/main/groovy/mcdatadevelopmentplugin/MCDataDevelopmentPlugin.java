package mcdatadevelopmentplugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Плагин шаблона библиотеки.
 */
public class MCDataDevelopmentPlugin implements Plugin<Project> {
    @Override
    public void apply(@NotNull Project project) {
        project.getTasks().register("buildDataManagerClass", BuildDataManagerClassTask.class);
    }
}
