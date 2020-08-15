import React ,{useEffect} from 'react'
import { useContext } from 'react'
import { Login } from '../login.screen/login.screen'

import { useApi } from '../../../hooks/api.hook'
import { useState } from 'react'
export const Mechanics = () => {
    const backEnd = useApi();
    const [name,setName] = useState()
    let [mechanics,setMechanics] = useState([])
    useEffect( () => {
        setsMechanics()
    }, [])

    async function setsMechanics(){
        let response = await backEnd.mechanics()
       setMechanics(response)
    }

    let mechanicsList = mechanics.map(mechanic =>{
        return (<div>
            <div className='booking-date-container'>
                <div></div>
        <div>{mechanic.namemech}</div>
                <a onClick={() => backEnd.deleteMechanic(mechanic)} className='booking-cancel'>Delete</a>
            </div>
            
            </div>)
    })
    return (
        <div className='booking-container'>
            <div className='booking-list-container'>
                <div className="upcoming-container">
                <div>UPCOMING APPOINTMENTS</div>
                     <div>{mechanicsList}</div>
                </div>
            </div>
            <div className='booking-create-container'>
                <div>Register</div>
                <div>
                    <div className='booking-inputs'>

                    <div>
                    <input onChange={event => setName(event.target.value)}></input>
                    <button onClick={()=>backEnd.createMechanic({"idmech":null,"namemech":name})}>SUBMIT</button>
                    </div>
                    </div>
                    
                </div>
            </div>
        </div>
    )
}
