import { useState } from "react";
import "./App.css";

import Buscador from "./contenedor/Buscador";
import { Error } from "./contenedor/Error";
import { PokemonInfo } from "./contenedor/PokemonInfo";

export const getPokemon = async (nombre) => {
  try {
    const request = await fetch("http://localhost:8080/Pokemon/Traer/" + nombre);
    if(request.status !== 200) throw request;
    const response = await request.json();
    return response;
  } catch (error) {
    throw error;
  }
};

function App() {
  const [pokemon, setPokemon] = useState(null);
  const [error, setError] =  useState(0)

  const BuscarPorNombre = async(nombre) => {
    try {
      const rest = await getPokemon(nombre);//le indicamos que: lo que nos devuelva se guarde en a y luego lo guarde en pokemon
      setPokemon(rest);
    } catch (error) {
      setError(error.status);
      // console.log(error.status);
    }
  };

  console.log(pokemon);
  // console.log(error);

  return (
    <div className="App">
      <Buscador onSubmit={BuscarPorNombre} />
      {error !== 500?
        <PokemonInfo pokemon={pokemon} />
        :
        <Error error={error}/>
      }
      
      

    </div>
  );
}

export default App;
