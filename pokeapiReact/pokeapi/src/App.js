import { useState } from "react";
import "./App.css";

import Buscador from "./contenedor/Buscador";

export const getPokemon = async (nombre) => {
  const request = await fetch("http://localhost:8080/Pokemon/Traer/" + nombre);
  const response = await request.json();
  return response;
};

function App() {
  const [pokemon, setPokemon] = useState({});

  const BuscarPorNombre = nombre =>{
    getPokemon(nombre).then(a=>setPokemon(a))//le indicamos que: lo que nos devuelva se guarde en a y luego lo guarde en pokemon 
  }
    
  console.log(pokemon.sprites?.front_default)
  return(
    <div className="App">
      <Buscador onSubmit={BuscarPorNombre}/>
      {pokemon==null ? null : 
        <div>
            <img src={pokemon.sprites?.front_default} alt=""></img>
            <h2>{pokemon.name}</h2>
            {pokemon.types?.map((datos,index) =>{
                return(<p key={index}>{datos.type.name}</p>)
            })}
            <ul>
                {pokemon.abilities?.map((datos,index) =>{
                return(<li key={index}>{datos.ability.name}</li>)
                })}
            </ul>
        </div>
        }
    </div>
  );
}

export default App;
