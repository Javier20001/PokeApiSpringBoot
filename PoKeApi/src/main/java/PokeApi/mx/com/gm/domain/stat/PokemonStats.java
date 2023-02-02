package PokeApi.mx.com.gm.domain.stat;

public class PokemonStats {
    private int base_stat;
    private Stat stat;

    public int getBase_stat() {
        return this.base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public Stat getStat() {
        return this.stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "{" +
            " base_stat='" + getBase_stat() + "'" +
            ", stat='" + getStat() + "'" +
            "}";
    }

}
