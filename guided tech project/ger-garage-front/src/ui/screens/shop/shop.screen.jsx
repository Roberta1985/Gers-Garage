import React,{useState,useEffect} from 'react'
import { useApi } from '../../../hooks/api.hook'
 import './shop.screen.css'
export const Shop = () => {
    const backEnd = useApi()
    const [item,setItem] = useState([])
    useEffect(() => {
        setItems()
        
    }, [])
    async function setItems(){
        const response = await backEnd.items()
        console.log(response)
        setItem(response.data)
        
    }
    let itemlist = item.map(element =>{
        return (<div className='items-container'>
                <div>{element.nameitem}</div>
                <div>{element.price}</div>
        </div>)
    })
    return (
        <div className='shop-container'>
            {itemlist}
        </div>
    )
}
