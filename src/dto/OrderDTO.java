package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO {    
    
    private long id;
    private String orderList;
    private int ordernum;
    private int price;
    private String date; //Timestamp -> String 으로 바꿈.
    private String userId;
}
