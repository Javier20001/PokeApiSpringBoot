package PokeApi.mx.com.gm.domain.ability;

public class PokemonAbilities{

    private int slot;
    private Ability ability;

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Ability getAbility() {
        return this.ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    
    @Override
    public String toString() {
        return "{" +
            " slot='" + getSlot() + "'" +
            ", ability='" + getAbility() + "'" +
            "}";
    }

}
