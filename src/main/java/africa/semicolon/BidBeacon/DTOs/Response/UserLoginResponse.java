package africa.semicolon.BidBeacon.DTOs.Response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private int id;
    private String username;
    private String email;
    private String role;
    private boolean paymentStatus;
}
