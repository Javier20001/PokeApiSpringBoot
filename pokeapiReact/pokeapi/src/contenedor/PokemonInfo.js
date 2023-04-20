import React, { Fragment } from "react";
import { Line } from "rc-progress";
import "../styles/PokemonInfo.css";

export const PokemonInfo = ({ pokemon }) => {
  
  if (!pokemon) {
    return null; //si el pokemon es vacio entonces no hace una verga
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
      <div className="wall" />
      <p className="pokemonTypeTittle">Pokemon Types</p>
      <ul className="pokemonTypesList">
        {pokemon.types?.map((datos) => (
          <li
            className="typesItems"
            style={{ backgroundColor: datos.type.color }}
          >
            {datos.type.name}
          </li> // los return flash es cuando solo tenes que retornar en una funcion fecha solo una linea de codigo
        ))}
      </ul>

      <div className="wall" />
      <table className="pokemonTableAbilities">
        <thead>
          <tr >
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {pokemon.abilities?.map((datos, index) => {
            return (
              <>
                <tr className="pokemonRowAbility">
                  <td >
                    <div className="abilitiesItems">
                      {datos.ability.name}
                    </div>
                  </td>
                  {datos.ability.effect_entries?.map((data) => {
                    return data.language.name === "en" ? (
                      <td>{data.short_effect}</td>
                    ) : null;
                  })}
                </tr>
              </>
            );
          })}
        </tbody>
      </table>

      <div className="wall" />
      <p className="pokemonTypeTittle">Pokemon Stats</p>
      <div className="pokemonStatsList">
        {pokemon.stats?.map((datos, index) => {
          return (
            <>
              <div className="pokemonStatContainer">
                <p className="statName">{datos.stat.name}</p>
                <Line
                  className="pokemonStatsItem"
                  percent={datos.base_stat}
                  strokeWidth={3}
                  trailWidth={2}
                  strokeColor={pokemon.color}
                />
              </div>
            </>
          );
        })}
      </div>
    </div>
  );
};
