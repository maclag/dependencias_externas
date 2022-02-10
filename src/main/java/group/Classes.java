package group;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Classes {

    JAVA("Java"),
    BD("Banco de Dados");

    private final String name;

    @Override
    public String toString() {
        return this.name;
    }
}
