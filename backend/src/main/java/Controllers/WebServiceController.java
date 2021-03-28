package Controllers;

import Services.CompanyService;
import Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {

    private UserService userService = new UserService();

    private CompanyService companyService = new CompanyService();

    @GetMapping("/level1")
    public String callLevel2() {
        return "Call to WS1";
    }

    @GetMapping("/level2")
    public String callLevel1() {
        return "Call to WS2";
    }
}