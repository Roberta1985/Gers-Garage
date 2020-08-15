import React ,{useEffect} from 'react'
import { useContext } from 'react'
import { Login } from '../login.screen/login.screen'

import { useApi } from '../../../hooks/api.hook'
import { useState } from 'react'
export const AdminShop = () => {
    const backEnd = useApi();
    const [name,setName] = useState()
    const [price,setPrice] = useState()
    const [itens,setItens] = useState([])
    useEffect( () => {
        setsItems()
    }, [])

    async function setsItems(){
        let response = await backEnd.items()
       setItens(response.data)
    }

    let itemsList = itens.map(item =>{
        return (<div>
            <div className='booking-date-container'>
                <div></div>
        <div>{item.nameitem}</div>
                <a onClick={() => backEnd.deleteItem(item)} className='booking-cancel'>Delete</a>
            </div>
            
            </div>)
    })
    return (
        <div className='booking-container'>
            <div className='booking-list-container'>
                <div className="upcoming-container">
                <div>UPCOMING APPOINTMENTS</div>
                     <div>{itemsList}</div>
                </div>
            </div>
            <div className='booking-create-container'>
                <div>Register</div>
                <div>
                    <div className='booking-inputs'>

                    <div>
                    <input onChange={event => setName(event.target.value)}></input>
                    <input type='number'  onChange={event => setPrice(event.target.value)}></input>
                    <button onClick={()=>backEnd.createItem({"idItem":null,"nameitem":name,"price":price})}>SUBMIT</button>
                    </div>
                    </div>
                    
                </div>
            </div>
        </div>
    )
}
