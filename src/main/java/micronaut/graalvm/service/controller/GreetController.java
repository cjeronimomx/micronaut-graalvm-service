package micronaut.graalvm.service.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import micronaut.graalvm.service.service.IGreetService;

import javax.inject.Inject;

@Controller("greet")
public class GreetController {
    @Inject
    private IGreetService greetService;


    public GreetController(IGreetService greetService) {
        this.greetService = greetService;
    }



    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return greetService.sayHello();
    }



    @Post("/prettyjson")
    @Produces(MediaType.TEXT_PLAIN)
    public String prettyJson(@Body String json) {
        return greetService.prettyJson(json);
    }
}