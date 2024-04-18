package africa.semicolon.BidBeacon.Controller;

import africa.semicolon.BidBeacon.DTOs.Request.RegisterRequest;
import africa.semicolon.BidBeacon.DTOs.Response.UserRegisterResponse;
import africa.semicolon.BidBeacon.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class BuyerController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        UserRegisterResponse registerResponse = new UserRegisterResponse
    }
}

