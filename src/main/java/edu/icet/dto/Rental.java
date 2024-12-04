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
    private Integer rentalId;
    private String rentaldate;
    private String returndate;
    private String DueDate;
    private String fine;
    private String totalcost;
}
