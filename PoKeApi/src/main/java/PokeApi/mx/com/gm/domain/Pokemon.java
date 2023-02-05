package PokeApi.mx.com.gm.domain;

import java.util.List;

import PokeApi.mx.com.gm.domain.stat.PokemonStats;
import PokeApi.mx.com.gm.domain.type.PokemonTypes;
import PokeApi.mx.com.gm.domain.ability.PokemonAbilities;
import PokeApi.mx.com.gm.domain.sprite.Sprite;

public class Pokemon {
    private String name;
    private int id;
    private int weight;
    private int base_experience;
    private List<PokemonAbilities> abilities;
    private List<PokemonTypes> types;
    private List<PokemonStats> stats;
    private Sprite sprites;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonAbilities> getAbilities() {
        return this.abilities;
    }

    public void setAbilities(List<PokemonAbilities> abilities) {
        this.abilities = abilities;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBase_experience() {
        return this.base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }


    public List<PokemonTypes> getTypes() {
        return this.types;
    }

    public void setTypes(List<PokemonTypes> types) {
        this.types = types;
    }    


    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Sprite getSprites() {
        return this.sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }


    public List<PokemonStats> getStats() {
        return this.stats;
    }

    public void setStats(List<PokemonStats> stats) {
        this.stats = stats;
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
            ", id='" + getId() + "'" +
            ", base_experience='" + getBase_experience() + "'" +
            ", abilities='" + getAbilities() + "'" +
            ", types='" + getTypes() + "'" +
            ", weight='" + getWeight() + "'" +
            ", Sprites='" + getSprites() + "'" +
            ", Stats='" + getStats() + "'" +
            ", color='" + getColor() + "'" +
            "}";
    }
}
    
