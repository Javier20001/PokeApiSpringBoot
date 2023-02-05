package PokeApi.mx.com.gm.domain.stat;

public class Stat {
    private String name;

    public Stat(String nombre){
        System.out.println("entre");
        this.abrebiatura(nombre);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }

    public void abrebiatura(String nombre){
        if(nombre.equals("attack")){
            setName("Atk");
        }else if(nombre.equals("defense")){
            setName("Def");
        }else if(nombre.equals("special-attack")){
            setName("SA");
        }else if(nombre.equals("special-defense")){
            setName("SD");
        }else if(nombre.equals("speed")){
            setName("SpD");
        }else if(nombre.equals("hp")){
            setName("HP");
        }
    }

}