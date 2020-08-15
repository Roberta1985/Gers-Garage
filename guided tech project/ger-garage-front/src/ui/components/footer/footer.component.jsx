import React from 'react'
import footerimg from '../../assets/img_footer.jpg'
import './footer.component.css'
import placeimg from '../../assets/location-outline.svg'
import timeimg from '../../assets/time-outline.svg'
import mailimg from '../../assets/mail-outline.svg'
export const Footer = () => {
    return (
        <div className="footer-container">
            <div className="footer-info-container">
                <div className="footer-info">
                    <img src={placeimg}/>
                    35 O'Connel Street
                </div>
                <div className="footer-info">
                <img src={placeimg}/>
                    +353 000000000</div>
                <div className="footer-info"> 
                 <img src={timeimg}/>
                 Monday-Saturday 7:00AM - 6:00PM
                 <br/>
                 Sunday Closed
                 </div>
                <div className="footer-info mail">
                <img src={mailimg}/>
                gersgarage@gmail.com</div>
                <div className="footer-info">icons</div>
            </div>
            <img src={footerimg}/>
        </div>
    )
}
