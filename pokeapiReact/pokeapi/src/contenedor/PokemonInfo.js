import React from "react";
import "../styles/PokemonInfo.css"

export const PokemonInfo = ({pokemon}) => {

    console.log("hola",pokemon);

  if (!pokemon) {
    return null;//si el pokemon es vacio entonces no hace una verga 
  }

  return (
    <div>
      <div
        className="contenedorImagenPokemon"
        style={{ backgroundColor: pokemon.color }}
      >
        <img
          className="imagenPokemon"
          src={pokemon.sprites?.front_default}
          alt=""
        />
      </div>
      <h2>{pokemon.name}</h2>
      <div className="wall"/>
      <p className="pokemonTypeTittle">Pokemon Types</p>
      <ul className="pokemonTypesList">
        {pokemon.types?.map((datos, index) => (
          <li className="typesItems" key={index} style={{backgroundColor : datos.type.color}}>{datos.type.name}</li> // los return flash es cuando solo tenes que retornar en una funcion fecha solo una linea de codigo
        ))}
      </ul>
      <div className="wall"/>
      <p className="pokemonTypeTittle" >Pokemon Abilities</p>
      <ul className="pokemonAbilitiesList">
        {pokemon.abilities?.map((datos, index) => (
          <li key={index}>{datos.ability.name}</li>
        ))}
      </ul>
    </div>
  );
};
