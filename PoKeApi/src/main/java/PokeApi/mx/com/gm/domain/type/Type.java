package PokeApi.mx.com.gm.domain.type;

public class Type {
    private String name;
    private String color;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            " color='" + getColor() + "'" +
            "}";
    }

}
