# BlueBrick4J

A reader for *.bbm files generated from the BlueBrick LEGO Layout Editor, using the JAXB library.

Takes *.bbm files as inputs and from it creates a Java object structure.

## Example usage
Here's a quick reference on how to use the parser to add all the <Brick> elements in a .bbm file into an ArrayList in Java.

```java
import bluebrick4j.conversion.BbmParser;
import bluebrick4j.model.*

public class Demo {

  public static void main(String[] args) {
    Map map = BbmParser.loadMapFromFile("/path/to/map.bbm");
      List<Brick> bricks = new ArrayList<>();
      
      for (Layer layer : map.getLayers().getLayers()) {
        if (layer.getBricks() != null) {
          layer.getBricks().getBricks().forEach((b) -> bricks.add(b))
        }
      }
    }
}
```
