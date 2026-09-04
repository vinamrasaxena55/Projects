import {Routes,Route} from 'react-router';
import { HomePage } from './pages/HomePage';
import { CheckoutPage } from './pages/CheckoutPage';

import './App.css'

function App() {
 
//Routes for combing html done in this and main.jsx
//rout=page, route basically adds page to website
  return (
    <Routes>
    <Route index element={<HomePage />} />
    <Route path="checkout" element={<CheckoutPage />} />
    </Routes>
   
  )
}
// <Route path="/" element={<HomePage />} 
//path="/"  ==>index
//'/' means empty url and what to display on Path is HomePage
//path="checkout" then checkout page displayed
export default App
