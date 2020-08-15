import React from 'react'
import './home.screen.css'
import aboutImgOne from '../assets/aboutimg.jpg'
import personOne from '../assets/person-01.jpg'
import personTwo from '../assets/person-02.jpg'
import personThree from '../assets/person-03.jpg'
import personFour from '../assets/person-04.jpg'
import { useContext } from 'react'
export const Home = () => {
  
    return (
        <div className="container-home">
            <div className="title-home"> About <span>Us</span> </div>
            <div  className="about-container">
                <img src={aboutImgOne}/>
                <div >
               Founded in 2000, Ger's Garage is an Automotive Center that has a complete structure with great expertise in automotive repair. Recognized as one of the best and most complete Automotive Centers in Dublin, Ger's Garage also stands out for the quality of the services provided and for the selected team that is constantly improving. In addition to the experienced technical staff, modern equipment ensures final quality and customer satisfaction.
                </div>
            </div>
            <div className="title-home"> Our <span>Services</span> </div>
            <div className="services-container">
                <div className="service">
                    <img src={personOne}/>
                    <div>ANNUAL SERVICE</div>
                    <span>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span>
                </div>
                <div className="service">
                    <img src={personTwo}/>
                    <div>MAJOR SERVICE</div>
                    <span>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span>
                </div>
                <div className="service">
                    <img src={personThree}/>
                    <div>REPAIR / FAULT</div>
                    <span>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span>
                </div>
                <div className="service">
                    <img src={personFour}/>
                    <div>MAJOR REPAIR</div>
                    <span>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</span>
                </div>
            </div>
        </div>
    )
}
