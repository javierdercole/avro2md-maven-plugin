package org.javierdercole;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UpdateMarkdownTest {
    @Test
    public void firstTest() throws MojoExecutionException {
        UpdateMarkdown mojo = new UpdateMarkdown();
        mojo.execute();
        assertTrue(false);
    }
}
