import React ,{useEffect} from 'react'
import { useContext } from 'react'
import { Login } from '../login.screen/login.screen'
import './booking.screen.css'
import { useApi } from '../../../hooks/api.hook'
import { useState } from 'react'
export const Booking = () => {
    const backEnd = useApi();
    let [bookings,setBookings] = useState([])
    const [vehicleType,setVehicleType] = useState()
    const [vehicleMake,setVehicleMake] = useState()
    const [service,setService] = useState()
    const [date,setDate] = useState()
    const [cmt,setCmt] = useState()
    const [vehicleLicense,setVehicleLicense] = useState()
    useEffect( () => {
        setsBookings()
    }, [])

    async function setsBookings(){
        let response = await backEnd.bookings()
       setBookings(response)
       console.log(bookings)
    }
    async function deleteBooking(booking){
        const response = await backEnd.deleteBooking(booking)
    }
    let bookingsList = bookings.map(booking =>{
        return (<div>
            <div className='booking-date-container'>
                <div>{booking.dateAp[0]}/{booking.dateAp[1]}/{booking.dateAp[2]}</div>
                <div>{booking.dateAp[3]}:{booking.dateAp[4]}hrs</div>
                <a onClick={() => deleteBooking(booking)} className='booking-cancel'>Cancel</a>
            </div>
            
            </div>)
    })
    return (
        <div className='booking-container'>
            <div className='booking-list-container'>
                <div className="upcoming-container">
                <div>UPCOMING APPOINTMENTS</div>
                     <div>{bookingsList}</div>
                </div>
            </div>
            <div className='booking-create-container'>
                <div>Register</div>
                <div>
                    <div className='booking-selects'>
                    <select onChange={event => setVehicleMake(event.target.value)}>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                    </select>
                    <select onChange={event => setVehicleType(event.target.value)}>
                        <option >a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                    </select>
                    <select onChange={event => setService(event.target.value)}>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                        <option>a</option>
                    </select>
                    <input onChange={event => setDate(event.target.value)}type='datetime-local'/>
                    </div>
                    <div className='booking-inputs'>
                    <input onChange={event => setCmt(event.target.value)} class='comment'></input>
                    <div>
                    <input onChange={event => setVehicleLicense(event.target.value)}></input>
                    <button onClick={()=>backEnd.createBooking(  {
                                                                    "vehicleType": vehicleType,
                                                                    "vehicleMake": vehicleMake,
                                                                    "vehicleEngineType": "gas",
                                                                    "vehicleLicense": vehicleLicense
                                                                },cmt,date)}>SUBMIT</button>
                    </div>
                    </div>
                    
                </div>
            </div>
        </div>
    )
}
