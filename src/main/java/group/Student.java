package group;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Student {

    private String name;

    @Override
    public String toString() {
        return this.name;
    }

}
