import React, { useContext, useEffect } from 'react';
import './App.css';
import { Header } from './ui/components/header/header.component';
import { Footer } from './ui/components/footer/footer.component';

import {
  BrowserRouter,
  Switch,
  Route,
  Link,
  Redirect
} from "react-router-dom";
import { Home } from './ui/screens/home.screen';
import { Login } from './ui/screens/login.screen/login.screen';
import { register } from './serviceWorker';
import { Register } from './ui/screens/register/register.screen';
import { Booking } from './ui/screens/booking/booking.screen';
import { Shop } from './ui/screens/shop/shop.screen';
import { BookingAdmin } from './ui/screens/booking-admin/booking-admin.screen';
import {AdminShop} from './ui/screens/admin-shop/admin-shop'
import { Mechanics } from './ui/screens/mechanics/mechanics.screen';
function App() {

  

  return (
    <>

      <BrowserRouter>
      <Switch>
          <Route exact path="/">
            <Header screen='home' />
            <Home/>
            <Footer/>
          </Route>
          <Route exact path="/gallery">
            <Header screen='gallery' />
            <Shop/>
            <Footer/>
          </Route>
          <Route exact path="/booking">
            <Header screen='booking' />

            <Booking></Booking>
            
            <Footer/>
          </Route>
          <Route exact path="/contacts">
            <Header screen='contacts' />
            <Footer/>
          </Route>
          <Route exact path="/register">
            <Header screen='booking' />
            <Register/>
            <Footer/>
          </Route>
          <Route exact path="/login">
            <Header screen='booking' />
            <Login/>
            <Footer/>
          </Route>
          <Route exact path="/">
            <Header screen='home' />
            <Footer/>
          </Route>
          <Route exact path="/booking-admin">
            <Header admin='true' screen='home' />
              <BookingAdmin/>
            <Footer/>
          </Route>
          <Route exact path="/admin-shop">
            <Header admin='true' screen='home' />
              <AdminShop/>
            <Footer/>
          </Route>
          <Route exact path="/mechanics">
            <Header admin='true' screen='home' />
              <Mechanics/>
            <Footer/>
          </Route>
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
