package nmit03.nmit03e05.domain;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Movie {
    @NonNull private String name; 
    private byte votes; // The type of data depends on how many people vote, I choose byte because it's for my personal use

    public Movie(String name){
        this.name = name; 
        votes = 0; 
    }
}
