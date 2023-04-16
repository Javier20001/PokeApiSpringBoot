import React from "react"

export const Error = ({error}) =>{
    return(
        <div>
            {error === 500 ? 
                <p>Pusiste mal el nombre volve a intentarlo uwu</p>
                :
                <p>Otra Wea paso, dislculpa -n-</p>
            }
        </div>
    );
};