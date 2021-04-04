package org.javierdercole;


import org.apache.avro.Schema;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which creates or update the markdown avro documentation
 */
@Mojo(name = "update-md", defaultPhase = LifecyclePhase.COMPILE)
public class UpdateMarkdownMojo extends AbstractAvro2mdMojo {

    private Schema.Parser schemaParser = new Schema.Parser();

    public void execute() throws MojoExecutionException {
        getLog().debug("sourceDirectory: " + sourceDirectory);
        getLog().debug("outputDirectory: " + outputDirectory);
        getLog().debug("mavenProject: " + mavenProject);
        getLog().debug("mavenSession: " + mavenSession);

        if (imports == null) {
            throw new MojoExecutionException("No imports found... ");
        }

        for (String importedFiles : imports) {
            getLog().debug("Importing " + importedFiles);
        }

        //check if source file exists
        if (sourceDirectory == null || !sourceDirectory.isFile())
            throw new MojoExecutionException("Invalid sourceDirectory parameter specified... cannot continue. " + sourceDirectory);

        try {
            Schema schema = schemaParser.parse(sourceDirectory);
        } catch (IOException e) {
            throw new MojoExecutionException("Error parsing schema", e);
        }
        File f = outputDirectory;

        if (!f.exists()) {
            f.mkdirs();
        }

        File touch = new File(f, "touch.txt");

        FileWriter w = null;
        try {
            w = new FileWriter(touch);

            w.write("touch.txt");
        } catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}
