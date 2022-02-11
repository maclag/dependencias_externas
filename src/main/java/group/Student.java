package group;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {

    private String name;

    @Override
    public String toString() {
        return "Nome: " + this.name;
    }

}
