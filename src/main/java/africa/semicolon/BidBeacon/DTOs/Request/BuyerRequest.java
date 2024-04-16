package africa.semicolon.BidBeacon.DTOs.Request;

import lombok.Data;

@Data
public class BuyerRequest {
    private String username;
    private String password;
    private String email;
    private String role;
}
