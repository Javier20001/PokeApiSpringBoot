package PokeApi.mx.com.gm.domain.ability;

public class AbylitiesInfo {
    private String short_effect;
    private Language language;

    public String getShort_effect() {
        return this.short_effect;
    }

    public void setShort_effect(String short_effect) {
        this.short_effect = short_effect;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "{" +
            ", short_effect='" + getShort_effect() + "'" +
            "}";
    }

}
