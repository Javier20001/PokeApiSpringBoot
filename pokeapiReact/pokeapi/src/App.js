import { useState } from "react";
import "./App.css";

import Buscador from "./contenedor/Buscador";
import { PokemonInfo } from "./contenedor/PokemonInfo";

export const getPokemon = async (nombre) => {
  const request = await fetch("http://localhost:8080/Pokemon/Traer/" + nombre);
  const response = await request.json();
  return response;
};

function App() {
  const [pokemon, setPokemon] = useState(null);

  const BuscarPorNombre = async(nombre) => {
    const rest = await getPokemon(nombre);//le indicamos que: lo que nos devuelva se guarde en a y luego lo guarde en pokemon
    setPokemon(rest);
    console.log(rest);
  };

  console.log(pokemon);

  return (
    <div className="App">
      <Buscador onSubmit={BuscarPorNombre} />
      <PokemonInfo pokemon={pokemon} />
    </div>
  );
}

export default App;
