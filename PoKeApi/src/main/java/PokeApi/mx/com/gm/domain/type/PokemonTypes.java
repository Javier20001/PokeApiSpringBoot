package PokeApi.mx.com.gm.domain.type;

public class PokemonTypes {
    private int slot;
    private Type type;


    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "{" +
            " slot='" + getSlot() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}