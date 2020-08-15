import React, { useState } from 'react'
import './login.screen.css'
import { useHistory } from 'react-router-dom'
import { useApi } from '../../../hooks/api.hook'
import { useContext } from 'react'
export const Login = () => {
    const [username,setUsername] = useState()
    const [password,setPassword] = useState()
    const api = useApi()
    const history = useHistory();
    function handleChangeUsername(event){
        setUsername(event.target.value)
        console.log(username)
    }
    function handleChangePassword(event){
        setPassword(event.target.value)
        console.log(password)
    }
    function handleRegister(){
        history.push('/register')
    }
    function handleBookings(){
        history.push('/booking')
    }
    async function handleSubmit(){
        const response = await api.login(username,password)
        if(response ==='error'){

        }else{
            history.push('/booking')
        }
    }
    async function handleAdmin(){
        const response = await api.loginAdmin(username,password)
        if(response ==='error'){

        }else{
            history.push('/booking-admin')
        }
    }
    return (
        <div className="container-login">
            <div className="login-title">Login</div>
            <form >
                <input onChange={handleChangeUsername} placeholder="Username"/>
                <input onChange={handleChangePassword} placeholder="Password"/>
            </form>
            <div>
                    <button onClick={handleSubmit} type="submit">CUSTOMER LOGIN</button>
                    <button onClick={handleAdmin}>ADMIN LOGIN</button>
                </div>
           <div> Haven't registered yet? <span onClick={handleRegister}>Click here!</span> </div>
        </div>
        
    )
}
