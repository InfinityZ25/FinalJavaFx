package us.jcedeno.college.aj.objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class SWChar {
    String name;

    public String toString(){
        return name;
    }
}
