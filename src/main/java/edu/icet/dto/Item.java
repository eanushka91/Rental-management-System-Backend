package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Integer itemid;
    private String itemname;
    private String rentalperday;
    private String fineperday;
    private String availability;
}
