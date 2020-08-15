import React, { useContext } from 'react'
import './header.component.css'
import search from '../../assets/search-outline.svg'
import { useHistory } from 'react-router-dom'
export const Header = ({screen,admin}) => {
    const history = useHistory()
    function handleActivePage(link){
        history.push(link)
    }

    return (
        <div>
        {!admin === true ?
        <div>
        <div className="header-container">
            <span>Ger's Garage</span>
        </div>
        <div  className="menu-container">
            <div className="menu-navigation">
            <div onClick={()=>handleActivePage('/')} className={screen =='home'? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Home</div>
                <div className="nav-button-slide">
                </div>
            </div>
            <div onClick={()=>handleActivePage('/gallery')} className={screen =='gallery'? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Shop</div>
                <div className="nav-button-slide">
                </div>
            </div>
            <div onClick={()=>handleActivePage('/login')} className={screen =='booking'? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Booking</div>
                <div className="nav-button-slide">
                </div>
            </div>

            </div>
            <div className="menu-img-container">
            <img className="search-img" src={search}/>
            <input className="search-input" placeholder="Search..."></input>
            </div>
        </div>
        </div>
        :
        <div>
        <div className="header-container">
            <span>Ger's Garage</span>
        </div>
        <div  className="menu-container">
            <div className="menu-navigation">
            <div onClick={()=>handleActivePage('/mechanics')} className={screen ==''? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Mechanics</div>
                <div className="nav-button-slide">
                </div>
            </div>
            <div onClick={()=>handleActivePage('/admin-shop')} className={screen =='admin-shop'? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Shop</div>
                <div className="nav-button-slide">
                </div>
            </div>
            <div onClick={()=>handleActivePage('/booking-admin')} className={screen =='booking-admin'? "nav-button active" : "nav-button"}>
                <div className="nav-button-text">Booking</div>
                <div className="nav-button-slide">
                </div>
            </div>

            </div>
            <div className="menu-img-container">
            <img className="search-img" src={search}/>
            <input className="search-input" placeholder="Search..."></input>
            </div>
        </div>
        </div>
        }
        </div>
       
    )
}
