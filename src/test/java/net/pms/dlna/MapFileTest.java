package net.pms.dlna;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import net.pms.PMS;
import net.pms.configuration.MapFileConfiguration;
import net.pms.configuration.RendererConfiguration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

public class MapFileTest {
	private final Class<?> CLASS = MapFileTest.class;

	/**
	 * Set up testing conditions before running the tests.
	 */
	@Before
	public final void setUp() {
		// Silence all log messages from the PMS code that is being tested
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		context.reset();
	}

	@Test
	public final void testIsRefreshNeededWhenEmptyFolderBecomesNotEmpty() throws Exception {
/*		MapFile rootMap = new MapFile();		
		List<DLNAResource> resources = new ArrayList<>();
		File emptyFolderTestLocation = FileUtils.toFile(CLASS.getResource("../dlna/emptyFolderTest/"));
		resources.add(new RootFolder());
		rootMap.setChildren(resources);		*/
		RendererConfiguration config = new RendererConfiguration();
		List<DLNAResource> files = PMS.get().getRootFolder(config).getDLNAResources(
				"abc",
				false,
				0,
				10,
				config,
				""
			);
		MapFile rootMap = new MapFile();
		rootMap.setChildren(files);
	}

}
