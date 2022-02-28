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

    @Test
    public void testGeneralFile() throws IOException{
        Path fileName = Path.of("testGeneral.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("", "link"), links);
    }

    // @Test
    // public void testSnippet1() throws IOException{
    //     Path fileName = Path.of("snippet1.md");
	//     String contents = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(contents);

    //     assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    // }

    // @Test
    // public void testSnippet2() throws IOException{
    //     Path fileName = Path.of("snippet2.md");
	//     String contents = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(contents);

    //     assertEquals(List.of("a.com", "a.com(())", "example.com"), links);
    // }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }
}
