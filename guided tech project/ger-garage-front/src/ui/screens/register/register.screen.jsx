import React,{useState} from 'react'
import { useHistory } from 'react-router-dom'
import { useApi } from '../../../hooks/api.hook'

export const Register = () => {
    const history = useHistory()
    const [name,setName] = useState()
    const [user,setUser] = useState()
    const [email,setEmail] = useState()
    const [phone,setPhone] = useState()
    const [pw,setPw] = useState()

    function handleChangeName(event){
        setName(event.target.value)
    }
    function handleChangeUser(event){
        setUser(event.target.value)
    }
    function handleChangeEmail(event){
        setEmail(event.target.value)
    }
    function handleChangePhone(event){
        setPhone(event.target.value)
    }
    function handleChangePw(event){
        setPw(event.target.value)
    }
    const api = useApi()
    function handleLogin(){
        history.push('/booking')
    }
    async function handleSubmit(){
        const retorno = await api.register(name,user,email,phone,pw)
    }
    return (
        <div className="container-login">
        <div className="login-title">Register</div>
        <form>
            <input onChange={handleChangeName} placeholder="Full Name"/>
            <input onChange={handleChangeUser}  placeholder="Username"/>
            <input onChange={handleChangeEmail}  placeholder="Email"/>
            <input onChange={handleChangePhone}  placeholder="Phone Number"/>
            <input onChange={handleChangePw}  placeholder="Password" type="password"/>
        </form>
        <div>
                <button onClick={handleSubmit}>SUBMIT</button>
                
            </div>
    </div>
    )
}
