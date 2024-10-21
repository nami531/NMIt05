package nmit03.nmit03bookadvisor.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Form {
    private String name; 
    private String email; 
    private Contact contactType; 
    private String comments; 
    private boolean conditionsAccepted; 
    
}
