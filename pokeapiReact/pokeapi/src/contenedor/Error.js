import React from "react"
import rotom from "../missingno.png"
import "../styles/Error.css"

export const Error = ({error}) =>{
    return(
        <div>
            {error === 500 ? 
                <>  
                    <div>
                        <h2>Pusiste mal el nombre o el ID <p>?</p>, intentalo de nuevo</h2>
                        
                        <img className="imagenError" src={rotom} alt="Imagen de RotomDex" />
                    </div>
                </>
                :
                <p>Otra Wea paso, dislculpa -n-</p>
            }
        </div>
    );
};