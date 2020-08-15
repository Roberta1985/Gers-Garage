import React from 'react'
import { useApi } from '../../../hooks/api.hook'
import { useState,useEffect } from 'react'

export const BookingAdmin = () => {
    const backEnd = useApi()
    const [bookings,setBookings] = useState([])
    useEffect( () => {
        setsBookings()
    }, [])

    async function setsBookings(){
        let response = await backEnd.bookingsAll()
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
        <div style={{minHeight:'400px'}}>
            {bookingsList}
        </div>
    )
}
