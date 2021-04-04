package org.javierdercole;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * Base for our avro2md mojos
 */
public abstract class AbstractAvro2mdMojo extends AbstractMojo {

    /**
     * Source dir for all avro files
     */
    @Parameter(
            property = "sourceDirectory",
            defaultValue = "${basedir}/src/main/avro",
            required = true)
    protected File sourceDirectory;

    /**
     * Location of the file.
     */
    @Parameter(
            property = "outputDirectory",
            defaultValue = "${project.build.directory}",
            required = true)
    protected File outputDirectory;

    /**
     * Reference to the maven project. Required to get data from maven-avro-plugin
     */
    @Parameter(
            defaultValue = "${project}",
            readonly = true,
            required = true
    )
    protected MavenProject mavenProject;

    @Parameter(
            defaultValue = "${session}",
            readonly = true,
            required = true
    )
    protected MavenSession mavenSession;

    /**
     * List of files to converto to markdown
     */
    @Parameter
    protected String[] imports;

}
