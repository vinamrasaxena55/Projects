import {Routes,Route} from 'react-router';
import { HomePage } from './pages/HomePage';
import { CheckoutPage } from './pages/CheckoutPage';
import { OrdersPage } from './pages/OrdersPage';
import { TrackingPage } from './pages/TrackingPage';
import { useEffect, useState } from 'react';
import axios from 'axios';

import './App.css'

function App() {
  //we put cart here so it can used in multiple places as needed in home
  //page checkout , orders and tracking
     const [cart ,setCart]=useState([]);
     useEffect(()=>{
            axios.get('/api/cart-items')
            .then((response)=>{
              //  console.log(response.data);//returns array of cart//
              setCart(response.data);
            });
     },[]);
    


 
//Routes for combing html done in this and main.jsx
//rout=page, route basically adds page to website
  return (
    <Routes>
    <Route index element={<HomePage cart={cart} />} />
    <Route path="checkout" element={<CheckoutPage cart={cart} />} />
    <Route path="orders" element={<OrdersPage />} />
    <Route path="tracking" element={<TrackingPage />} />
    </Routes>
   
  )
}
// <Route path="/" element={<HomePage />} 
//path="/"  ==>index
//'/' means empty url and what to display on Path is HomePage
//path="checkout" then checkout page displayed
export default App
