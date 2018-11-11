package i3.i3configmap.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class i3Controller {
	@Value("${greeter.message}")
    private String greeterMessageFormat;
    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        System.out.println("Prefix :"+ prefix+" and User:"+ user);
        if (prefix == null) {
            prefix = "Hello!";
        }
 
        return String.format(greeterMessageFormat, prefix, user);
    }
}
