import React, {useState} from "react"; //el useState es un hooks

function Buscador({onSubmit}){
    const [nombre, setNombre] = useState("");

    const manejarCambio = e =>{
        setNombre(e.target.value)
    }

    const enviarNombre = e =>{
        e.preventDefault(); //evita que se recarge la pagina de nuevo cuando se hace un submit
        onSubmit(nombre);
    } 
    
    return(
        <form className="formularioContenedor" onSubmit={enviarNombre}>
            <div className='contenedorAgregar'>
                <input className='inputAgragar' type="text" placeholder="Escribir una tarea" onChange={manejarCambio} value={nombre}></input>
                {/* el onChange llamara a la funcion cada vez que se haga un cambio en el input*/}
                <button className='buttonAgragar' onClick={enviarNombre}>Buscar Pokemon</button>
            </div>
        </form>
    );
}

export default Buscador;