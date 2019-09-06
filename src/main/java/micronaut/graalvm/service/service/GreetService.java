package micronaut.graalvm.service.service;


import io.micronaut.core.io.ResourceResolver;
import io.micronaut.core.io.scan.ClassPathResourceLoader;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class GreetService implements IGreetService {
    private final static String GREET_FILE_PATH = "classpath:hello.txt";

    @Override
    public String sayHello() {
        String greet = "";

        try {
            ClassPathResourceLoader loader = new ResourceResolver().getLoader(ClassPathResourceLoader.class).get();
            Optional<URL> resource = loader.getResource(GREET_FILE_PATH);

            greet = Files
                    .lines(Paths
                           .get(resource
                                .get()
                                .getPath())
                    ).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return greet;
    }



    @Override
    public String prettyJson(String plainJson) {
        Value result = null;
        try (Context context = Context.create("js")) {
            Value parse = context.eval(
                    "js",
                    "JSON.parse");
            Value stringify = context.eval(
                    "js",
                    "JSON.stringify");
            result = stringify
                    .execute(parse.execute(plainJson), null, 2);
        }
        return result.asString();
    }
}
