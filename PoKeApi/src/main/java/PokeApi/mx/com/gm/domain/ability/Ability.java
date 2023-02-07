package PokeApi.mx.com.gm.domain.ability;

import java.util.List;

public class Ability {
    private String name;
    private String url;
    private List<AbylitiesInfo> effect_entries;

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public List<AbylitiesInfo> getEffect_entries() {
        return this.effect_entries;
    }

    public void setEffect_entries(List<AbylitiesInfo> effect_entries) {
        this.effect_entries = effect_entries;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            " url='" + getUrl() + "'" +
            " Lista de Efectos='" + getEffect_entries() + "'" +
            "}";
    }
}
