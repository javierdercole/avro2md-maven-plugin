# avro2md-maven-plugin
Convert AVRO schemas to markdown, so it could be used as functional documentation by non technical users


# How to use

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.javierdercole</groupId>
            <artifactId>avro2md-maven-plugin</artifactId>
            <version>1.0</version>
            <executions>
                <execution>
                    <phase>compile</phase>
                    <goals>
                        <goal>update-md</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
The plugin will run on compile

# How to test
## Unit testing
Just compile or run test
```bash
mvn test
```

## Integration Testing
Compile and install the plugin on your local repo, and then run IT test using maven verify:
```bash
mvn clean install
mvn verify
```

