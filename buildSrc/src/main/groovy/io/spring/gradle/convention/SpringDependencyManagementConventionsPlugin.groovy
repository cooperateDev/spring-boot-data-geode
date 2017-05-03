/*
 * Copyright 2022-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.spring.gradle.convention

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Applies and configures the Spring Gradle {@link DependencyManagementPlugin}.
 *
 * Additionally, if a {@literal gradle/dependency-management.gradle} file is present in a Gradle {@link Project},
 * then this file will be automatically applied in order to configure {@link Project} additional dependencies.
 *
 * @author Rob Winch
 * @author John Blum
 * @see org.gradle.api.Plugin
 * @see org.gradle.api.Project
 * @see org.gradle.api.plugins.PluginManager
 */
class SpringDependencyManagementConventionsPlugin implements Plugin<Project> {

    static final String DEPENDENCY_MANAGEMENT_RESOURCE = "gradle/dependency-management.gradle"

    @Override
    void apply(Project project) {

        applyAndConfigureDependencyManagementPlugin(project)
        applyDependencyManagementResources(project)
    }

    private void applyAndConfigureDependencyManagementPlugin(Project project) {

        project.getPluginManager().apply(DependencyManagementPlugin)

        project.dependencyManagement {
            resolutionStrategy {
                cacheChangingModulesFor 0, "seconds"
            }
        }
    }

    @SuppressWarnings("all")
    private void applyDependencyManagementResources(Project project) {

        File rootDir = project.rootDir

        List<File> dependencyManagementFiles = [ project.rootProject.file(DEPENDENCY_MANAGEMENT_RESOURCE) ]

        for (File dir = project.projectDir; dir != rootDir; dir = dir.parentFile) {
            dependencyManagementFiles.add(new File(dir, DEPENDENCY_MANAGEMENT_RESOURCE))
        }

        dependencyManagementFiles.each { file ->
            if (file.exists()) {
                project.apply from: file.absolutePath
            }
        }
    }
}
