import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    // new comments

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testDefaultFile() throws IOException{
        Path filename = Path.of("test-file.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of("https://something.com", "some-page.html");
        assertEquals(expectedLinks, links);
    }

    @Test
    public void testImageURLFile() throws IOException{
        Path filename = Path.of("image-url.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, links);
    }

    @Test
    public void testNoLinkFile() throws IOException{
        Path filename = Path.of("no-link.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of();
        assertEquals(expectedLinks, links);
    }
}
