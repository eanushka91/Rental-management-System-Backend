package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rental {
    private Integer rentalid;
    private String rentaldate;
    private String returndate;
    private String duedate;
    private String totalcost;
}
