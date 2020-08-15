import axios from 'axios'
import {useCallback} from 'react'
const host = axios.create({
    baseURL:'http://localhost:8080/'
}
)
let user
export function useApi(){
    
    async function login(username,pass){
        const response = await host.get(`customer/signin`, {params:{
            username: username,
            password: pass
        }})
        if(response.data != null){
            user = response.data
            console.log(user)
            return response
        }else{
            return 'error'
        }
    }
    async function loginAdmin(username,pass){
        const response = await host.get(`customer/login-admin`, {params:{
            login: username,
            password: pass
        }})
        if(response.data != null){
            user = response.data
            console.log(user)
            return response
        }else{
            return 'error'
        }
    }
    async function bookings(){
        console.log(user)
        const response = await host.get(`appointment/customer-appointments/${user.idCust}`)

        return response.data
    }
    async function bookingsAll(){
        console.log(user)
        const response = await host.get(`appointment/all/`)

        return response.data
    }
    async function register(name,user,email,phone,pw){
        const response = await host.post(`customer/signup`, {
            "pw": pw,
            "fullName": name,
            "email": email,
            "phoneNum": phone,
            "adminAccess": false,
            "username": user,
            "idcust": null
        })
        return response
    }
    async function createBooking(vehicle,cmt,date){
        vehicle.customer = user
        const response = await host.post('appointment/new',vehicle,{params:{cmt:cmt,date:date}})
    }
    async function createMechanic(mechanic){
       
        const response = await host.post('appointment/new-mechanic',mechanic)
    }
    async function createItem(item){
        const response = await host.post('items/new',item)
    }
    async function items(){
        const response = await host.get('/items/all')
        return response
    }
    async function deleteBooking(booking){
        const response = await host.delete('appointment/delete-appointment',{params:{idAp:booking.idAp}})
    }
    async function deleteMechanic(mechanic){
        console.log(mechanic)
        const response = await host.delete('appointment/delete-mechanic',{params:{idMech:mechanic.idmech}})
    }
    async function deleteItem(item){
 
        const response = await host.delete('items/delete-item',{params:{idItem:item.idItem}})
    }
    async function mechanics(){
        console.log(user)
        const response = await host.get(`appointment/all-mechanics/`)

        return response.data
    }
    return {createItem,deleteItem,createMechanic,deleteMechanic,mechanics,deleteBooking,bookingsAll,loginAdmin,items,createBooking,login,bookings,register}}