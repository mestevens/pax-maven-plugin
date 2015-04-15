package ca.mestevens.java;

import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import ca.mestevens.java.pax.Pax;

@Mojo(name = "pax-generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class PaxGenerateSourcesMojo extends AbstractMojo {

	@Parameter
	public List<String> jsonFiles;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		for (String jsonFile : jsonFiles) {
			try {
				Pax paxGenerator = new Pax(jsonFile);
				paxGenerator.generateApi();
			} catch (IOException ex) {
				throw new MojoExecutionException(ex.getMessage());
			}
		}
	}

}
