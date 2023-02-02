package PokeApi.mx.com.gm.domain.sprite;

public class Sprite {
    private String back_default;
    private String front_default;


    public String getBack_default() {
        return this.back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getFront_default() {
        return this.front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }


    @Override
    public String toString() {
        return "{" +
            " back_default='" + getBack_default() + "'" +
            ", front_default='" + getFront_default() + "'" +
            "}";
    }
}
